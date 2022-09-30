package odium.dar.DarServer.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Table(name = "\"game_history\"")
@Component
@Entity

public class GameHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Timestamp gameEnded;
    private Timestamp gameStarted;

    @ManyToMany(mappedBy = "gameHistory", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<User> players;
    private String map;
}
