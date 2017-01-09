package br.com.walmart.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by amandalacanna on 1/8/17.
 */

public class JsonModel {
    @SerializedName("map")
    private List<MapModel> map;

    public List<MapModel> getMap() {
        return map;
    }

    public void setMap(List<MapModel> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "JsonModel{" +
                "map=" + map +
                '}';
    }
}
