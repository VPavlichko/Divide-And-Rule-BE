package odium.dar.DarServer.game.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Player {
    private int id;
    private String name;
    private List<Card> cards;

}
