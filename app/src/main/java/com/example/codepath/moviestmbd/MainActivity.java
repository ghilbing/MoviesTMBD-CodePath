package com.example.codepath.moviestmbd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.codepath.moviestmbd.rest.ErrorApi;
import com.example.codepath.moviestmbd.rest.MovieApiDB;
import com.example.codepath.moviestmbd.rest.MovieListResponse;
import com.example.codepath.moviestmbd.rest.MovieResponse;
import com.example.codepath.moviestmbd.rest.ReviewResponse;
import com.example.codepath.moviestmbd.rest.VideoResponse;

public class MainActivity extends AppCompatActivity implements MovieApiDB.MovieListener, MovieApiDB.ReviewListener, MovieApiDB.MovieListListener, MovieApiDB.VideoListener {

    MovieApiDB movieApiDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieApiDB = MovieApiDB.getInstance(getString(R.string.api_key));

        movieApiDB.requestPopularMovies(this);
        movieApiDB.requestPopularMovies(2,this);
        movieApiDB.requestRatedMovies(this);
        movieApiDB.requestRatedMovies(2,this);
        movieApiDB.requestReviews(211672, this);
        movieApiDB.requestVideos(211672, this);



    }

    @Override
    public void success(MovieResponse response) {
        Log.i("MovieRespone", String.valueOf(response));
    }

    @Override
    public void success(MovieListResponse response) {
        Log.i("MovieListRespone", String.valueOf(response));
    }



    @Override
    public void success(VideoResponse response) {
        Log.i("VideoRespone", String.valueOf(response));
    }



    @Override
    public void success(ReviewResponse response) {
        Log.i("ReviewRespone", String.valueOf(response));
        }



    @Override
    public void error(ErrorApi errorApi) {
        Log.i("ErrorApi", String.valueOf(errorApi));
        }


}
