package com.clean888.cleansuper.cleaner.utils;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ChangedPackages;
import android.content.pm.FeatureInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.VersionedPackage;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

/* loaded from: classes2.dex */
public class PkgManager extends PackageManager {
    private final PackageManager a;
    private final Context b;
    private String c;
    private String d;

    public PkgManager(PackageManager packageManager, String str, Context context, String str2) {
        this.a = packageManager;
        this.c = str;
        this.b = context;
        this.d = str2;
    }

    @Override // android.content.pm.PackageManager
    public void addPackageToPreferred(String str) {
        this.a.addPackageToPreferred(str);
    }

    @Override // android.content.pm.PackageManager
    public boolean addPermission(PermissionInfo permissionInfo) {
        return this.a.addPermission(permissionInfo);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(8)
    public boolean addPermissionAsync(PermissionInfo permissionInfo) {
        return this.a.addPermissionAsync(permissionInfo);
    }

    @Override // android.content.pm.PackageManager
    public void addPreferredActivity(IntentFilter intentFilter, int i, ComponentName[] componentNameArr, ComponentName componentName) {
        this.a.addPreferredActivity(intentFilter, i, componentNameArr, componentName);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(26)
    public boolean canRequestPackageInstalls() {
        return this.a.canRequestPackageInstalls();
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(8)
    public String[] canonicalToCurrentPackageNames(String[] strArr) {
        return this.a.canonicalToCurrentPackageNames(strArr);
    }

    @Override // android.content.pm.PackageManager
    public int checkPermission(String str, String str2) {
        if (this.c.equals(str2)) {
            str2 = this.b.getPackageName();
        }
        return this.a.checkPermission(str, str2);
    }

    @Override // android.content.pm.PackageManager
    public int checkSignatures(String str, String str2) {
        return this.a.checkSignatures(str, str2);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(26)
    public void clearInstantAppCookie() {
        this.a.clearInstantAppCookie();
    }

    @Override // android.content.pm.PackageManager
    public void clearPackagePreferredActivities(String str) {
        this.a.clearPackagePreferredActivities(str);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(8)
    public String[] currentToCanonicalPackageNames(String[] strArr) {
        return this.a.currentToCanonicalPackageNames(strArr);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(17)
    public void extendVerificationTimeout(int i, int i2, long j) {
        this.a.extendVerificationTimeout(i, i2, j);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(20)
    public Drawable getActivityBanner(ComponentName componentName) throws PackageManager.NameNotFoundException {
        return this.a.getActivityBanner(componentName);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityIcon(ComponentName componentName) throws PackageManager.NameNotFoundException {
        return this.a.getActivityIcon(componentName);
    }

    @Override // android.content.pm.PackageManager
    public ActivityInfo getActivityInfo(ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
        if (componentName != null && this.c.equals(componentName.getPackageName())) {
            componentName = new ComponentName(this.b.getPackageName(), componentName.getClassName());
        }
        return this.a.getActivityInfo(componentName, i);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(9)
    public Drawable getActivityLogo(ComponentName componentName) throws PackageManager.NameNotFoundException {
        return this.a.getActivityLogo(componentName);
    }

    @Override // android.content.pm.PackageManager
    public List<PermissionGroupInfo> getAllPermissionGroups(int i) {
        return this.a.getAllPermissionGroups(i);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(20)
    public Drawable getApplicationBanner(ApplicationInfo applicationInfo) {
        return this.a.getApplicationBanner(applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public int getApplicationEnabledSetting(String str) {
        return this.a.getApplicationEnabledSetting(str);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationIcon(ApplicationInfo applicationInfo) {
        return this.a.getApplicationIcon(applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public ApplicationInfo getApplicationInfo(String str, int i) throws PackageManager.NameNotFoundException {
        if (!TextUtils.isEmpty(this.c) && str.equals(this.c)) {
            ApplicationInfo applicationInfo = this.a.getApplicationInfo(this.b.getPackageName(), i);
            applicationInfo.packageName = this.c;
            return applicationInfo;
        }
        return this.a.getApplicationInfo(str, i);
    }

    @Override // android.content.pm.PackageManager
    public CharSequence getApplicationLabel(ApplicationInfo applicationInfo) {
        return this.a.getApplicationLabel(applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(9)
    public Drawable getApplicationLogo(ApplicationInfo applicationInfo) {
        return this.a.getApplicationLogo(applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    @Nullable
    @TargetApi(26)
    public ChangedPackages getChangedPackages(int i) {
        return this.a.getChangedPackages(i);
    }

    @Override // android.content.pm.PackageManager
    public int getComponentEnabledSetting(ComponentName componentName) {
        return this.a.getComponentEnabledSetting(componentName);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getDefaultActivityIcon() {
        return this.a.getDefaultActivityIcon();
    }

    @Override // android.content.pm.PackageManager
    public Drawable getDrawable(String str, int i, ApplicationInfo applicationInfo) {
        return this.a.getDrawable(str, i, applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public List<ApplicationInfo> getInstalledApplications(int i) {
        return this.a.getInstalledApplications(i);
    }

    @Override // android.content.pm.PackageManager
    public List<PackageInfo> getInstalledPackages(int i) {
        return this.a.getInstalledPackages(i);
    }

    @Override // android.content.pm.PackageManager
    public String getInstallerPackageName(String str) {
        return this.a.getInstallerPackageName(str);
    }

    @Override // android.content.pm.PackageManager
    @NonNull
    @TargetApi(26)
    public byte[] getInstantAppCookie() {
        return this.a.getInstantAppCookie();
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(26)
    public int getInstantAppCookieMaxBytes() {
        return this.a.getInstantAppCookieMaxBytes();
    }

    @Override // android.content.pm.PackageManager
    public InstrumentationInfo getInstrumentationInfo(ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
        return this.a.getInstrumentationInfo(componentName, i);
    }

    @Override // android.content.pm.PackageManager
    public Intent getLaunchIntentForPackage(String str) {
        return this.a.getLaunchIntentForPackage(str);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(21)
    public Intent getLeanbackLaunchIntentForPackage(String str) {
        return this.a.getLeanbackLaunchIntentForPackage(str);
    }

    @Override // android.content.pm.PackageManager
    public String getNameForUid(int i) {
        return this.a.getNameForUid(i);
    }

    @Override // android.content.pm.PackageManager
    public int[] getPackageGids(String str) throws PackageManager.NameNotFoundException {
        return this.a.getPackageGids(str);
    }

    @Override // android.content.pm.PackageManager
    public PackageInfo getPackageInfo(String str, int i) throws PackageManager.NameNotFoundException {
        ConWrapper.b();
        if (!TextUtils.isEmpty(this.c) && str.equals(this.c)) {
            PackageInfo packageInfo = this.a.getPackageInfo(this.b.getPackageName(), i);
            packageInfo.packageName = this.c;
            return packageInfo;
        }
        return this.a.getPackageInfo(str, i);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(21)
    public PackageInstaller getPackageInstaller() {
        return this.a.getPackageInstaller();
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(24)
    public int getPackageUid(String str, int i) throws PackageManager.NameNotFoundException {
        return this.a.getPackageUid(str, i);
    }

    @Override // android.content.pm.PackageManager
    public String[] getPackagesForUid(int i) {
        return this.a.getPackagesForUid(i);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(18)
    public List<PackageInfo> getPackagesHoldingPermissions(String[] strArr, int i) {
        return this.a.getPackagesHoldingPermissions(strArr, i);
    }

    @Override // android.content.pm.PackageManager
    public PermissionGroupInfo getPermissionGroupInfo(String str, int i) throws PackageManager.NameNotFoundException {
        return this.a.getPermissionGroupInfo(str, i);
    }

    @Override // android.content.pm.PackageManager
    public PermissionInfo getPermissionInfo(String str, int i) throws PackageManager.NameNotFoundException {
        return this.a.getPermissionInfo(str, i);
    }

    @Override // android.content.pm.PackageManager
    public int getPreferredActivities(List<IntentFilter> list, List<ComponentName> list2, String str) {
        return this.a.getPreferredActivities(list, list2, str);
    }

    @Override // android.content.pm.PackageManager
    public List<PackageInfo> getPreferredPackages(int i) {
        return this.a.getPreferredPackages(i);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(9)
    public ProviderInfo getProviderInfo(ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
        return this.a.getProviderInfo(componentName, i);
    }

    @Override // android.content.pm.PackageManager
    public ActivityInfo getReceiverInfo(ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
        return this.a.getReceiverInfo(componentName, i);
    }

    @Override // android.content.pm.PackageManager
    public Resources getResourcesForActivity(ComponentName componentName) throws PackageManager.NameNotFoundException {
        return this.a.getResourcesForActivity(componentName);
    }

    @Override // android.content.pm.PackageManager
    public Resources getResourcesForApplication(ApplicationInfo applicationInfo) throws PackageManager.NameNotFoundException {
        return this.a.getResourcesForApplication(applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public ServiceInfo getServiceInfo(ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
        return this.a.getServiceInfo(componentName, i);
    }

    @Override // android.content.pm.PackageManager
    @NonNull
    @TargetApi(26)
    public List<SharedLibraryInfo> getSharedLibraries(int i) {
        return this.a.getSharedLibraries(i);
    }

    @Override // android.content.pm.PackageManager
    public FeatureInfo[] getSystemAvailableFeatures() {
        return this.a.getSystemAvailableFeatures();
    }

    @Override // android.content.pm.PackageManager
    public String[] getSystemSharedLibraryNames() {
        return this.a.getSystemSharedLibraryNames();
    }

    @Override // android.content.pm.PackageManager
    public CharSequence getText(String str, int i, ApplicationInfo applicationInfo) {
        return this.a.getText(str, i, applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(21)
    public Drawable getUserBadgedDrawableForDensity(Drawable drawable, UserHandle userHandle, Rect rect, int i) {
        return this.a.getUserBadgedDrawableForDensity(drawable, userHandle, rect, i);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(21)
    public Drawable getUserBadgedIcon(Drawable drawable, UserHandle userHandle) {
        return this.a.getUserBadgedIcon(drawable, userHandle);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(21)
    public CharSequence getUserBadgedLabel(CharSequence charSequence, UserHandle userHandle) {
        return this.a.getUserBadgedLabel(charSequence, userHandle);
    }

    @Override // android.content.pm.PackageManager
    public XmlResourceParser getXml(String str, int i, ApplicationInfo applicationInfo) {
        return this.a.getXml(str, i, applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public boolean hasSystemFeature(String str) {
        return this.a.hasSystemFeature(str);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(26)
    public boolean isInstantApp() {
        return this.a.isInstantApp();
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(23)
    public boolean isPermissionRevokedByPolicy(String str, String str2) {
        return this.a.isPermissionRevokedByPolicy(str, str2);
    }

    @Override // android.content.pm.PackageManager
    public boolean isSafeMode() {
        return this.a.isSafeMode();
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int i) {
        return this.a.queryBroadcastReceivers(intent, i);
    }

    @Override // android.content.pm.PackageManager
    public List<ProviderInfo> queryContentProviders(String str, int i, int i2) {
        return this.a.queryContentProviders(str, i, i2);
    }

    @Override // android.content.pm.PackageManager
    public List<InstrumentationInfo> queryInstrumentation(String str, int i) {
        return this.a.queryInstrumentation(str, i);
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryIntentActivities(Intent intent, int i) {
        return this.a.queryIntentActivities(intent, i);
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryIntentActivityOptions(ComponentName componentName, Intent[] intentArr, Intent intent, int i) {
        return this.a.queryIntentActivityOptions(componentName, intentArr, intent, i);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(19)
    public List<ResolveInfo> queryIntentContentProviders(Intent intent, int i) {
        return this.a.queryIntentContentProviders(intent, i);
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryIntentServices(Intent intent, int i) {
        return this.a.queryIntentActivities(intent, i);
    }

    @Override // android.content.pm.PackageManager
    public List<PermissionInfo> queryPermissionsByGroup(String str, int i) throws PackageManager.NameNotFoundException {
        return this.a.queryPermissionsByGroup(str, i);
    }

    @Override // android.content.pm.PackageManager
    public void removePackageFromPreferred(String str) {
        this.a.removePackageFromPreferred(str);
    }

    @Override // android.content.pm.PackageManager
    public void removePermission(String str) {
        this.a.removePermission(str);
    }

    @Override // android.content.pm.PackageManager
    public ResolveInfo resolveActivity(Intent intent, int i) {
        ComponentName component = intent.getComponent();
        if (component != null && this.c.equals(component.getPackageName())) {
            intent.setComponent(new ComponentName(this.b.getPackageName(), component.getClassName()));
        }
        return this.a.resolveActivity(intent, i);
    }

    @Override // android.content.pm.PackageManager
    public ProviderInfo resolveContentProvider(String str, int i) {
        return this.a.resolveContentProvider(str, i);
    }

    @Override // android.content.pm.PackageManager
    public ResolveInfo resolveService(Intent intent, int i) {
        return this.a.resolveService(intent, i);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(26)
    public void setApplicationCategoryHint(@NonNull String str, int i) {
        this.a.setApplicationCategoryHint(str, i);
    }

    @Override // android.content.pm.PackageManager
    public void setApplicationEnabledSetting(String str, int i, int i2) {
        this.a.setApplicationEnabledSetting(str, i, i2);
    }

    @Override // android.content.pm.PackageManager
    public void setComponentEnabledSetting(ComponentName componentName, int i, int i2) {
        this.a.setComponentEnabledSetting(componentName, i, i2);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(11)
    public void setInstallerPackageName(String str, String str2) {
        this.a.setInstallerPackageName(str, str2);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(26)
    public void updateInstantAppCookie(@Nullable byte[] bArr) {
        this.a.updateInstantAppCookie(bArr);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(14)
    public void verifyPendingInstall(int i, int i2) {
        this.a.verifyPendingInstall(i, i2);
    }

    @Override // android.content.pm.PackageManager
    public int checkSignatures(int i, int i2) {
        return this.a.checkSignatures(i, i2);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(20)
    public Drawable getActivityBanner(Intent intent) throws PackageManager.NameNotFoundException {
        return this.a.getActivityBanner(intent);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityIcon(Intent intent) throws PackageManager.NameNotFoundException {
        return this.a.getActivityIcon(intent);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(9)
    public Drawable getActivityLogo(Intent intent) throws PackageManager.NameNotFoundException {
        return this.a.getActivityLogo(intent);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(20)
    public Drawable getApplicationBanner(String str) throws PackageManager.NameNotFoundException {
        return this.a.getApplicationBanner(str);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationIcon(String str) throws PackageManager.NameNotFoundException {
        return this.a.getApplicationIcon(str);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(9)
    public Drawable getApplicationLogo(String str) throws PackageManager.NameNotFoundException {
        return this.a.getApplicationLogo(str);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(24)
    public int[] getPackageGids(String str, int i) throws PackageManager.NameNotFoundException {
        return this.a.getPackageGids(str, i);
    }

    @Override // android.content.pm.PackageManager
    public Resources getResourcesForApplication(String str) throws PackageManager.NameNotFoundException {
        return this.a.getResourcesForApplication(str);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(24)
    public boolean hasSystemFeature(String str, int i) {
        return this.a.hasSystemFeature(str, i);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(26)
    public boolean isInstantApp(String str) {
        return this.a.isInstantApp(str);
    }

    @Override // android.content.pm.PackageManager
    @TargetApi(26)
    public PackageInfo getPackageInfo(VersionedPackage versionedPackage, int i) throws PackageManager.NameNotFoundException {
        return this.a.getPackageInfo(versionedPackage, i);
    }
}
