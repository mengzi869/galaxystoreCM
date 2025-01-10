package com.clean888.cleansuper.cleaner.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.FragmentPhoneBoostBinding;
import com.clean888.cleansuper.cleaner.databinding.ViewListEmptyBinding;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.utils.BAFC;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.utils.md;
import com.clean888.cleansuper.cleaner.utils.mr0;
import com.clean888.cleansuper.cleaner.utils.nr1;
import com.clean888.cleansuper.cleaner.ui.fragment.result.FuncFinishTitleModel;
import com.clean888.cleansuper.cleaner.bean.RunningAppBean;
import com.clean888.cleansuper.cleaner.ui.ViewModel.PhoneBoostViewModel;
import com.clean888.cleansuper.cleaner.ui.adapter.BoostSelectAdapter;
import com.clean888.cleansuper.cleaner.bean.BoostSelectItemBean;
//import com.clean888.cleansuper.cleaner.ui.bean.e6;
import com.clean888.cleansuper.cleaner.ui.dialog.StopDialog;

import java.util.ArrayList;
import java.util.List;

public class PhoneBoostFragment extends BaseFragment implements View.OnClickListener, md.c {
    private static String TAG = "PhoneBoostFragment";
    private boolean allSelect;
    private FragmentPhoneBoostBinding binding;
    private StopDialog dialog;
    private int pageFrom = 0;
    private BoostSelectAdapter selectAdapter;
    private md sizeAnim;
    private int uiState;
    private PhoneBoostViewModel vm;

    private void BindVM() {
        Log.d(TAG, "BindVM init");

        this.sizeAnim = new md.b().d(this);
        this.binding.icBack.setOnClickListener(this);
        this.binding.btnBottom.setOnClickListener(this);
        this.vm.v_curSize.observe(getViewLifecycleOwner(), new Observer() {
            @Override
            public final void onChanged(Object obj) {
                changeCursizeState((Long) obj);
            }
        });
        this.vm.v_uistate.observe(getViewLifecycleOwner(), new Observer() {
            @Override
            public final void onChanged(Object obj) {
                ChangeUIState(((Integer) obj).intValue());
            }
        });
        this.vm.v_appCnt.observe(getViewLifecycleOwner(), new Observer() {
            @Override
            public final void onChanged(Object obj) {
                changeAppcntState((Long) obj);
            }
        });
        this.vm.v_allSelect.observe(getViewLifecycleOwner(), new Observer() {
            @Override
            public final void onChanged(Object obj) {
                changeAllselState((Boolean) obj);
            }
        });
        BoostSelectAdapter boostSelectAdapter = new BoostSelectAdapter(R.layout.item_phoneboost_clean_select);
        this.selectAdapter = boostSelectAdapter;
        boostSelectAdapter.setCall(new BoostSelectAdapter.BoostSelectLinstener() {
            @Override
            public final void a(Object obj, boolean z) {
                vm.onSelectedItem();
            }
        });
        this.selectAdapter.setEmptyView(ViewListEmptyBinding.inflate(getLayoutInflater()).getRoot());
        this.binding.list.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.binding.list.setAdapter(this.selectAdapter);
        this.vm.v_progressInfo.observe(getViewLifecycleOwner(), new Observer() {
            @Override
            public final void onChanged(Object obj) {
                L.v(TAG,"PhoneBoostFragment onChanged");
                changeProgsState((BoostSelectItemBean) obj);
            }
        });
        this.vm.v_resultList.observe(getViewLifecycleOwner(), new Observer() {
            @Override
            public final void onChanged(Object obj) {
                getResultList((List) obj);
            }
        });
        this.binding.box.setOnClickListener(this);
    }

    public void ChangeUIState(int i) {
        if (checkFragmentAlive()) {
            if (i == 0) {
                this.binding.box.setVisibility(View.INVISIBLE);
                this.binding.boxShow.setVisibility(View.INVISIBLE);
                this.binding.progress.setVisibility(View.VISIBLE);
                this.binding.btnBottom.setEnabled(false);
                this.uiState = i;
                return;
            }
            if (i != 1) {
                return;
            }
            this.binding.box.setVisibility(View.VISIBLE);
            this.binding.boxShow.setVisibility(View.VISIBLE);
            this.binding.progress.setVisibility(View.INVISIBLE);
            this.binding.btnBottom.setEnabled(true);
            this.uiState = i;
        }
    }

    private void checkBack() {
        if (this.uiState == 1) {
            quit();
            return;
        }
        if (this.dialog == null) {
            this.dialog = new StopDialog(getActivity(), new Runnable() {
                @Override
                public final void run() {
                    PhoneBoostFragment.this.quit();
                }
            }, new Runnable() {
                @Override
                public final void run() {
                    checkFragmentAlive();
                }
            });
        }
        this.dialog.show();
    }

    public void changeCursizeState(Long l) {
        if (this.uiState == 1) {
            this.binding.btnBottom.setEnabled(l.longValue() > 0);
        }
        md mdVar = this.sizeAnim;
        if (mdVar != null) {
            mdVar.c(l.longValue());
        }
    }

