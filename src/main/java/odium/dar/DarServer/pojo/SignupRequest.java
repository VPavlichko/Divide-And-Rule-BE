package odium.dar.DarServer.pojo;

import lombok.Data;

import java.util.Set;

@Data
public class SignupRequest {

    public SignupRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    private String username;
    private String email;
//    private Set<String> roles;
    private String password;
}
