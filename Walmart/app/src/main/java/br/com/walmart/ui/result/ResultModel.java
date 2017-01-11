package br.com.walmart.ui.result;

import java.util.List;

import br.com.walmart.model.CalcModel;
import br.com.walmart.model.Edge;
import br.com.walmart.model.Vertex;

/**
 * Created by amandalacanna on 1/10/17.
 */

public interface ResultModel {
    List<Edge> getMap(String map);
    CalcModel getResult(List<Edge> map,
                        Vertex from,
                        Vertex to,
                        double autonomiaDoCaminhao,
                        double valorPorLitro,
                        String nameMap);
}
