package br.com.walmart.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.walmart.exception.PathNotFoundException;

/**
 * Created by amandalacanna on 1/10/17.
 */

public class DijkstraAlgorithm {
    private final List<Edge> edges;
    private Set<Vertex> settledNodes;
    private Set<Vertex> unSettledNodes;
    private Map<Vertex, Vertex> predecessors;
    private Map<Vertex, Integer> distance;
    private Vertex source;

    public DijkstraAlgorithm(Graph graph) {
        this.edges = new ArrayList<>(graph.getEdges());
    }

    public DijkstraAlgorithm execute(Vertex source) throws PathNotFoundException {
        this.source = source;
        settledNodes = new HashSet<>();
        unSettledNodes = new HashSet<>();
        distance = new HashMap<>();
        predecessors = new HashMap<>();
        distance.put(source, 0);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
            Vertex node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
        return this;
    }


    private void findMinimalDistances(Vertex node) throws PathNotFoundException {
        List<Vertex> adjacentNodes = getNeighbors(node);
        for (Vertex target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node) + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }
    }

    private List<Vertex> getNeighbors(Vertex node) {
        List<Vertex> neighbors = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private Vertex getMinimum(Set<Vertex> vertexes) {
        Vertex minimum = null;
        for (Vertex vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Vertex vertex) {
        return settledNodes.contains(vertex);
    }

    private int getShortestDistance(Vertex destination) {
        Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    public LinkedList<Vertex> getPath(Vertex target) throws PathNotFoundException {

        if (target != null) {
            LinkedList<Vertex> path = new LinkedList<>();
            if (target.equals(source)) {
                path.add(target);
                return path;
            }

            Vertex step = target;
            if (predecessors.get(step) == null)
                throw new PathNotFoundException();

            path.add(step);
            while (predecessors.get(step) != null) {
                step = predecessors.get(step);
                path.add(step);
            }

            Collections.reverse(path);
            return path;
        }
        throw new PathNotFoundException();
    }

    public int getDistance(Vertex vertex) throws PathNotFoundException {
        if (vertex == null || distance == null)
            throw new IllegalArgumentException("Destination vertex can not be null");
        if(distance.get(vertex) == null) {
            throw new PathNotFoundException();
        }
        return distance.get(vertex);
    }

    private int getDistance(Vertex from, Vertex to) throws PathNotFoundException {
        for (Edge edge : edges) {
            if (edge.getSource().equals(from) && edge.getDestination().equals(to)) {
                return edge.getWeight();
            }
        }
        throw new PathNotFoundException();
    }

    public int getShortestPathLength(Vertex from, Vertex to) throws PathNotFoundException {
        if (from == null || to == null)
            throw new IllegalArgumentException("Source and destination vertices can not be null");
        return getPath(to).size();
    }


    //Método adaptado para pegar a rota mais curta.
    public List<Edge> getPathAndWeight(Vertex to) throws PathNotFoundException {
        ArrayList<Edge> finalMap = new ArrayList<>();

        Vertex from = null;
        LinkedList<Vertex> path = getPath(to);

        for (int i = 0; i < path.size()-1; i++) {
            from = path.get(i);
            to = path.get(i+1);

            Edge edge = new Edge(from,to,getDistance(from,to));
            finalMap.add(edge);
        }
        return finalMap;
    }

}
