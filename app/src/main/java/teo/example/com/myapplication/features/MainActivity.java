package teo.example.com.myapplication.features;

import android.os.Bundle;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import teo.example.com.myapplication.R;
import timber.log.Timber;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    MainMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter.onLoadData();
    }
}
