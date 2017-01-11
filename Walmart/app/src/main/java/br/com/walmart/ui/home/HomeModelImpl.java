package br.com.walmart.ui.home;


import java.util.ArrayList;
import java.util.List;

import br.com.walmart.model.MapModel;
import br.com.walmart.model.PontoModel;
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
        List<PontoModel> listPoints = mapModel.getListaDePontos();
        List<String> strPoint = new ArrayList<>();

        for(PontoModel point : listPoints){
            if(!strPoint.contains(point.getPontoDeOrigem()))
                strPoint.add(point.getPontoDeOrigem());
        }

        return strPoint;
    }

    @Override
    public List<String> destinationPointList(String map) {
        MapModel mapModel = realm.where(MapModel.class).equalTo("map", map).findFirst();
        List<PontoModel> listPoints = mapModel.getListaDePontos();
        List<String> strPoint = new ArrayList<>();

        for(PontoModel point : listPoints){
            if(!strPoint.contains(point.getPontoDeDestino()))
                strPoint.add(point.getPontoDeDestino());
        }

        return strPoint;
    }
}
