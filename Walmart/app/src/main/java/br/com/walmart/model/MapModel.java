package br.com.walmart.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by amandalacanna on 1/8/17.
 */

public class MapModel extends RealmObject {

    @SerializedName("pontos")
    private RealmList<PontoModel> listaDePontos;

    @SerializedName("estado")
    private String map;

    public MapModel() {
    }

    public MapModel(RealmList<PontoModel> listaDePontos, String map) {
        this.listaDePontos = listaDePontos;
        this.map = map;
    }

    public List<PontoModel> getListaDePontos() {
        return listaDePontos;
    }

    public void setListaDePontos(RealmList<PontoModel> listaDePontos) {
        this.listaDePontos = listaDePontos;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

}
