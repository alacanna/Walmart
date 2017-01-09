package br.com.walmart.model;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

/**
 * Created by amandalacanna on 1/6/17.
 */

public class PontoModel extends RealmObject {
    @SerializedName("pontoDeOrigem")
    private String pontoDeOrigem;
    @SerializedName("pontoDeDestino")
    private String pontoDeDestino;
    @SerializedName("distancia")
    private double distancia;

    public PontoModel() {
    }

    public PontoModel(String pontoDeOrigem, String pontoDeDestino, double distancia) {
        this.pontoDeOrigem = pontoDeOrigem;
        this.pontoDeDestino = pontoDeDestino;
        this.distancia = distancia;
    }

    public String getPontoDeOrigem() {
        return pontoDeOrigem;
    }

    public void setPontoDeOrigem(String pontoDeOrigem) {
        this.pontoDeOrigem = pontoDeOrigem;
    }

    public String getPontoDeDestino() {
        return pontoDeDestino;
    }

    public void setPontoDeDestino(String pontoDeDestino) {
        this.pontoDeDestino = pontoDeDestino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}
