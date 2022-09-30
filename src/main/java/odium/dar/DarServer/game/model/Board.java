package odium.dar.DarServer.game.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder(toBuilder = true)
public class Board {
    private Map<Integer, Tile> map;

}
