package com.blankj.utilcode.common;

import android.app.Application;

/**
 * 所有Activity生命周期必走的回调接口
 * 用法：
 * 在Application的onCreate()中  进行调用 ActivityLifecycleCallbacks.getInstance().registerActivityLifecycleCallbacks(...);
 */

public class ActivityLifecycleCallbacks {

    private ActivityLifecycleCallbacks() {
        if(Inner.activityLifecycleCallbacks != null){
            throw new RuntimeException();
        }
    }

    private static class Inner{
        private static ActivityLifecycleCallbacks activityLifecycleCallbacks = new ActivityLifecycleCallbacks();
    }

    public static ActivityLifecycleCallbacks getInstance(){
        return Inner.activityLifecycleCallbacks;
    }

    public void registerActivityLifecycleCallbacks(Application application,Application.ActivityLifecycleCallbacks callback) {
        application.registerActivityLifecycleCallbacks(callback);
    }
}
