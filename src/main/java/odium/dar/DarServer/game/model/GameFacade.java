package odium.dar.DarServer.game.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class GameFacade {

    Board board;

    public GameFacade(Board board) {
        this.board = board;
    }

    public void addVertex(Vertex vertex) {
        board.getGraph().addVertex(vertex);
    }

    public Optional<Vertex> getVertex(Vertex vertex) {
        return board.getGraph().vertexSet().stream().filter(x -> x.getVertexId() == vertex.getVertexId())
                .findAny();
    }

    public void onDiceRoll() {
        int diceRoll = 5;
    //    board.getGraph().vertexSet().stream().map(Vertex::getTiles).forEach(x -> Arrays.stream(x.stream().filter(tile -> tile.getQuantity() == diceRoll).toArray()));
        //      board.getGraph().vertexSet().stream().filter(x->x.getTiles().contains(diceRoll)).toArray();
//        board.getGraph().vertexSet().stream().map(Vertex::getTiles).forEach(x -> x.stream().filter(tile -> tile.getQuantity()==diceRoll).map(Vertex::getPlayerId));
//        System.out.println(   board.getGraph().vertexSet().stream().map(Vertex::getTiles).forEach(x -> x.stream().filter(tile -> tile.getQuantity()==diceRoll)));
       List<Integer> list= board.getGraph().vertexSet().stream().flatMap(root -> root.getTiles()
                .stream()
                .filter(nested -> nested.getQuantity() == diceRoll)
                .map(filteredElement -> root.getPlayerId())).toList();
    }
}
