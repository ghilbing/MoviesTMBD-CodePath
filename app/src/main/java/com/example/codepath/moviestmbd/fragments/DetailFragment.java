package com.example.codepath.moviestmbd.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.codepath.moviestmbd.R;
import com.example.codepath.moviestmbd.adapters.DetailsAdapter;
import com.example.codepath.moviestmbd.model.Movie;
import com.example.codepath.moviestmbd.rest.MovieApiDB;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.R.attr.description;

/**
 * Created by gretel on 9/12/17.
 */

public class DetailFragment extends Fragment {

    static final String LOG_TAG = DetailFragment.class.getSimpleName();
    public static final String EXTRA_MOVIE = "movie";

    Movie mMovie;
    MovieApiDB movieApiDB;

    DetailsAdapter mAdapter;

    @Bind(R.id.backdrop)
    ImageView backdrop;
    @Bind(R.id.movie_poster)
    ImageView poster;

   /* @Bind(R.id.movie_description)
    TextView description;
    @Bind(R.id.ratingBar)
    RatingBar ratingBar;*/
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
   /* @Bind(R.id.release_date)
    TextView date;*/

    public static DetailFragment newInstance(Movie movie){
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(EXTRA_MOVIE, movie);
        fragment.setArguments(args);
        return fragment;
    }

    public DetailFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            mMovie = getArguments().getParcelable(EXTRA_MOVIE);
            Log.i("Movie Content: ", String.valueOf(mMovie.getTitle()));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);



        //setSupportActionBar(toolbar);
        toolbarLayout.setTitle(mMovie.getTitle());

        //ratingBar.setRating(mMovie.getVoteAverage());

       // Picasso.with(this).load(mMovie.getPosterUrl()).into(poster);
       // Picasso.with(this).load(mMovie.getBackdropUrl()).into(backdrop);

        //description.setText(mMovie.getOverview());
        //date.setText("Release date: " + mMovie.getReleaseDate());


        return view;

    }
}
