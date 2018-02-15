package teo.example.com.myapplication.features;

public interface MainMVP {

    interface View {

        void showMessage(String message);

    }

    interface Presenter {

        void onLoadData();

    }

}