    public void changeAppcntState(Long l) {
        this.binding.groupTitle.setText(String.format(getString(R.string.boost_clean_app_clean_top_msg), l.toString()));
    }

    public void changeAllselState(Boolean bool) {
        boolean booleanValue = bool.booleanValue();
        this.allSelect = booleanValue;
        this.binding.boxShow.setChecked(booleanValue);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void changeProgsState(BoostSelectItemBean boostSelectItemBeanVar) {
        L.d("PhoneBoostFragment","changeProgsState "+boostSelectItemBeanVar.toString()+" "+this.selectAdapter.getItemCount()+"    ");
        this.selectAdapter.addData(boostSelectItemBeanVar);
        if (this.selectAdapter.getItemCount() > 0) {
            this.selectAdapter.notifyItemChanged(this.selectAdapter.getItemCount() - 1);
        } else {
            this.selectAdapter.notifyDataSetChanged();
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void getResultList(List list) {
        this.selectAdapter.setNewInstance(list);
        this.selectAdapter.notifyDataSetChanged();
    }

    public void UpdateSizeAnimUI(String str, String str2, String str3) {
        BAFC.m(this.binding.tvSizeSum).a(str2).a(" ").h(20, true).a(str3).h(20, true).f();
        this.binding.btnBottom.setText(new BAFC().a(getString(R.string.boost_clean_btn_op_del)).a(" (").a(str).a(")").f());
    }

    public static Fragment getFrgmtInstance(int i) {
        return BAEY.newInstance(FuncFinishTitleModel.PhoneBoost.setExtras("" + i));
    }

    public static PhoneBoostFragment newInstance() {
        return new PhoneBoostFragment();
    }

    public void quit() {
        if (checkFragmentAlive()) {
//            i4.a().i("c_phoneboost_back").putEbKey1(Integer.valueOf(this.pageFrom)).commit();
            finishActivity();
        }
    }

    @Override
    public void OnSizeAnimUIUpdate(long j, long j2, long j3) {
        if (getActivity() == null || getActivity().isFinishing() || isDetached() || isRemoving()) {
            return;
        }
        try {
            mr0.b((float) j, 2, new mr0.a() {
                @Override
                public final void a(String str, String str2, String str3) {
                    UpdateSizeAnimUI(str, str2, str3);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        FragmentPhoneBoostBinding fragmentBoostBinding = this.binding;
        if (view == fragmentBoostBinding.icBack) {
            checkBack();
            return;
        }
        if (view == fragmentBoostBinding.btnBottom) {
//            i4.a().i("c_phoneboost_boost").putEbKey1(Integer.valueOf(this.pageFrom)).commit();
            List<RunningAppBean> doClean = this.vm.doClean();
            final int i = 0;
            ArrayList arrayList = new ArrayList();
            if (doClean != null && doClean.size() > 0) {
                for (RunningAppBean runningBackgrdAppsBeanVar : doClean) {
//                    i++;
                    BADJ.c cVar = new BADJ.c();
                    cVar.a = runningBackgrdAppsBeanVar.getAppIcon();
                    cVar.b = runningBackgrdAppsBeanVar.getAppName();
                    cVar.c = runningBackgrdAppsBeanVar.getAppPackageName();
                    arrayList.add(cVar);
                }
            }
            replaceFragment(new BADJ.b().d(arrayList).b(new BADJ.b.a() {
                @Override
                public final Object a() {
                    BADJ.b.InterfaceC0085b interfaceC0085b;
                    interfaceC0085b = new BADJ.b.InterfaceC0085b() {
                        @Override
                        public final void a(Fragment fragment) {
                            nr1.k().s();
                            nr1.k().f();
                        }
                    };
                    return interfaceC0085b;
                }
            }).c(new BADJ.b.a() {
                @Override
                public final Object a() {
                    Fragment fragment;
                    fragment = PhoneBoostFragment.getFrgmtInstance(i);
                    return fragment;
                }
            }).a());
            return;
        }
        if (view == fragmentBoostBinding.box) {
            this.vm.onSelectedCheckAll(!this.allSelect);
        }
    }

    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(false);
        vm = (PhoneBoostViewModel) new ViewModelProvider(this).get(PhoneBoostViewModel.class);
        binding = FragmentPhoneBoostBinding.inflate(layoutInflater);
        pageFrom = getActivity().getIntent().getIntExtra(MainActivity.FROM, 0);
//        i4.a().i("s_phoneboost").putEbKey1(Integer.valueOf(this.pageFrom)).commit();
        BindVM();
        vm.onCreate();
//        qh.c();
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        md mdVar = this.sizeAnim;
        if (mdVar != null) {
            mdVar.e();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        if (keyEvent.getAction()==KeyEvent.ACTION_DOWN && keyEvent.getRepeatCount()==0) {
            checkBack();
            return true;
        }
        return super.onKeyDown(keyCode, keyEvent);
    }

}
