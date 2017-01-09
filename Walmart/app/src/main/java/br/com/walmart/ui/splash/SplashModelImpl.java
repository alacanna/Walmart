package br.com.walmart.ui.splash;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import br.com.walmart.model.JsonModel;
import io.realm.Realm;

/**
 * Created by amandalacanna on 1/9/17.
 */

public class SplashModelImpl implements SplashModel {
    private Realm realm;
    private SplashPresenter.ModelPresenter presenter;


    public SplashModelImpl(SplashPresenter.ModelPresenter presenter) {
        this.presenter = presenter;
        this.realm = Realm.getDefaultInstance();
    }

    @Override
    public void jsonPersist(final String strJson) {

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override public void execute(Realm realm) {

                JsonModel json = new Gson().fromJson(strJson, JsonModel.class);
                realm.insertOrUpdate(json.getMap());

            }
        }, new Realm.Transaction.OnSuccess() {
            @Override public void onSuccess() {
                presenter.onSuccessSaveJson();
            }
        }, new Realm.Transaction.OnError() {
            @Override public void onError(Throwable error) {
                presenter.onError(String.valueOf(error.getMessage()));
            }
        });


    }
}
