package odium.dar.DarServer.game.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleGraph;

import java.util.Map;

@Data
@NoArgsConstructor
public class Board {
    @Override
    public String toString() {
        return "Board{" +
                "graph=" + graph +
                '}';
    }

    //    private Map<Integer, Tile> map;
//    Graph<Vertex, Road> g;
    Graph<Vertex, Road> graph = new SimpleGraph<>(Road.class);
}
