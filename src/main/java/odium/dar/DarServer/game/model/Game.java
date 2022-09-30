package odium.dar.DarServer.game.model;

import lombok.Builder;
import lombok.Data;
import odium.dar.DarServer.model.User;

import java.util.LinkedList;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class Game {
    private List<User> players = new LinkedList<>();
    private Board gameBoard;
}
