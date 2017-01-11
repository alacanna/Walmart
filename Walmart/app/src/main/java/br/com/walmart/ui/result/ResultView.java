package br.com.walmart.ui.result;

import android.content.Intent;

import br.com.walmart.model.ResultCalcModel;

/**
 * Created by amandalacanna on 1/10/17.
 */

public interface ResultView {
    void showProgress();
    void hideProgress();
    void showMessageError(String message);

    void setViewsInformation(ResultCalcModel results);
    Intent getIntent();
}
