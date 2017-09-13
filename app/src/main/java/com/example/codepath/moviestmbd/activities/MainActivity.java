package com.example.codepath.moviestmbd.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.codepath.moviestmbd.R;
import com.example.codepath.moviestmbd.adapters.MoviesAdapter;
import com.example.codepath.moviestmbd.fragments.DetailFragment;
import com.example.codepath.moviestmbd.fragments.MainFragment;
import com.example.codepath.moviestmbd.model.Movie;
import com.example.codepath.moviestmbd.rest.ErrorApi;
import com.example.codepath.moviestmbd.rest.MovieApiDB;
import com.example.codepath.moviestmbd.rest.MovieListResponse;
import com.example.codepath.moviestmbd.rest.MovieResponse;
import com.example.codepath.moviestmbd.rest.ReviewResponse;
import com.example.codepath.moviestmbd.rest.VideoResponse;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MovieApiDB.MovieListener, MovieApiDB.ReviewListener, MovieApiDB.MovieListListener, MovieApiDB.VideoListener {

    Fragment mainFragment;
    Fragment detailFragment;

    MovieApiDB movieApiDB;

    MoviesAdapter mAdapter;

    List<Movie> movies;



    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);



        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemViewCacheSize(20);
        mRecyclerView.setDrawingCacheEnabled(true);
        mRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        mAdapter = new MoviesAdapter(this);
        mRecyclerView.setAdapter(mAdapter);




        mainFragment = new MainFragment();
        detailFragment = new DetailFragment();

        movieApiDB = MovieApiDB.getInstance(getString(R.string.api_key));

        movieApiDB.requestPopularMovies(this);
        movieApiDB.requestPopularMovies(2, this);
        movieApiDB.requestRatedMovies(this);
        movieApiDB.requestRatedMovies(2, this);
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
        movies = response.getMovies();
        mAdapter.setMovieList(response.getMovies());
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


    /*public void onFragmentMovie(View view) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frag_layout, mainFragment);
        ft.addToBackStack(null);
        ft.commit();


    }

    public void onFragmentPoster(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frag_layout, detailFragment);
        ft.addToBackStack(null);
        ft.commit();

    }*/
}
