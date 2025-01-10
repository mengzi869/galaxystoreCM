package com.clean888.cleansuper.cleaner.utils;



import androidx.core.view.ViewCompat;
import com.unity3d.player.StringFog;

/* loaded from: classes2.dex */
class p41 {
    private static final int[] h = {Integer.MIN_VALUE, 8388608, 32768, 128};
    private static final int[] i = {0, 40, 48, 56};
    private static final int[] j = {0, 8, 16, 24};
    private static final int[] k = {0, 24, 16, 8};
    private static final int[] l = {-1, ViewCompat.MEASURED_SIZE_MASK, 65535, 255};
    private transient int[] a;
    private transient long b;
    private transient int[] c;
    private transient byte[] d;
    private transient int e;
    private transient long f;

    /* renamed from: g, reason: collision with root package name */
    private transient int f1974g;

    private p41() {
        int[] iArr = new int[87];
        this.a = iArr;
        iArr[82] = 1732584193;
        iArr[83] = -271733879;
        iArr[84] = -1732584194;
        iArr[85] = 271733878;
        iArr[86] = -1009589776;
        this.b = 0L;
        this.c = new int[37];
        this.d = new byte[20];
        this.e = 20;
        this.f = 0L;
        this.f1974g = 0;
    }

    private static void a(int[] iArr) {
        int i2;
        int i3;
        int i4;
        int i5 = iArr[82];
        int i6 = iArr[83];
        int i7 = iArr[84];
        int i8 = iArr[85];
        int i9 = iArr[86];
        for (int i10 = 16; i10 < 80; i10++) {
            int i11 = ((iArr[i10 - 3] ^ iArr[i10 - 8]) ^ iArr[i10 - 14]) ^ iArr[i10 - 16];
            iArr[i10] = (i11 >>> 31) | (i11 << 1);
        }
        int i12 = 0;
        while (true) {
            i2 = 20;
            if (i12 >= 20) {
                break;
            }
            int i13 = i9 + iArr[i12] + 1518500249 + ((i5 << 5) | (i5 >>> 27)) + ((i6 & i7) | ((~i6) & i8));
            int i14 = (i6 >>> 2) | (i6 << 30);
            i12++;
            i6 = i5;
            i5 = i13;
            i9 = i8;
            i8 = i7;
            i7 = i14;
        }
        while (true) {
            i3 = 40;
            if (i2 >= 40) {
                break;
            }
            int i15 = i9 + iArr[i2] + 1859775393 + ((i5 << 5) | (i5 >>> 27)) + ((i6 ^ i7) ^ i8);
            int i16 = (i6 >>> 2) | (i6 << 30);
            i2++;
            i6 = i5;
            i5 = i15;
            i9 = i8;
            i8 = i7;
            i7 = i16;
        }
        while (true) {
            i4 = 60;
            if (i3 >= 60) {
                break;
            }
            int i17 = ((i9 + iArr[i3]) - 1894007588) + ((i5 << 5) | (i5 >>> 27)) + ((i6 & i7) | (i6 & i8) | (i7 & i8));
            int i18 = (i6 >>> 2) | (i6 << 30);
            i3++;
            i6 = i5;
            i5 = i17;
            i9 = i8;
            i8 = i7;
            i7 = i18;
        }
        while (i4 < 80) {
            int i19 = ((i9 + iArr[i4]) - 899497514) + ((i5 << 5) | (i5 >>> 27)) + ((i6 ^ i7) ^ i8);
            int i20 = (i6 >>> 2) | (i6 << 30);
            i4++;
            i6 = i5;
            i5 = i19;
            i9 = i8;
            i8 = i7;
            i7 = i20;
        }
        iArr[82] = iArr[82] + i5;
        iArr[83] = iArr[83] + i6;
        iArr[84] = iArr[84] + i7;
        iArr[85] = iArr[85] + i8;
        iArr[86] = iArr[86] + i9;
    }

    public static byte[] b(byte[] bArr, int i2) {
        p41 p41Var = new p41();
        p41Var.d(bArr);
        byte[] bArr2 = new byte[i2];
        p41Var.c(bArr2);
        return bArr2;
    }

    private void d(byte[] bArr) {
        if (bArr != null) {
            if (this.f1974g == 2) {
                System.arraycopy(this.c, 0, this.a, 82, 5);
            }
            this.f1974g = 1;
            if (bArr.length != 0) {
                f(bArr);
                return;
            }
            return;
        }
        throw new NullPointerException(StringFog.decrypt("JDYiBkVKDFMJIj8r"));
    }

