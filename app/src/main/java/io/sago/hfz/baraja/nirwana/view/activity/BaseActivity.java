package io.sago.hfz.baraja.nirwana.view.activity;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.sago.hfz.baraja.nirwana.NirwanaApplication;
import io.sago.hfz.baraja.nirwana.di.component.ApplicationComponent;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version BaseActivity, v 0.1 2019-07-12 18:34 by Harris Febryantony Z
 */
abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayout());

        inject(NirwanaApplication.get(this).getApplicationComponent());

        unbinder = ButterKnife.bind(this);

        initViews();
    }

    protected abstract void initViews();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null)
            unbinder.unbind();
    }

    protected abstract void inject(ApplicationComponent applicationComponent);

    @LayoutRes
    abstract int getLayout();
}
