package io.sago.hfz.baraja.nirwana.view.activity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.sago.hfz.baraja.nirwana.NirwanaApplication;
import io.sago.hfz.baraja.nirwana.di.component.ApplicationComponent;
import io.sago.hfz.baraja.nirwana.di.component.DaggerMainActivityComponent;
import io.sago.hfz.baraja.nirwana.di.component.MainActivityComponent;
import io.sago.hfz.baraja.nirwana.di.modules.MainActivityModule;
import io.sago.hfz.baraja.nirwana.model.Movie;
import io.sago.hfz.baraja.nirwana.navigation.Navigator;
import io.sago.hfz.baraja.nirwana.view.decorator.GridSpacingItemDecoration;
import io.sago.hfz.baraja.nirwana.R;
import io.sago.hfz.baraja.nirwana.adapters.MovieAdapter;
import io.sago.hfz.baraja.nirwana.model.Resp;
import io.sago.hfz.baraja.nirwana.services.TmdbApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemReselectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    public static final String API_KEY_TAG = "api_key";

    public static final String API_KEY = "3f8171028d2be22d2cea4508627a837b";

    public static final String BASE_URL = "https://api.themoviedb.org/3/";

    public static final String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500/";

    @BindView(R.id.nav_view)
    BottomNavigationView bottomNavigationView;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    MovieAdapter movieAdapter;

    @Inject
    TmdbApiService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        populateMovies();
    }

    @Override
    protected void initViews() {
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, 16, true));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        recyclerView.setAdapter(movieAdapter);

        movieAdapter.setOnItemClickListener(movie -> {
            movieList.remove(movie);
            movieAdapter.submitList(new ArrayList<>(movieList));

            navigator.navigateToMovieDetail(this);
        });
    }

    List<Movie> movieList;

    private void populateMovies() {
        Call<Resp> randomUsersCall = service.getPopular();
        randomUsersCall.enqueue(new Callback<Resp>() {
            @Override
            public void onResponse(Call<Resp> call,
                @NonNull Response<Resp> response) {
                if (response.isSuccessful()) {
                    movieList = response.body().getResults();
                    movieAdapter.submitList(new ArrayList<>(movieList));
                }
            }

            @Override
            public void onFailure(Call<Resp> call, Throwable t) {
                Timber.e(t);
            }
        });
    }

    @Override
    protected void inject(ApplicationComponent applicationComponent) {
        MainActivityComponent component = DaggerMainActivityComponent.builder()
            .applicationComponent(applicationComponent)
            .mainActivityModule(new MainActivityModule(this))
            .build();
        component.inject(this);
    }

    @Override
    int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_movies:
                return true;
            case R.id.navigation_tv:
                return true;
            default:
                return false;
        }
    }
}
