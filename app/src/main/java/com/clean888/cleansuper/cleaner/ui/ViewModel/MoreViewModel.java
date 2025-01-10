package com.clean888.cleansuper.cleaner.ui.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MoreViewModel extends AndroidViewModel {
    public MoreViewModel(@NonNull Application application) {
        super(application);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
    }

    public void onCreate() {
    }
}
