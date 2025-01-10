package com.clean888.cleansuper.cleaner.ui.fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.clean888.cleansuper.cleaner.databinding.FragmentLargeFileAnimScanBinding;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.ui.fragment.result.FuncFinishTitleModel;
import com.clean888.cleansuper.cleaner.ui.ViewModel.LargeFileAnimScanVM;
import com.clean888.cleansuper.cleaner.ui.dialog.StopDialog;

public class LargeFileAnimScanFragment extends BaseFragment implements View.OnClickListener {
    private FragmentLargeFileAnimScanBinding binding;
    private boolean keepGoing;
    private boolean reScan;
    private long showPageTime;
    private StopDialog stopDialog;
    private int uiState;
    private LargeFileAnimScanVM largeFileAnimScanVM;
    private long CanPagePageTime = 4000;
    private int pageFrom = 0;
    private boolean isGoSelect = true;

    private LargeFileAnimScanFragment(boolean z) {
        this.reScan = z;
    }

    private void BindVM() {
        this.uiState = 0;
        if (this.largeFileAnimScanVM != null) {
            this.binding.icBack.setOnClickListener(this);
            this.largeFileAnimScanVM.v_cleanState.observe(getViewLifecycleOwner(), new Observer() {
                @Override
                public final void onChanged(Object obj) {
                    LargeFileAnimScanFragment.this.OnStateChange(((Integer) obj).intValue());
                }
            });
            this.largeFileAnimScanVM.v_zroAutoJumpFinish.observe(getViewLifecycleOwner(), new Observer() {
                @Override
                public final void onChanged(Object obj) {
                    LargeFileAnimScanFragment.this.lambda$BindVM$1((Boolean) obj);
                }
            });
        }
    }

    public void OnStateChange(int i) {
        if (checkFragmentAlive()) {
            if (i == 0) {
                this.uiState = i;
                return;
            }
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                this.uiState = i;
            } else {
                this.uiState = i;
                StopDialog pdVar = this.stopDialog;
                if (pdVar != null && pdVar.isShowing()) {
                    this.stopDialog.dismiss();
                }
                goNextPage();
            }
        }
    }

    private void goNextPage() {
        if (this.isGoSelect) {
            replaceFragment(LargeFileFragment.newInstance());
        } else {
//            i4.a().i("c_largefile_auto").putEbKey1(Integer.valueOf(this.pageFrom)).commit();
            replaceFragment(BAEY.newInstance(FuncFinishTitleModel.LargeFileClean.setExtras("")));
        }
    }

    public void lambda$BindVM$0() {
        if (getActivity() == null || getActivity().isFinishing() || isDetached() || isRemoving()) {
            return;
        }
        StopDialog pdVar = this.stopDialog;
        if (pdVar != null && pdVar.isShowing()) {
            this.keepGoing = true;
        } else {
            goNextPage();
        }
    }

    public void lambda$BindVM$1(Boolean bool) {
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        this.isGoSelect = false;
        long abs = this.CanPagePageTime - Math.abs(System.currentTimeMillis() - this.showPageTime);
        ConstraintLayout root = this.binding.getRoot();
        Runnable runnable = new Runnable() {
            @Override // java.lang.Runnable
            public final void run() {
                LargeFileAnimScanFragment.this.lambda$BindVM$0();
            }
        };
        if (abs <= 0) {
            abs = 0;
        }
        root.postDelayed(runnable, abs);
    }

    public void lambda$showStopDialog$2() {
//        i4.a().i("c_largefilescan_back").putEbKey1(Integer.valueOf(this.pageFrom)).commit();
        finishActivity();
    }

    public void lambda$showStopDialog$3() {
        if (this.keepGoing) {
            goNextPage();
        }
    }

    public static LargeFileAnimScanFragment newInstance(boolean z) {
        return new LargeFileAnimScanFragment(z);
    }

    private void showStopDialog() {
        if (this.stopDialog == null) {
            this.stopDialog = new StopDialog(getActivity(), new Runnable() {
                @Override
                public final void run() {
                    LargeFileAnimScanFragment.this.lambda$showStopDialog$2();
                }
            }, new Runnable() {
                @Override
                public final void run() {
                    LargeFileAnimScanFragment.this.lambda$showStopDialog$3();
                }
            });
        }
        if (this.stopDialog.isShowing()) {
            return;
        }
        this.stopDialog.show();
    }

    @Override
    public void onClick(View view) {
        if (view == this.binding.icBack) {
            showStopDialog();
        }
    }

    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(false);
        this.largeFileAnimScanVM = (LargeFileAnimScanVM) new ViewModelProvider(this).get(LargeFileAnimScanVM.class);
        this.binding = FragmentLargeFileAnimScanBinding.inflate(layoutInflater);
        this.pageFrom = getActivity().getIntent().getIntExtra(MainActivity.FROM, 0);
//        i4.a().i("s_largefilescan").putEbKey1(Integer.valueOf(this.pageFrom)).commit();
        this.showPageTime = System.currentTimeMillis();
        BindVM();
        this.largeFileAnimScanVM.onCreate(this.reScan);
//        qh.c();
        return this.binding.getRoot();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        if (keyCode == 4) {
            showStopDialog();
            return true;
        }
        return super.onKeyDown(keyCode, keyEvent);
    }

    public LargeFileAnimScanFragment() {
    }

}
