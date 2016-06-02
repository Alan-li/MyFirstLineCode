package com.android.alan.broadcastreceiverpratice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity收集类
 * Created by Administrator on 13/4/2016.
 */
public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>(); // 暂存活动

    /**
     * 添加活动
     *
     * @param activity
     */
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * 移除活动
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * 将lists中的activity全部销毁
     */
    public static void finishAll() {
        for (Activity activity :
                activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }

    }

}
