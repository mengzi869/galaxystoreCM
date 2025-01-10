package com.clean888.cleansuper.cleaner.ui.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.blankj.utilcode.util.ThreadUtils;
import com.clean888.cleansuper.cleaner.utils.a_mmkv;

public class SettingsViewModel extends ViewModel implements a_mmkv.b {
    private MutableLiveData<a_mmkv> liveData = new MutableLiveData<>();

    public SettingsViewModel() {
        a_mmkv.h().B(this);
        this.liveData.setValue(a_mmkv.h());
    }

    public void lambdaonChanged() {
        this.liveData.setValue(a_mmkv.h());
    }

    public LiveData<a_mmkv> getData() {
        return this.liveData;
    }

    public a_mmkv getValue() {
        return this.liveData.getValue();
    }

    @Override
    public void onChanged() {
        ThreadUtils.runOnUiThread(() -> SettingsViewModel.this.lambdaonChanged());
    }

    @Override
    public void onCleared() {
        super.onCleared();
        a_mmkv.h().N(this);
    }

}
