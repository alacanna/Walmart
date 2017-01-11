package br.com.walmart.ui.home;

import java.util.List;

import br.com.walmart.model.MapModel;
import br.com.walmart.model.PontoModel;
import io.realm.RealmResults;

/**
 * Created by amandalacanna on 1/9/17.
 */

public interface HomeModel {
    RealmResults<MapModel> getMapsList();
    List<String> originPointList(String map);
    List<String> destinationPointList(String map);

}
