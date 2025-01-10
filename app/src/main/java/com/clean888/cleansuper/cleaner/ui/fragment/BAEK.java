package com.clean888.cleansuper.cleaner.ui.fragment;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.FragmentWidgetAddBinding;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.utils.y41;
import com.clean888.cleansuper.cleaner.ui.activity.BAAG;
import com.clean888.cleansuper.cleaner.provider.BABA;
import com.clean888.cleansuper.cleaner.provider.BABB;
import com.clean888.cleansuper.cleaner.provider.BABC;
import com.clean888.cleansuper.cleaner.provider.BABD;

public class BAEK extends BaseFragment implements View.OnClickListener {

    private static final String TAG = "Widget-BAEK";

    private FragmentWidgetAddBinding binding;

    private void addWidget(int i) {
        if (Build.VERSION.SDK_INT < 26) {
            Toast.makeText(getContext(), getString(R.string.toast_fail_widget), Toast.LENGTH_SHORT).show();
            return;
        }
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(getActivity());
        if (appWidgetManager.isRequestPinAppWidgetSupported()) {
            Bundle bundle = new Bundle();
            if (i == 1) {
                Intent intent = new Intent(getActivity(), (Class<?>) BABD.class);
                intent.setAction("create_app_widget");
                intent.putExtra("type", 1);
                ComponentName componentName = new ComponentName(getActivity(), (Class<?>) BABD.class);
                PendingIntent broadcast = PendingIntent.getBroadcast(getActivity(), 1, intent, y41.a(PendingIntent.FLAG_UPDATE_CURRENT));
                bundle.putParcelable("appWidgetPreview", new RemoteViews(getActivity().getPackageName(), R.layout.widget_all));
                appWidgetManager.requestPinAppWidget(componentName, bundle, broadcast);
                L.e(TAG,"addWidget all/BABD Success");
                return;
            }
            if (i == 2) {
                Intent intent2 = new Intent(getActivity(), (Class<?>) BABB.class);
                intent2.setAction("create_app_widget");
                intent2.putExtra("type", 2);
                ComponentName componentName2 = new ComponentName(getActivity(), (Class<?>) BABB.class);
                PendingIntent broadcast2 = PendingIntent.getBroadcast(getActivity(), 2, intent2, y41.a(134217728));
                bundle.putParcelable("appWidgetPreview", new RemoteViews(getActivity().getPackageName(), R.layout.widget_clean));
                appWidgetManager.requestPinAppWidget(componentName2, bundle, broadcast2);
                return;
            }
            if (i == 3) {
                Intent intent3 = new Intent(getActivity(), (Class<?>) BABA.class);
                intent3.setAction("create_app_widget");
                intent3.putExtra("type", 3);
                ComponentName componentName3 = new ComponentName(getActivity(), (Class<?>) BABA.class);
                PendingIntent broadcast3 = PendingIntent.getBroadcast(getActivity(), 3, intent3, y41.a(134217728));
                bundle.putParcelable("appWidgetPreview", new RemoteViews(getActivity().getPackageName(), R.layout.widget_battery));
                appWidgetManager.requestPinAppWidget(componentName3, bundle, broadcast3);
                return;
            }
            if (i == 4) {
                Intent intent4 = new Intent(getActivity(), (Class<?>) BABC.class);
                intent4.setAction("create_app_widget");
                intent4.putExtra("type", 4);
                ComponentName componentName4 = new ComponentName(getActivity(), (Class<?>) BABC.class);
                PendingIntent broadcast4 = PendingIntent.getBroadcast(getActivity(), 4, intent4, y41.a(134217728));
                bundle.putParcelable("appWidgetPreview", new RemoteViews(getActivity().getPackageName(), R.layout.widget_cpu));
                appWidgetManager.requestPinAppWidget(componentName4, bundle, broadcast4);
            }
        }
    }

    public static BAEK newInstance() {
        return new BAEK();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentWidgetAddBinding fragmentWidgetAddBinding = this.binding;
        if (view == fragmentWidgetAddBinding.tvAddAll) {
            addWidget(1);
            return;
        }
        if (view == fragmentWidgetAddBinding.tvAddClean) {
            addWidget(2);
            return;
        }
        if (view == fragmentWidgetAddBinding.tvAddBattery) {
            addWidget(3);
            return;
        }
        if (view == fragmentWidgetAddBinding.tvAddCpu) {
            addWidget(4);
        } else if (view == fragmentWidgetAddBinding.icBack) {
            finishActivity();
        } else if (view == fragmentWidgetAddBinding.tvManually) {
            startActivity(new Intent(getContext(), (Class<?>) BAAG.class));
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(true);
        FragmentWidgetAddBinding inflate = FragmentWidgetAddBinding.inflate(layoutInflater, viewGroup, false);
        this.binding = inflate;
        inflate.icBack.setOnClickListener(this);
        this.binding.tvAddAll.setOnClickListener(this);
        this.binding.tvAddBattery.setOnClickListener(this);
        this.binding.tvAddClean.setOnClickListener(this);
        this.binding.tvAddCpu.setOnClickListener(this);
        this.binding.tvManually.setOnClickListener(this);
        return this.binding.getRoot();
    }
}
