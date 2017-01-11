package br.com.walmart.ui.result;


import java.lang.ref.WeakReference;
import java.util.List;

import br.com.walmart.helper.Helper;
import br.com.walmart.model.Edge;
import br.com.walmart.model.Vertex;

/**
 * Created by amandalacanna on 1/10/17.
 */

public class ResultPresenterImpl implements ResultPresenter.ModelPresenter,ResultPresenter.ViewPresenter {
    private WeakReference<ResultView> mView;
    private ResultModel mModel;

    public ResultPresenterImpl(ResultView mView) {
        this.mView = new WeakReference<>(mView);
        mModel = new ResultModelImpl(this);
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void getShortestRout() {
        List<Edge> map = mModel.getMap(mView.get().getIntent().getExtras().getString(Helper.MAP));

        mView.get().setViewsInformation(mModel.getResult(map,
                new Vertex(mView.get().getIntent().getExtras().getString(Helper.ORIGIN_POINT)),
                new Vertex(mView.get().getIntent().getExtras().getString(Helper.DESTINATION_POINT)),
                mView.get().getIntent().getExtras().getDouble(Helper.AUTONOMIA),
                mView.get().getIntent().getExtras().getDouble(Helper.VALOR),
                mView.get().getIntent().getExtras().getString(Helper.MAP)
        ));
    }

}
