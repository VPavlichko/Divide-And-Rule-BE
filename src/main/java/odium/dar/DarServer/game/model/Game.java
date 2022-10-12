package odium.dar.DarServer.game.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import odium.dar.DarServer.model.User;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Data
//@Component
@AllArgsConstructor
public class Game {
    private List<Player> players;
    private Board gameBoard;
}
