package br.com.walmart.ui.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import br.com.walmart.R;
import br.com.walmart.ui.home.HomeActivity;

public class SplashActivity extends AppCompatActivity implements SplashView {

    private SplashPresenter.ViewPresenter presenter;
    private final int SPLASH_DISPLAY_LENGTH = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        presenter = new SplashPresenterImpl(this);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                presenter.saveJsonToRealm();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }

    @Override
    public void showMessageError(String message) {
        Toast.makeText(getApplicationContext(), String.valueOf(message), Toast.LENGTH_LONG).show();
    }

    @Override
    public void goToHome() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}
