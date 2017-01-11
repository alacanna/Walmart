package br.com.walmart.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import br.com.walmart.R;
import br.com.walmart.helper.Helper;
import br.com.walmart.model.MapModel;
import br.com.walmart.ui.adapters.MapSpinner;
import br.com.walmart.ui.adapters.PointSpinner;
import br.com.walmart.ui.result.ResultActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class HomeActivity extends AppCompatActivity implements HomeView {

    @Bind(R.id.spn_map) Spinner spnMap;
    @Bind(R.id.spn_from) Spinner spnOriginPoint;
    @Bind(R.id.spn_to) Spinner spnDestinationPoint;
    @Bind(R.id.edt_autonomia) EditText edtAutonomia;
    @Bind(R.id.edt_valor) EditText edtValor;
    @Bind(R.id.toolbar)Toolbar toolbar;

    private HomePresenter.ViewPresenter presenter;
    private MapModel mapaSelecionado;

    private MapSpinner mapAdapter;
    private PointSpinner originPointAdapter;
    private PointSpinner destinationPointAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        presenter = new HomePresenterImpl(this);

        setAdapter();

    }

    @Override
    public void showMessageError(String message) {
        Toast.makeText(getApplicationContext(),String.valueOf(message),Toast.LENGTH_LONG).show();
    }

    @Override
    public void goToResults(double autonomia, double valor, String map, String originPoint, String destinationPoint) {
        Intent intent = new Intent(HomeActivity.this, ResultActivity.class);
        intent.putExtra(Helper.AUTONOMIA, autonomia);
        intent.putExtra(Helper.VALOR, valor);
        intent.putExtra(Helper.MAP, map);
        intent.putExtra(Helper.ORIGIN_POINT, originPoint);
        intent.putExtra(Helper.DESTINATION_POINT,destinationPoint);
        startActivity(intent);
    }

    @Override
    public void setAdapter() {
        mapAdapter = new MapSpinner(this, presenter.getMap());
        spnMap.setAdapter(mapAdapter);
        mapaSelecionado = (MapModel) spnMap.getSelectedItem();
    }

    @Override
    public void changePointsAdapter() {
        originPointAdapter = new PointSpinner(this,presenter.getOriginPoints(mapaSelecionado.getMap()));
        originPointAdapter.notifyDataSetChanged();
        spnOriginPoint.setAdapter(originPointAdapter);

        destinationPointAdapter = new PointSpinner(this,presenter.getDestinationPoints(mapaSelecionado.getMap()));
        destinationPointAdapter.notifyDataSetChanged();
        spnDestinationPoint.setAdapter(destinationPointAdapter);
    }

    @OnClick(R.id.btn_go) void onClickListenerGo() {
        presenter.validateFields(edtAutonomia.getText().toString(), edtValor.getText().toString(), spnMap.getSelectedItem().toString(),spnOriginPoint.getSelectedItem().toString(), spnDestinationPoint.getSelectedItem().toString());
    }


    @OnItemSelected (R.id.spn_map)
    void onItemSelected(int position) {
        mapaSelecionado = mapAdapter.getItem(position);
        changePointsAdapter();
    }

}
