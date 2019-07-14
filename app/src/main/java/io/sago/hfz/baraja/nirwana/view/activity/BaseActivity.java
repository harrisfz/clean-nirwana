package io.sago.hfz.baraja.nirwana.view.activity;

import android.os.Bundle;

import javax.inject.Inject;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.sago.hfz.baraja.nirwana.NirwanaApplication;
import io.sago.hfz.baraja.nirwana.di.component.ApplicationComponent;
import io.sago.hfz.baraja.nirwana.navigation.Navigator;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version BaseActivity, v 0.1 2019-07-12 18:34 by Harris Febryantony Z
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Inject
    Navigator navigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NirwanaApplication.get(this).getApplicationComponent().inject(this);

        setContentView(getLayout());

        unbinder = ButterKnife.bind(this);

        initViews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (unbinder != null)
            unbinder.unbind();
    }

    protected abstract void initViews();

    @LayoutRes
    abstract int getLayout();
}
