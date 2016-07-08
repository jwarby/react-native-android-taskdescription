package com.jwarby.reactnativeandroidtaskdescription;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Color;
import android.os.Build;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

public class TaskDescriptionModule extends ReactContextBaseJavaModule {

  private static String REACT_CLASS = "TaskDescriptionAndroid";

  private Integer mColor = null;
  private String mLabel = null;

  public TaskDescriptionModule(ReactApplicationContext context) {
    super(context);
  }

  private void updateTaskDescription() {
    final Activity activity = getCurrentActivity();

    if (activity == null) return;

    UiThreadUtil.runOnUiThread(new Runnable() {
      @Override
      public void run() {
        if (Build.VERSION.SDK_INT >= 21) {
          ActivityManager.TaskDescription taskDesc;

          if (mColor != null) {
            taskDesc = new ActivityManager.TaskDescription(mLabel, null, mColor);
          } else if (mLabel != null) {
            taskDesc = new ActivityManager.TaskDescription(mLabel);
          } else {
            return;
          }

          activity.setTaskDescription(taskDesc);
        }
      }
    });
  }

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @ReactMethod
  public void setBackgroundColor(@Nullable String hex) {
    mColor = Color.parseColor(hex);

    updateTaskDescription();
  }

  @ReactMethod
  public void setLabel(@Nullable String text) {
    mLabel = text;

    updateTaskDescription();
  }
}
