package com.clean888.cleansuper.cleaner.utils;


import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: classes2.dex */
public class i92 extends bn<jm> {
    private String b;

    @Override // defpackage.bn
    protected void e(String str) {
        if (this.b == null) {
            this.b = StringFog.decrypt("HRETNg0FVBIDCBYRPTU2YzYpAw==");
        }
        try {
            LiveEventBus.get(this.b, String.class).post(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.bn
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public String c(jm jmVar) {
        return jmVar.q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.bn
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(jm jmVar) {
        k91.c(jmVar);
    }
}