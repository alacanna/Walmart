package br.com.walmart.ui.splash;

import java.lang.ref.WeakReference;
import br.com.walmart.helper.Helper;

/**
 * Created by amandalacanna on 1/9/17.
 */

public class SplashPresenterImpl implements SplashPresenter.ViewPresenter, SplashPresenter.ModelPresenter{

    private WeakReference<SplashView> mView;
    private SplashModel mModel;


    public SplashPresenterImpl(SplashView mView) {
        this.mView = new WeakReference<>(mView);
        mModel = new SplashModelImpl(this);
    }

    @Override
    public void onSuccessSaveJson() {
        mView.get().goToHome();
    }

    @Override
    public void onError(String message) {
        mView.get().showMessageError(message);
    }

    @Override
    public void saveJsonToRealm() {
        mModel.jsonPersist(Helper.loadJsonFromRaw(mView.get().getResources()));
    }

}
