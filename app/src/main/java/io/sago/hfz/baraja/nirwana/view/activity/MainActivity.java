package io.sago.hfz.baraja.nirwana.view.activity;

import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.sago.hfz.baraja.nirwana.NirwanaApplication;
import io.sago.hfz.baraja.nirwana.di.component.DaggerMainActivityComponent;
import io.sago.hfz.baraja.nirwana.di.component.MainActivityComponent;
import io.sago.hfz.baraja.nirwana.di.modules.MainActivityModule;
import io.sago.hfz.baraja.nirwana.view.decorator.GridSpacingItemDecoration;
import io.sago.hfz.baraja.nirwana.R;
import io.sago.hfz.baraja.nirwana.adapters.MovieAdapter;
import io.sago.hfz.baraja.nirwana.model.Resp;
import io.sago.hfz.baraja.nirwana.services.TmdbApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

import android.os.Bundle;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    public static final String API_KEY_TAG = "api_key";

    public static final String API_KEY = "3f8171028d2be22d2cea4508627a837b";

    public static final String BASE_URL = "https://api.themoviedb.org/3/";

    public static final String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500/";

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    MovieAdapter movieAdapter;

    @Inject
    TmdbApiService service;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        initViews();

        MainActivityComponent component = DaggerMainActivityComponent.builder()
            .nirwanaComponent(NirwanaApplication.get(this).getNirwanaComponent())
            .mainActivityModule(new MainActivityModule(this))
            .build();
        component.inject(this);

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
