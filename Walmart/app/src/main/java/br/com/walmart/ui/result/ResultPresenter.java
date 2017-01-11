package br.com.walmart.ui.result;

/**
 * Created by amandalacanna on 1/10/17.
 */

public class ResultPresenter {
    interface ViewPresenter {
        void getShortestRout();
    }

    interface ModelPresenter {
        void onError(String message);
    }

}
