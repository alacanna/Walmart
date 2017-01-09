package br.com.walmart.model;

/**
 * Created by amandalacanna on 1/8/17.
 */

public class CalcModel {

    private double autonomiaDoCaminhao;
    private double somaDistanciaMenorCaminho;
    private double valorPorLitro;

    public CalcModel(double autonomiaDoCaminhao, double somaDistanciaMenorCaminho, double valorPorLitro) {
        this.autonomiaDoCaminhao = autonomiaDoCaminhao;
        this.somaDistanciaMenorCaminho = somaDistanciaMenorCaminho;
        this.valorPorLitro = valorPorLitro;
    }

    public double getAutonomiaDoCaminhao() {
        return autonomiaDoCaminhao;
    }

    public void setAutonomiaDoCaminhao(double autonomiaDoCaminhao) {
        this.autonomiaDoCaminhao = autonomiaDoCaminhao;
    }

    public double getSomaDistanciaMenorCaminho() {
        return somaDistanciaMenorCaminho;
    }

    public void setSomaDistanciaMenorCaminho(double somaDistanciaMenorCaminho) {
        this.somaDistanciaMenorCaminho = somaDistanciaMenorCaminho;
    }

    public double getValorPorLitro() {
        return valorPorLitro;
    }

    public void setValorPorLitro(double valorPorLitro) {
        this.valorPorLitro = valorPorLitro;
    }

    double calculaCusto(){
        return (somaDistanciaMenorCaminho/autonomiaDoCaminhao) * valorPorLitro;
    }
}
