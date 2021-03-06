package lk.my.assignment.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(	name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 70)
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @Column(length = 1,nullable = false)
    private String status;

    @Column(length = 80)
    private String fullName;

    private LocalDate dob;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 70) @Email String email, @NotBlank @Size(max = 120) String password, String status, String fullName, LocalDate dob, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
        this.fullName = fullName;
        this.dob = dob;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}