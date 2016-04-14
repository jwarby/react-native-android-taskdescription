package com.jwarby.reactnativeandroidtaskdescription;

import android.app.Activity;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskDescriptionPackage implements ReactPackage {

  private Activity mActivity = null;

  public TaskDescriptionPackage(Activity activity) {
    super();

    mActivity = activity;
  }

  @Override
  public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
    return new ArrayList<>();
  }

  @Override
  public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
    return Arrays.<ViewManager>asList(
      new TaskDescriptionManager(mActivity)
    );
  }

  @Override
  public List<Class<? extends JavaScriptModule>> createJSModules() {
    return Arrays.asList();
  }
}
