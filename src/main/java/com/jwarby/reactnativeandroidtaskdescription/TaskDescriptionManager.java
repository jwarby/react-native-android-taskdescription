package com.jwarby.reactnativeandroidtaskdescription;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Color;
import android.os.Build;
import android.view.ViewStub;
import android.util.Log;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

public class TaskDescriptionManager extends SimpleViewManager<ViewStub> {

  private static String REACT_CLASS = "TaskDescriptionAndroid";

  private Activity mActivity = null;
  private Integer mColor = null;
  private String mLabel = null;

  public TaskDescriptionManager(Activity activity) {
    super();

    mActivity = activity;
  }

  private void updateTaskDescription() {
    mActivity.runOnUiThread(new Runnable() {
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

          mActivity.setTaskDescription(taskDesc);
        }
      }
    });
  }

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  public ViewStub createViewInstance(ThemedReactContext context) {
    return new ViewStub(context);
  }

  @ReactProp(name = "backgroundColor")
  public void setBackgroundColor(ViewStub view, @Nullable String hex) {
    mColor = Color.parseColor(hex);

    updateTaskDescription();
  }

  @ReactProp(name = "label")
  public void setLabel(ViewStub view, @Nullable String text) {
    mLabel = text;

    updateTaskDescription();
  }
}
