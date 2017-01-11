package br.com.walmart.model;

/**
 * Created by amandalacanna on 1/10/17.
 */

public class Edge {

    private final Vertex originPoint;
    private final Vertex destinationPoint;
    private final int distance;

    public Edge(Vertex originPoint, Vertex destinationPoint, int distance) {
        this.originPoint = originPoint;
        this.destinationPoint = destinationPoint;
        this.distance = distance;
    }

    public Vertex getDestinationPoint() {
        return destinationPoint;
    }

    public Vertex getOriginPoint() {
        return originPoint;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return originPoint + " -(" + distance + ")- " + destinationPoint;
    }

}
