package br.com.walmart.model;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

/**
 * Created by amandalacanna on 1/6/17.
 */

public class PointModel extends RealmObject {

    @SerializedName("pontoDeOrigem")
    private String originPoint;
    @SerializedName("pontoDeDestino")
    private String destinationPoint;
    @SerializedName("distancia")
    private int distance;


    public PointModel() {
    }

    public PointModel(String originPoint, String destinationPoint, int distance) {
        this.originPoint = originPoint;
        this.destinationPoint = destinationPoint;
        this.distance = distance;
    }

    public String getOriginPoint() {
        return originPoint;
    }

    public void setOriginPoint(String originPoint) {
        this.originPoint = originPoint;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "PontoModel{" +
                "originPoint='" + originPoint + '\'' +
                ", destinationPoint='" + destinationPoint + '\'' +
                ", distance=" + distance +
                '}';
    }
}
