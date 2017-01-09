package br.com.walmart.ui.splash;

/**
 * Created by amandalacanna on 1/9/17.
 */

public interface SplashPresenter {
    interface ViewPresenter {
        void saveJsonToRealm();
    }

    interface ModelPresenter {
        void onSuccessSaveJson();
        void onError(String message);
    }
}
