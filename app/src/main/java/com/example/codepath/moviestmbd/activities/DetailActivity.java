package com.example.codepath.moviestmbd.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.codepath.moviestmbd.R;
import com.example.codepath.moviestmbd.model.Movie;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "movie";

    private Movie mMovie;

    @Bind(R.id.backdrop)
    ImageView backdrop;
    @Bind(R.id.movie_poster)
    ImageView poster;

    @Bind(R.id.movie_description)
    TextView description;
    @Bind(R.id.ratingBar)
    RatingBar ratingBar;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @Bind(R.id.release_date)
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        if (getIntent().hasExtra(EXTRA_MOVIE)){
            mMovie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        }else {
            throw new IllegalArgumentException("Detail activity must receive a movie parcelable");
        }


        setSupportActionBar(toolbar);
        toolbarLayout.setTitle(mMovie.getTitle());

        ratingBar.setRating(mMovie.getVoteAverage());

        Picasso.with(this).load(mMovie.getPosterUrl()).into(poster);
        Picasso.with(this).load(mMovie.getBackdropUrl()).into(backdrop);

        description.setText(mMovie.getOverview());
        date.setText("Release date: " + mMovie.getReleaseDate());




    }
}
