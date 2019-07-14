package io.sago.hfz.baraja.nirwana.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.sago.hfz.baraja.nirwana.NirwanaApplication;
import io.sago.hfz.baraja.nirwana.di.component.ApplicationComponent;
import io.sago.hfz.baraja.nirwana.view.activity.BaseActivity;
import timber.log.Timber;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version BaseFragment, v 0.1 2019-07-14 22:10 by Harris Febryantony Z
 */
public abstract class BaseFragment extends Fragment {

    private Unbinder unbinder;

    BaseActivity baseActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Timber.d("onAttach");
        if (getActivity() instanceof BaseActivity) {
            baseActivity = (BaseActivity) getActivity();
            initInjection(NirwanaApplication.get(baseActivity).getApplicationComponent());
        }
    }

    protected abstract void initInjection(ApplicationComponent applicationComponent);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        View view;
        if (getLayout() != 0) {
            view = inflater.inflate(getLayout(), container, false);
            unbinder = ButterKnife.bind(this, view);
            return view;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @LayoutRes
    protected abstract int getLayout();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    ApplicationComponent getApplicationComponent() {
        if (baseActivity != null) {
            return NirwanaApplication.get(baseActivity).getApplicationComponent();
        }
        return null;
    }
}
