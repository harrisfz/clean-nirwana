package io.sago.hfz.baraja.nirwana;

import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.sago.hfz.baraja.nirwana.adapters.MovieAdapter;
import io.sago.hfz.baraja.nirwana.di.component.DaggerMoviesComponent;
import io.sago.hfz.baraja.nirwana.di.component.MoviesComponent;
import io.sago.hfz.baraja.nirwana.di.modules.ContextModule;
import io.sago.hfz.baraja.nirwana.model.Resp;
import io.sago.hfz.baraja.nirwana.services.TmdbApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String API_KEY_TAG = "api_key";

    public static final String API_KEY = "3f8171028d2be22d2cea4508627a837b";

    public static final String BASE_URL = "https://api.themoviedb.org/3/";

    public static final String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500/";

    Picasso picasso;

    TmdbApiService service;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    MovieAdapter movieAdapter;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        initViews();

        Timber.plant(new Timber.DebugTree());

        MoviesComponent moviesComponent = DaggerMoviesComponent.builder()
            .contextModule(new ContextModule(this))
            .build();

        picasso = moviesComponent.getPicasso();
        service = moviesComponent.getTmdbService();

        movieAdapter = new MovieAdapter(picasso);
        recyclerView.setAdapter(movieAdapter);
        populateMovies();
    }

    private void initViews() {
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, 16, true));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void populateMovies() {
        Call<Resp> randomUsersCall = service.getPopular();
        randomUsersCall.enqueue(new Callback<Resp>() {
            @Override
            public void onResponse(Call<Resp> call,
                @NonNull Response<Resp> response) {
                if (response.isSuccessful()) {
                    movieAdapter.submitList(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<Resp> call, Throwable t) {
                Timber.e(t);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null)
            unbinder.unbind();
    }
}
