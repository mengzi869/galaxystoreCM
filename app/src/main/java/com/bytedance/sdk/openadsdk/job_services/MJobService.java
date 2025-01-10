package com.bytedance.sdk.openadsdk.job_services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 21)
/* loaded from: classes3.dex */
public class MJobService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
