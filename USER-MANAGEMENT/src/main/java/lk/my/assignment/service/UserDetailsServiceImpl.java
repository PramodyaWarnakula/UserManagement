package lk.my.assignment.service;

import lk.my.assignment.dto.ResponseObject;
import lk.my.assignment.dto.SignupRequest;
import lk.my.assignment.entities.Role;
import lk.my.assignment.entities.User;
import lk.my.assignment.repositories.RoleRepository;
import lk.my.assignment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        User user =userRepository.findByUsername(username);
        UserDetailsImpl impl = new UserDetailsImpl();
        return impl.build(user);
    }

    public ResponseObject createNewUserAccount(SignupRequest sr) throws Exception{


        User user = new User();
        Set<String>roles = sr.getRoles();
        List<Role> roleList = roleRepository.findAll();
        Set<Role>list = new HashSet<>();
        roles.forEach(i->{
            Role role = getRole(i, roleList);
            list.add(role);
        });

        user.setRoles(list);
        user.setEmail(sr.getEmail());
        user.setUsername(sr.getUsername());
        user.setPassword(encoder.encode(sr.getPassword()));

        userRepository.save(user);
        return  new ResponseObject(200,"OK");
    }

    private Role getRole(String roleName,List<Role>roleList){


        for (Role r:roleList) {
            if(r.getName().equals(roleName)){
                return r;
            }
        }
        throw new RuntimeException("Error Unkown Role Found....... Devoloper Create Exception.....");
    }

    public List<User> getAllUsers()throws Exception{
        return userRepository.findAll();
    }

    public Object getfindUserByUserName(String userName) throws Exception{
       return userRepository.findByUsername(userName);
    }
}