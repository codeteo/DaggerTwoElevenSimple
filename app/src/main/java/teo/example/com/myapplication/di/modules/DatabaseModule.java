package teo.example.com.myapplication.di.modules;

import android.app.Application;
import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import teo.example.com.myapplication.data.database.MyDatabase;
import teo.example.com.myapplication.data.database.dao.PopularMovieDao;

/**
 * Dagger Module with database dependencies.
 */

@Module
public class DatabaseModule {

    private static final String DATABASE_NAME = "database.db";

    @Singleton
    @Provides
    MyDatabase providesDatabase(Application context) {
        return Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, DATABASE_NAME)
                .build();
    }

    @Singleton
    @Provides
    PopularMovieDao providesPopularMovieDao(MyDatabase db) {
        return db.dao();
    }

}