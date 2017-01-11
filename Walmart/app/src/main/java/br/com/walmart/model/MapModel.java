package br.com.walmart.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by amandalacanna on 1/8/17.
 */

public class MapModel extends RealmObject {
    @PrimaryKey
    private Long idMap;

    @SerializedName("pontos")
    private RealmList<PointModel> lstPoints;

    @SerializedName("estado")
    private String map;

    public MapModel() {
    }

    public MapModel(RealmList<PointModel> lstPoints, String map) {
        this.lstPoints = lstPoints;
        this.map = map;
    }

    public Long getIdMap() {
        return idMap;
    }

    public void setIdMap(Long idMap) {
        this.idMap = idMap;
    }

    public List<PointModel> getLstPoints() {
        return lstPoints;
    }

    public void setLstPoints(RealmList<PointModel> lstPoints) {
        this.lstPoints = lstPoints;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

}
