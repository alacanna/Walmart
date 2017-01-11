package br.com.walmart.ui.home;

import java.lang.ref.WeakReference;
import java.util.List;

import br.com.walmart.model.MapModel;


/**
 * Created by amandalacanna on 1/9/17.
 */

public class HomePresenterImpl implements HomePresenter.ViewPresenter, HomePresenter.ModelPresenter{

    private WeakReference<HomeView> mView;
    private HomeModel mModel;


    public HomePresenterImpl(HomeView mView) {
        this.mView = new WeakReference<>(mView);
        mModel = new HomeModelImpl(this);
    }

    @Override
    public void onError(String message) {
        mView.get().showMessageError(String.valueOf(message));
    }

    @Override
    public void validateFields(String autonomia, String valor, String map, String originPoint, String destinationPoint) {
        double dAutonomia, dValor;

        if ((autonomia == null || valor == null) || (autonomia.isEmpty() || valor.isEmpty())){
            dAutonomia = 0D;
            dValor = 0D;
        }else {
            dAutonomia = Double.parseDouble(autonomia);
            dValor = Double.parseDouble(valor);
        }

        if(dAutonomia == 0D || dValor == 0D){
            mView.get().showMessageError("Por favor preencha todos os campos para efetuar o cálculo");
        }else{
            mView.get().goToResults(dAutonomia, dValor, map, originPoint,destinationPoint);
        }

    }

    @Override
    public List<MapModel> getMap() {
        return mModel.getMapsList();
    }

    @Override
    public List<String> getOriginPoints(String map) {
        return mModel.originPointList(map);
    }

    @Override
    public List<String> getDestinationPoints(String map) {
        return mModel.destinationPointList(map);
    }

}
