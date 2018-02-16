package teo.example.com.myapplication.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import teo.example.com.myapplication.data.database.dao.PopularMovieDao;
import teo.example.com.myapplication.data.database.entities.PopularMovieEntity;

/**
 * Room database for persistence storage of data.
 */

@Database(entities = PopularMovieEntity.class, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    public abstract PopularMovieDao dao();

}