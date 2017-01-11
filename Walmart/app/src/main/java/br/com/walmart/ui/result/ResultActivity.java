package br.com.walmart.ui.result;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.walmart.R;
import br.com.walmart.model.ResultCalcModel;
import br.com.walmart.ui.adapters.RoutesAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity implements ResultView{
    @Bind(R.id.rv_route) RecyclerView rvRoutes;
    @Bind(R.id.txt_total) TextView txtTotal;
    @Bind(R.id.txt_title) TextView txtTitle;
    @Bind(R.id.progress) RelativeLayout progress;

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
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void showMessageError(String message) {
        txtTitle.setText(message);
    }

    @Override
    public void setViewsInformation(ResultCalcModel results) {

        rvRoutes.setHasFixedSize(true);

        manager = new LinearLayoutManager(this);
        rvRoutes.setLayoutManager(manager);

        adapter = new RoutesAdapter(results.getLstEdge());
        rvRoutes.setAdapter(adapter);

        txtTotal.setText(String.format("Total R$ %.2f para %s Km",results.getTotalCost(), String.valueOf(results.getTotalDistance())));

    }
}
