package io.sago.hfz.baraja.nirwana.view.fragment;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import io.sago.hfz.baraja.nirwana.R;
import io.sago.hfz.baraja.nirwana.di.component.ApplicationComponent;
import io.sago.hfz.baraja.nirwana.di.component.DaggerMovieComponent;
import io.sago.hfz.baraja.nirwana.di.component.MovieComponent;
import io.sago.hfz.baraja.nirwana.di.modules.ApiModule;
import io.sago.hfz.baraja.nirwana.di.modules.RetrofitModule;
import io.sago.hfz.baraja.nirwana.model.MovieModel;
import io.sago.hfz.baraja.data.entity.Resp;
import io.sago.hfz.baraja.nirwana.navigation.Navigator;
import io.sago.hfz.baraja.nirwana.services.TmdbApiService;
import io.sago.hfz.baraja.nirwana.view.adapter.MovieAdapter;
import io.sago.hfz.baraja.nirwana.view.decorator.GridSpacingItemDecoration;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends BaseFragment {

    public static final String ARG_CATEGORY = "category";

    public static final int ARG_CATEGORY_POPULAR = 1;

    public static final int ARG_CATEGORY_TOP_RATED = 2;

    public static final int ARG_CATEGORY_FAVORITE = 3;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    TmdbApiService service;

    @Inject
    MovieAdapter movieAdapter;

    @Inject
    Navigator navigator;

    public static BaseFragment newInstance(int index) {
        BaseFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_CATEGORY, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initInjection(ApplicationComponent applicationComponent) {
        Timber.d("InitInjection");
        MovieComponent component = DaggerMovieComponent.builder()
            .applicationComponent(applicationComponent)
            .apiModule(new ApiModule())
            .retrofitModule(new RetrofitModule())
            .build();
        component.inject(this);

        Timber.d(service.toString() + " " + movieAdapter.toString());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_CATEGORY);
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Timber.d("onViewCreated");
        init();
    }

    private void init() {
        setupRecyclerView();

        populateMovie();
    }

    private void populateMovie() {
        Call<Resp> randomUsersCall = service.getPopular();
        randomUsersCall.enqueue(new Callback<Resp>() {
            @Override
            public void onResponse(Call<Resp> call,
                @NonNull Response<Resp> response) {
                if (response.isSuccessful()) {
                    List<MovieModel> movieModelList = response.body().getResults();
                    movieAdapter.submitList(new ArrayList<>(movieModelList));
                }
            }

            @Override
            public void onFailure(Call<Resp> call, Throwable t) {
                Timber.e(t);
            }
        });
    }

    private void setupRecyclerView() {
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, 16, true));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        recyclerView.setAdapter(movieAdapter);

        movieAdapter.setOnItemClickListener(movie -> {
            navigator.navigateToMovieDetail(getContext());
        });
    }
}