package com.clean888.cleansuper.cleaner.utils;

import android.os.AsyncTask;

/* loaded from: classes2.dex */
public class z81 extends AsyncTask<Void, b91, Integer> implements fn.a<Void, b91, Integer> {
    private lm<b91> a;

    private z81(hm hmVar) {
        this.a = hmVar;
        hmVar.a(this);
    }

    public static void c(hm hmVar) {
        new z81(hmVar).executeOnExecutor(lq2.a().b(), new Void[0]);
    }

    @Override // fn.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(b91... b91VarArr) {
        publishProgress(b91VarArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Void... voidArr) {
        try {
            return this.a.e(voidArr);
        } catch (Exception unused) {
            return this.a.h;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        this.a.i(num);
        this.a.f();
        this.a.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(b91... b91VarArr) {
        super.onProgressUpdate(b91VarArr);
        this.a.k(b91VarArr);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.a.o();
        this.a.j();
    }
}