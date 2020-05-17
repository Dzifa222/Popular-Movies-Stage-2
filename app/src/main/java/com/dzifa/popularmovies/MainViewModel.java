package com.dzifa.popularmovies;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.dzifa.popularmovies.database.MovieDatabase;
import com.dzifa.popularmovies.database.FavoriteMovie;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    // Constant for logging
    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<FavoriteMovie>> movies;

    public MainViewModel(Application application) {
        super(application);
        MovieDatabase database = MovieDatabase.getInstance(this.getApplication());

        movies = database.movieDao().loadAllMovies();
    }

    public LiveData<List<FavoriteMovie>> getMovies() {
        return movies;
    }
}
