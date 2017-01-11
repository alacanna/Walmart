package br.com.walmart.ui.result;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import br.com.walmart.R;
import br.com.walmart.model.CalcModel;
import br.com.walmart.ui.adapters.RoutesAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity implements ResultView{
    @Bind(R.id.rv_route) RecyclerView rvRoutes;
    @Bind(R.id.txt_total) TextView txtTotal;

    private ResultPresenter.ViewPresenter presenter;
    private LinearLayoutManager manager;
    private RoutesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);

        presenter = new ResultPresenterImpl(this);
        presenter.getShortestRout();

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMessageError(String message) {

    }

    @Override
    public void setViewsInformation(CalcModel results) {

        rvRoutes.setHasFixedSize(true);

        manager = new LinearLayoutManager(this);
        rvRoutes.setLayoutManager(manager);

        adapter = new RoutesAdapter(results.getCaminhoMaisCurto());
        rvRoutes.setAdapter(adapter);

        txtTotal.setText(String.format("Total R$ %.2f para %s Km",results.getCusto(), String.valueOf(results.getSomaDistanciaMenorCaminho())));

    }

    @Override
    public void setRoute() {

    }
}
