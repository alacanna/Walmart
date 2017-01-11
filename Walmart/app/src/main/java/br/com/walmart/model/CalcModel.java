package br.com.walmart.model;


import java.io.Serializable;
import java.util.List;

/**
 * Created by amandalacanna on 1/8/17.
 */

public class CalcModel implements Serializable{
    public static final long  serialVersionUID = 1L;

    private List<Edge> caminhoMaisCurto;
    private String map;
    private String pontoDeOrigem;
    private String pontoDeDestino;

    private double autonomiaDoCaminhao;
    private int somaDistanciaMenorCaminho;
    private double valorPorLitro;

    private double custo;

    public CalcModel() {
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public List<Edge> getCaminhoMaisCurto() {
        return caminhoMaisCurto;
    }

    public void setCaminhoMaisCurto(List<Edge> caminhoMaisCurto) {
        this.caminhoMaisCurto = caminhoMaisCurto;
    }

    public String getPontoDeOrigem() {
        return pontoDeOrigem;
    }

    public void setPontoDeOrigem(String pontoDeOrigem) {
        this.pontoDeOrigem = pontoDeOrigem;
    }

    public String getPontoDeDestino() {
        return pontoDeDestino;
    }

    public void setPontoDeDestino(String pontoDeDestino) {
        this.pontoDeDestino = pontoDeDestino;
    }

    public double getAutonomiaDoCaminhao() {
        return autonomiaDoCaminhao;
    }

    public void setAutonomiaDoCaminhao(double autonomiaDoCaminhao) {
        this.autonomiaDoCaminhao = autonomiaDoCaminhao;
    }

    public int getSomaDistanciaMenorCaminho() {
        return somaDistanciaMenorCaminho;
    }

    public void setSomaDistanciaMenorCaminho(int somaDistanciaMenorCaminho) {
        this.somaDistanciaMenorCaminho = somaDistanciaMenorCaminho;
    }

    public double getValorPorLitro() {
        return valorPorLitro;
    }

    public void setValorPorLitro(double valorPorLitro) {
        this.valorPorLitro = valorPorLitro;
    }

    public double getCusto() {
        return (somaDistanciaMenorCaminho/autonomiaDoCaminhao) * valorPorLitro;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    @Override
    public String toString() {
        return "CalcModel{" +
                "caminhoMaisCurto=" + caminhoMaisCurto +
                ", map='" + map + '\'' +
                ", pontoDeOrigem='" + pontoDeOrigem + '\'' +
                ", pontoDeDestino='" + pontoDeDestino + '\'' +
                ", autonomiaDoCaminhao=" + autonomiaDoCaminhao +
                ", somaDistanciaMenorCaminho=" + somaDistanciaMenorCaminho +
                ", valorPorLitro=" + valorPorLitro +
                ", custo=" + custo +
                '}';
    }
}
