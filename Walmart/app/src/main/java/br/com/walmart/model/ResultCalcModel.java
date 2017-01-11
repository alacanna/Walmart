package br.com.walmart.model;


import java.io.Serializable;
import java.util.List;

/**
 * Created by amandalacanna on 1/8/17.
 */

public class ResultCalcModel implements Serializable{
    public static final long  serialVersionUID = 1L;

    private List<Edge> lstEdge;
    private String map;
    private String originPoint;
    private String destinationPoint;

    private double truckAut;
    private int totalDistance;
    private double price;

    private double totalCost;

    public ResultCalcModel() {
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public List<Edge> getLstEdge() {
        return lstEdge;
    }

    public void setLstEdge(List<Edge> lstEdge) {
        this.lstEdge = lstEdge;
    }

    public String getPontoDeOrigem() {
        return originPoint;
    }

    public void setPontoDeOrigem(String pontoDeOrigem) {
        this.originPoint = pontoDeOrigem;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public double getTruckAut() {
        return truckAut;
    }

    public void setTruckAut(double truckAut) {
        this.truckAut = truckAut;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalCost() {
        return (totalDistance / truckAut) * price;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "CalcModel{" +
                "lstEdge=" + lstEdge +
                ", map='" + map + '\'' +
                ", originPoint='" + originPoint + '\'' +
                ", destinationPoint='" + destinationPoint + '\'' +
                ", truckAut=" + truckAut +
                ", totalDistance=" + totalDistance +
                ", price=" + price +
                ", totalCost=" + totalCost +
                '}';
    }
}
