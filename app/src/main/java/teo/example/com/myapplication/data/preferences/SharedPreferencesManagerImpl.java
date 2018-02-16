package teo.example.com.myapplication.data.preferences;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Concrete implementation of {@link SharedPreferencesManager}.
 */

public class SharedPreferencesManagerImpl {

    private SharedPreferences preferences;

    public SharedPreferencesManagerImpl(Application application) {
        preferences = PreferenceManager.getDefaultSharedPreferences(application);
    }

}
