package com.example.android.popularmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.popularmovies.core.ImageAdapter;
import com.example.android.popularmovies.core.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.android.popularmovies.EXTRA_MESSAGE";
    public static ArrayList<Movie> arrayMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa o arrayMovies e carrega o catalogo para o arrayMovies
        arrayMovies = new ArrayList<Movie>();
        carregaCatalogo();

        GridView gridView = (GridView) findViewById(R.id.gridview_movies);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sendMovie(position);
            }
        });
    }

    public void carregaCatalogo() {
        adicionaFilme("How i met your mother", R.drawable.himym, "19/09/2005", "How I Met Your Mother foi uma premiada sitcom americana da CBS criada por Carter Bays e Craig Thomas. Estreou no dia 19 de setembro de 2005. A temporada 2013-14, sua nona edição, é a última, encerrando-se em 31 de março de 2014, após 208 episódios.", 5);
        adicionaFilme("The 100", R.drawable.the100, "19/03/2014", "The 100 é uma série de televisão americana transmitida pelo canal The CW. A série estreou nos Estados Unidos em 19 de março de 2014 e é baseada em um livro homônimo, o primeiro de uma série de Kass Morgan, e desenvolvida por Jason Rothenberg", 1);
        adicionaFilme("Scream Queens", R.drawable.scream_queens, "22/09/2015", "Scream Queens é uma série antológica de televisão de terror, drama e comédia, criada por Ryan Murphy, Brad Falchuk e Iann Brennan.", 1);
        adicionaFilme("Breaking Bad", R.drawable.breaking_bad, "20/01/2008", "Breaking Bad é uma série de televisão dramática americana criada e produzida por Vince Gilligan. A série foi exibida originalmente nos Estados Unidos e no Canadá pelo canal de televisão por assinatura AMC.", 5);
        adicionaFilme("The Walking Dead", R.drawable.the_walking_dead, "31/10/2010", "The Walking Dead é uma série de televisão dramática e pós-apocalíptica norte-americana, desenvolvida por Frank Darabont e baseada na série de quadrinhos de mesmo nome por Robert Kirkman, Tony Moore e Charlie Adlard.", 4);
        adicionaFilme("Revenge", R.drawable.revenge, "21/09/2011", "Revenge foi uma série de televisão norte-americana de drama criada por Mike Kelley e estrelada por Madeleine Stowe e Emily VanCamp.", 3);
        adicionaFilme("Narcos", R.drawable.narcos, "28/08/2015", "Narcos é uma série de televisão americana dirigida por José Padilha para a Netflix. Todos os dez episódios, que compõem a primeira temporada, foram disponibilizados na plataforma de streaming Netflix desde 28 de agosto de 2015", 5);
        adicionaFilme("Once Upon A Time", R.drawable.once_upon_a_time, "23/10/2011", "Once Upon a Time é uma série americana de drama-fantasia, que aborda o gênero conto de fadas. A série estreou em 23 de outubro de 2011, nos Estados Unidos pelo canal ABC.", 1);
        adicionaFilme("Gotham", R.drawable.gotham, "22/09/2014", "Gotham é uma série de televisão americana criada por Bruno Heller, baseada em personagens que aparecem em publicações da DC Comics em sua franquia Batman, principalmente os do Detetive James Gordon e Bruce Wayne. ", 2);
        adicionaFilme("Demolidor", R.drawable.demolidor, "01/04/2015", "Matthew Michael Murdock (Charlie Cox) é um jovem atleta e excelente aluno. Ainda na adolescência, um acidente envolvendo um caminhão que carregava lixos tóxicos o deixou cego e fez com que ele desenvolvesse vários sentidos. Quando Matt decide vestir o uniforme e adotar o nome \"Demolidor\" (Daredevil), leva uma vida dupla: é advogado durante o dia, e, à noite, protege as ruas de Hell's Kitchen, seu bairro em Nova York.", 3);
        adicionaFilme("The Flash", R.drawable.the_flash, "07/10/2014", "The Flash ou Flash é uma série de televisão americana criada por Greg Berlanti, Andrew Kreisberg e Geoff Johns, transmitida pela The CW desde 7 de outubro de 2014", 2);
        adicionaFilme("Game of Thrones", R.drawable.got, "21/09/2010", "Game of Thrones é uma série de televisão norte-americana criada por David Benioff e D. B. Weiss para a HBO. A série é baseada na série de livros As Crônicas de Gelo e Fogo, escritos por George R. R", 2);
    }
    public void adicionaFilme(String originalTitle, int posterImage, String releaseDate, String synopsis, int userRating) {
        Movie movie = new Movie();

        movie.setOriginalTitle(originalTitle);
        movie.setPosterImage(posterImage);
        movie.setReleaseDate(releaseDate);
        movie.setSynopsis(synopsis);
        movie.setUserRating(userRating);
        arrayMovies.add(movie);
    }

    public void sendMovie(int position) {
        Intent intent = new Intent(this, DetailMovieActivity.class);

        // EXTRA_MESSAGE envia o id do filme selecionado o qual deverá ser carregado e detalhado na próxima Activity
        intent.putExtra(EXTRA_MESSAGE, position);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
