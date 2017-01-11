package br.com.walmart.ui.home;


import java.util.ArrayList;
import java.util.List;

import br.com.walmart.model.MapModel;
import br.com.walmart.model.PointModel;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by amandalacanna on 1/9/17.
 */

public class HomeModelImpl implements HomeModel {
    private Realm realm;
    private HomePresenter.ModelPresenter presenter;

    public HomeModelImpl(HomePresenter.ModelPresenter presenter) {
        this.presenter = presenter;
        this.realm = Realm.getDefaultInstance();
    }

    @Override
    public RealmResults<MapModel> getMapsList() {
        return realm.where(MapModel.class).findAll();
    }

    public List<String> originPointList(String map){
        MapModel mapModel = realm.where(MapModel.class).equalTo("map", map).findFirst();
        List<PointModel> listPoints = mapModel.getLstPoints();
        List<String> strPoint = new ArrayList<>();

        for(PointModel point : listPoints){
            if(!strPoint.contains(point.getOriginPoint()))
                strPoint.add(point.getOriginPoint());
        }

        return strPoint;
    }

    @Override
    public List<String> destinationPointList(String map) {
        MapModel mapModel = realm.where(MapModel.class).equalTo("map", map).findFirst();
        List<PointModel> listPoints = mapModel.getLstPoints();
        List<String> strPoint = new ArrayList<>();

        for(PointModel point : listPoints){
            if(!strPoint.contains(point.getDestinationPoint()))
                strPoint.add(point.getDestinationPoint());
        }

        return strPoint;
    }
}
