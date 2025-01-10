package com.clean888.cleansuper.cleaner.utils;

import android.os.AsyncTask;

/* loaded from: classes2.dex */
public class k91 extends AsyncTask<Void, gm, Integer> implements fn.a<Void, gm, Integer> {
    private lm<gm> a;

    private k91(jm jmVar) {
        this.a = jmVar;
        jmVar.a(this);
    }

    public static void c(jm jmVar) {
        new k91(jmVar).executeOnExecutor(lq2.a().b(), new Void[0]);
    }

    @Override // fn.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(gm... gmVarArr) {
        publishProgress(gmVarArr);
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
    public void onProgressUpdate(gm... gmVarArr) {
        super.onProgressUpdate(gmVarArr);
        this.a.k(gmVarArr);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.a.o();
        this.a.j();
    }
}