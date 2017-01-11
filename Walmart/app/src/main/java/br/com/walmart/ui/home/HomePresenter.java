package br.com.walmart.ui.home;

import java.util.List;

import br.com.walmart.model.MapModel;

/**
 * Created by amandalacanna on 1/9/17.
 */

public interface HomePresenter {
    interface ViewPresenter {
        void validateFields(String autonomia, String valor, String map, String originPoint, String destinationPoint);
        List<MapModel> getMap();
        List<String> getOriginPoints(String map);
        List<String> getDestinationPoints(String map);

    }

    interface ModelPresenter {
        void onError(String message);
    }

}
