package lk.my.assignment.dto;

import java.time.LocalDate;
import java.util.Set;

public class SignupRequest {

    private  String username;
    private  String  email;
    private String fullName;
    private LocalDate dob;
    private  String password;
    private Set<String> roles;

    public SignupRequest() {
    }

    public SignupRequest(String username, String email, String fullName, LocalDate dob, String password, Set<String> roles) {
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.dob = dob;
        this.password = password;
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
