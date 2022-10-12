package odium.dar.DarServer.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import odium.dar.DarServer.game.model.*;
import odium.dar.DarServer.game.model.enums.ECardType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RunGame {
    public static void main(String[] args) {
        Card brick = new Card(ECardType.BRICK);
        Card wood = new Card(ECardType.WOOD);
        Card wheat = new Card(ECardType.WHEAT);
        Card lamb = new Card(ECardType.LAMB);
        Card ore = new Card(ECardType.ORE);


        List<Card> cards1 = new ArrayList<>();
        cards1.add(brick);


        Player player1 = new Player(1, "Mario", cards1);
        Player player2 = new Player(2, "Luigi", new ArrayList<>());
        List<Player> playerList = new LinkedList<>();
        playerList.add(player1);
        playerList.add(player2);


        Board board = new Board();
        GameFacade gameFacade = new GameFacade(board);
        Game game = new Game(playerList, board);
        Vertex v = new Vertex(1, 1, true, true, List.of(new Tile(ECardType.BRICK,5),new Tile(ECardType.ORE,5)));

        gameFacade.addVertex(v);
        System.out.println(board.getGraph().containsVertex(v));
        System.out.println(board.toString());
        Vertex v2 = new Vertex(2, 2, true, true,List.of(new Tile(ECardType.WOOD,5),new Tile(ECardType.ORE,2)));
        gameFacade.addVertex(v2);
        gameFacade.getVertex(v2).ifPresent(x -> x.setEmpty(false));
        System.out.println(board.toString());
        gameFacade.onDiceRoll();

        @Data
        @AllArgsConstructor
        class RootElement {
            private String name;
            private List<String> nestedElements;

            //getters / setters and constructors
        }
        List<RootElement> elements = Arrays.asList(
                new RootElement("first", Arrays.asList("one", "two", "three")),
                new RootElement("second", Arrays.asList("four", "one", "two")));
        String filterParam = "four";
        List<RootElement> filtered = elements.stream()
                .flatMap(root -> root.getNestedElements()
                        .stream()
                        .filter(nested -> nested.equalsIgnoreCase(filterParam))
                        .map(filteredElement -> new RootElement(root.getName(), root.getNestedElements()))).toList();
        filtered.forEach(System.out::println);


    }
}

