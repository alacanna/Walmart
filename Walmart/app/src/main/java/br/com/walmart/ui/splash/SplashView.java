package br.com.walmart.ui.splash;

import android.content.res.Resources;

/**
 * Created by amandalacanna on 1/9/17.
 */

public interface SplashView {
    void showMessageError(String message);
    void goToHome();
    Resources getResources();
}
