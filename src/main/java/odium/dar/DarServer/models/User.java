package odium.dar.DarServer.models;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Component
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Table(name = "\"user\"")
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "email", nullable = false)
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

}
