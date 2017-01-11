package br.com.walmart.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmObject;

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

}
