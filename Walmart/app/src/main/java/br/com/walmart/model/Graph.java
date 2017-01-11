package br.com.walmart.model;

import java.util.List;

/**
 * Created by amandalacanna on 1/10/17.
 */

public class Graph {
    private final List<Edge> edges;

    public Graph(List<Edge> edges) {
        this.edges = edges;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
