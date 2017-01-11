package br.com.walmart.ui.result;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.walmart.exception.PathNotFoundException;
import br.com.walmart.model.ResultCalcModel;
import br.com.walmart.model.DijkstraAlgorithm;
import br.com.walmart.model.Edge;
import br.com.walmart.model.Graph;
import br.com.walmart.model.MapModel;
import br.com.walmart.model.PointModel;
import br.com.walmart.model.Vertex;
import io.realm.Realm;

/**
 * Created by amandalacanna on 1/10/17.
 */

public class ResultModelImpl implements ResultModel {
    private Realm realm;
    private ResultPresenter.ModelPresenter presenter;
    private DijkstraAlgorithm dijkstraAlgorithm;

    public ResultModelImpl(ResultPresenter.ModelPresenter presenter) {
        this.presenter = presenter;
        this.realm = Realm.getDefaultInstance();
    }

    @Override
    public List<Edge> getMap(String map) {
        MapModel mapModel = Realm.getDefaultInstance().where(MapModel.class).contains("map", "SP").findFirst();
        List<Edge> edges = new ArrayList<>();

        for (PointModel pointModel : mapModel.getLstPoints()) {
            Edge edge = new Edge(new Vertex<>(pointModel.getOriginPoint()),
                    new Vertex<>(pointModel.getDestinationPoint()),
                    pointModel.getDistance());
            edges.add(edge);
        }

        return edges;
    }

    @Override
    public ResultCalcModel getResult(List<Edge> map,
                                     Vertex from,
                                     Vertex to,
                                     double autonomiaDoCaminhao,
                                     double valorPorLitro,
                                     String nameMap) {

        try {
             dijkstraAlgorithm = new DijkstraAlgorithm(new Graph(map)).execute(from);
        } catch (PathNotFoundException e) {
            e.printStackTrace();
        }

        ResultCalcModel result = new ResultCalcModel();

        result.setTruckAut(autonomiaDoCaminhao);
        result.setPrice(valorPorLitro);
        result.setMap(nameMap);
        result.setPontoDeOrigem(from.toString());
        result.setPontoDeOrigem(to.toString());

        try {
            result.setTotalDistance(dijkstraAlgorithm.getDistance(to));
        } catch (PathNotFoundException e) {
            result.setTotalDistance(0);
            e.printStackTrace();
        }

        try {
            result.setLstEdge(dijkstraAlgorithm.getPathAndWeight(to));
        } catch (PathNotFoundException e) {
            presenter.onError("Não foram encontradas rotas para esse percurso.");
            result.setLstEdge(new ArrayList<Edge>());
            e.printStackTrace();
        }

        Log.d("LOG","Result = "+ result.toString());
        return result;
    }

}
