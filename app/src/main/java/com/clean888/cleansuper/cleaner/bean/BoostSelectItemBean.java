package com.clean888.cleansuper.cleaner.bean;


public class BoostSelectItemBean {
    public RunningAppBean runningBean;
    public boolean b;
    private boolean c;

    public BoostSelectItemBean(RunningAppBean bean) {
        this.runningBean = bean;
    }

    public boolean a() {
        return this.c;
    }

    public void b(boolean z) {
        this.c = z;
        if (this.runningBean != null) {
            this.runningBean.k(!z);
        }
    }

    @Override
    public String toString() {
        return "BoostSelectItemBean{" +
                "runningBean=" + runningBean +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}