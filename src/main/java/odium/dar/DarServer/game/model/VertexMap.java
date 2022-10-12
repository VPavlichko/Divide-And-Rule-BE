package odium.dar.DarServer.game.model;

import lombok.Data;

import java.util.HashMap;

public class VertexMap extends HashMap<Vertex, Tile> {
    private Vertex vertex;

    @Override
    public boolean equals(Object o) {
        return  o == this.get(o);
    }

    @Override
    public int hashCode() {
        return vertex.getVertexId();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
