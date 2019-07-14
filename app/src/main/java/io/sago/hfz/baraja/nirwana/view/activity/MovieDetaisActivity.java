package io.sago.hfz.baraja.nirwana.view.activity;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import io.sago.hfz.baraja.nirwana.R;
import io.sago.hfz.baraja.nirwana.di.component.ApplicationComponent;

public class MovieDetaisActivity extends BaseActivity {

    @BindView(R.id.text_view_title)
    TextView tvTitle;

    @BindView(R.id.text_view_subtitle)
    TextView tvSubtitle;

    @BindView(R.id.text_view_rating)
    TextView tvRating;

    @BindView(R.id.text_view_trailer)
    TextView tvTrailer;

    @BindView(R.id.text_view_description)
    TextView tvDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void inject(ApplicationComponent applicationComponent) {

    }

    @Override
    int getLayout() {
        return R.layout.activity_movie_detais;
    }
}
