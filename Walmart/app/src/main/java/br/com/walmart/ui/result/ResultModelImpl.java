package br.com.walmart.ui.result;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.walmart.exception.PathNotFoundException;
import br.com.walmart.model.CalcModel;
import br.com.walmart.model.DijkstraAlgorithm;
import br.com.walmart.model.Edge;
import br.com.walmart.model.Graph;
import br.com.walmart.model.MapModel;
import br.com.walmart.model.PontoModel;
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

        for (PontoModel pontoModel : mapModel.getListaDePontos()) {
            Edge edge = new Edge(new Vertex<>(pontoModel.getPontoDeOrigem()),
                    new Vertex<>(pontoModel.getPontoDeDestino()),
                    pontoModel.getDistancia());
            edges.add(edge);
        }

        return edges;
    }

    @Override
    public CalcModel getResult(List<Edge> map,
                               Vertex from,
                               Vertex to,
                               double autonomiaDoCaminhao,
                               double valorPorLitro,
                               String nameMap) {

        try {
             dijkstraAlgorithm = new DijkstraAlgorithm(new Graph(map)).execute(from);
        } catch (PathNotFoundException e) {
            presenter.onError("Erro ao executar o cálculo.");
            e.printStackTrace();
        }

        CalcModel result = new CalcModel();

        result.setAutonomiaDoCaminhao(autonomiaDoCaminhao);
        result.setValorPorLitro(valorPorLitro);
        result.setMap(nameMap);
        result.setPontoDeOrigem(from.toString());
        result.setPontoDeOrigem(to.toString());

        try {
            result.setSomaDistanciaMenorCaminho(dijkstraAlgorithm.getDistance(to));
        } catch (PathNotFoundException e) {
            result.setSomaDistanciaMenorCaminho(0);
            e.printStackTrace();
            presenter.onError("Não foi possível calcular a distância");
        }

        try {
            result.setCaminhoMaisCurto(dijkstraAlgorithm.getPathAndWeight(to));
        } catch (PathNotFoundException e) {
            result.setCaminhoMaisCurto(new ArrayList<Edge>());
            presenter.onError("Não foi calcular o caminho.");
            e.printStackTrace();
        }

        Log.d("LOG","Result = "+ result.toString());
        return result;
    }

}
