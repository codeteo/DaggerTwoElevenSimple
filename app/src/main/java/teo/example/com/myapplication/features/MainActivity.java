package teo.example.com.myapplication.features;

import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import teo.example.com.myapplication.R;

public class MainActivity extends DaggerAppCompatActivity implements MainMVP.View {

    private TextView tvTitle;

    @Inject
    MainMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tv_main_title);

        presenter.onLoadData();
    }

    @Override
    public void showMessage(String message) {
        tvTitle.setText(message);
    }
}
