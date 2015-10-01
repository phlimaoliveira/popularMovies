package com.example.android.popularmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.popularmovies.core.Movie;

public class DetailMovieActivity extends AppCompatActivity {

    private ImageView posterImageView;
    private TextView originalTitle;
    private TextView synopsis;
    private TextView userRating;
    private TextView releaseDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        Intent intent = this.getIntent();
        int id = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);

        posterImageView = (ImageView) findViewById(R.id.poster_imageview);
        originalTitle = (TextView) findViewById(R.id.original_title_textview);
        synopsis = (TextView) findViewById(R.id.synopsis_textview);
        userRating = (TextView) findViewById(R.id.user_rating_textview);
        releaseDate = (TextView) findViewById(R.id.release_date_textview);

        carregaFilme(id);
    }

    public void carregaFilme(int position) {
        Movie movie = (Movie) MainActivity.arrayMovies.get(position);

        this.setTitle(movie.getOriginalTitle());
        
        posterImageView.setImageResource(movie.getPosterImage());
        originalTitle.setText(movie.getOriginalTitle());
        synopsis.setText(movie.getSynopsis());
        userRating.setText(getResources().getString(R.string.user_rating).toString() + String.valueOf(movie.getUserRating()) + " " + getResources().getString(R.string.stars).toString());
        releaseDate.setText(getResources().getString(R.string.release_date).toString() + movie.getReleaseDate());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail_movie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
