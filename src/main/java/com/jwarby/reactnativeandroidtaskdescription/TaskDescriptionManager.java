package com.jwarby.reactnativeandroidtaskdescription;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.TaskDescription;
import android.graphics.Color;
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
  private String mColor = null;
  private String mLabel = null;

  public TaskDescriptionManager(Activity activity) {
    super();

    mActivity = activity;
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
    mColor = hex;

    final int color = Color.parseColor(hex);

    final TaskDescription taskDesc = new TaskDescription(mLabel, null, color);

    mActivity.setTaskDescription(taskDesc); 
  }

  @ReactProp(name = "label")
  public void setLabel(ViewStub view, @Nullable String text) {
    TaskDescription taskDesc;

    mLabel = text;

    if (mColor != null) {
      taskDesc = new TaskDescription(text, null, Color.parseColor(mColor));
    } else {
      taskDesc = new TaskDescription(text);
    }

    mActivity.setTaskDescription(taskDesc);
  }
}
