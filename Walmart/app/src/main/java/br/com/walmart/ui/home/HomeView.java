package br.com.walmart.ui.home;

/**
 * Created by amandalacanna on 1/9/17.
 */

public interface HomeView {
    void showMessageError(String message);
    void goToResults(double autonomia, double valor, String map, String originPoint, String destinationPoint);

    void setAdapter();
    void changePointsAdapter();
}
