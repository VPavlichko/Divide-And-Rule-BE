package odium.dar.DarServer.game.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Vertex {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return vertexId == vertex.vertexId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexId);
    }

    public Vertex(int vertexId, int playerId, boolean isPort, boolean isEmpty) {
        this.vertexId = vertexId;
        this.playerId = playerId;
        this.isPort = isPort;
        this.isEmpty = isEmpty;
        this.tiles = new ArrayList<>();
    }

    public Vertex(int vertexId, int playerId, boolean isPort, boolean isEmpty, List<Tile> tiles) {
        this.vertexId = vertexId;
        this.playerId = playerId;
        this.isPort = isPort;
        this.isEmpty = isEmpty;
        this.tiles = tiles;
    }

    private int vertexId;
    private int playerId;
    private boolean isPort;
    private boolean isEmpty;
    private List<Tile> tiles;

}
