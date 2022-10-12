package odium.dar.DarServer.game.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import odium.dar.DarServer.game.model.enums.ECardType;

import java.util.List;

@Data
@AllArgsConstructor
public class Tile {
    private ECardType type; ///TODO ENUM (BRICK/ ORE / WHEAT / WOOD / LAMB)
    private int quantity; // chance of drop
//    private List<Road> surroundingRoads;
}
