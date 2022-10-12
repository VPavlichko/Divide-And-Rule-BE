package odium.dar.DarServer.game.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import odium.dar.DarServer.game.model.enums.ECardType;

@Data
@AllArgsConstructor
public class Card {
    private ECardType type;
}