    private static void e(int[] iArr, byte[] bArr, int i2, int i3) {
        int i4 = iArr[81];
        int i5 = i4 >> 2;
        int i6 = i4 & 3;
        iArr[81] = (((i4 + i3) - i2) + 1) & 63;
        if (i6 != 0) {
            while (i2 <= i3 && i6 < 4) {
                iArr[i5] = iArr[i5] | ((bArr[i2] & 255) << ((3 - i6) << 3));
                i6++;
                i2++;
            }
            if (i6 == 4 && (i5 = i5 + 1) == 16) {
                a(iArr);
                i5 = 0;
            }
            if (i2 > i3) {
                return;
            }
        }
        int i7 = ((i3 - i2) + 1) >> 2;
        for (int i8 = 0; i8 < i7; i8++) {
            iArr[i5] = ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8) | (bArr[i2 + 3] & 255);
            i2 += 4;
            i5++;
            if (i5 >= 16) {
                a(iArr);
                i5 = 0;
            }
        }
        int i9 = (i3 - i2) + 1;
        if (i9 != 0) {
            int i10 = (bArr[i2] & 255) << 24;
            if (i9 != 1) {
                i10 |= (bArr[i2 + 1] & 255) << 16;
                if (i9 != 2) {
                    i10 |= (bArr[i2 + 2] & 255) << 8;
                }
            }
            iArr[i5] = i10;
        }
    }

    private void f(byte[] bArr) {
        e(this.a, bArr, 0, bArr.length - 1);
        this.b += bArr.length;
    }

    protected synchronized void c(byte[] bArr) {
        int i2;
        int i3;
        int i4;
        int i5;
        try {
            if (bArr != null) {
                int[] iArr = this.a;
                int i6 = iArr[81] == 0 ? 0 : (iArr[81] + 7) >> 2;
                int i7 = this.f1974g;
                if (i7 != 0) {
                    if (i7 == 1) {
                        System.arraycopy(iArr, 82, this.c, 0, 5);
                        for (int i8 = i6 + 3; i8 < 18; i8++) {
                            this.a[i8] = 0;
                        }
                        long j2 = (this.b << 3) + 64;
                        int[] iArr2 = this.a;
                        if (iArr2[81] < 48) {
                            iArr2[14] = (int) (j2 >>> 32);
                            iArr2[15] = (int) (j2 & (-1));
                            i2 = i6;
                        } else {
                            int[] iArr3 = this.c;
                            i2 = i6;
                            iArr3[19] = (int) (j2 >>> 32);
                            iArr3[20] = (int) (j2 & (-1));
                        }
                        this.e = 20;
                    } else {
                        i2 = i6;
                    }
                    this.f1974g = 2;
                    if (bArr.length == 0) {
                        return;
                    }
                    int i9 = this.e;
                    int length = 20 - i9 < bArr.length - 0 ? 20 - i9 : bArr.length - 0;
                    if (length > 0) {
                        System.arraycopy(this.d, i9, bArr, 0, length);
                        this.e += length;
                        i3 = length + 0;
                    } else {
                        i3 = 0;
                    }
                    if (i3 >= bArr.length) {
                        return;
                    }
                    int i10 = this.a[81] & 3;
                    do {
                        if (i10 == 0) {
                            int[] iArr4 = this.a;
                            long j3 = this.f;
                            iArr4[i2] = (int) (j3 >>> 32);
                            iArr4[i2 + 1] = (int) (j3 & (-1));
                            iArr4[i2 + 2] = h[0];
                            i4 = i3;
                        } else {
                            int[] iArr5 = this.a;
                            int i11 = iArr5[i2];
                            long j4 = this.f;
                            i4 = i3;
                            iArr5[i2] = i11 | ((int) ((j4 >>> i[i10]) & l[i10]));
                            iArr5[i2 + 1] = (int) ((j4 >>> j[i10]) & (-1));
                            iArr5[i2 + 2] = (int) ((j4 << k[i10]) | h[i10]);
                        }
                        int[] iArr6 = this.a;
                        if (iArr6[81] > 48) {
                            int[] iArr7 = this.c;
                            iArr7[5] = iArr6[16];
                            iArr7[6] = iArr6[17];
                        }
                        a(iArr6);
                        int[] iArr8 = this.a;
                        if (iArr8[81] > 48) {
                            System.arraycopy(iArr8, 0, this.c, 21, 16);
                            System.arraycopy(this.c, 5, this.a, 0, 16);
                            a(this.a);
                            System.arraycopy(this.c, 21, this.a, 0, 16);
                        }
                        this.f++;
                        int i12 = 0;
                        for (int i13 = 0; i13 < 5; i13++) {
                            int i14 = this.a[i13 + 82];
                            byte[] bArr2 = this.d;
                            bArr2[i12] = (byte) (i14 >>> 24);
                            bArr2[i12 + 1] = (byte) (i14 >>> 16);
                            bArr2[i12 + 2] = (byte) (i14 >>> 8);
                            bArr2[i12 + 3] = (byte) i14;
                            i12 += 4;
                        }
                        this.e = 0;
                        int length2 = 20 < bArr.length - i4 ? 20 : bArr.length - i4;
                        if (length2 > 0) {
                            int i15 = i4;
                            System.arraycopy(this.d, 0, bArr, i15, length2);
                            i5 = i15 + length2;
                            this.e += length2;
                        } else {
                            i5 = i4;
                        }
                        i3 = i5;
                    } while (i3 < bArr.length);
                    return;
                }
                throw new IllegalStateException(StringFog.decrypt("GTxnEQASVVMUIiM3DgwSVVI="));
            }
            throw new NullPointerException(StringFog.decrypt("NSozBxZXDE5HOSYrDg=="));
        } catch (Throwable th) {
            throw th;
        }
    }
}
