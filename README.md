# React Native Android TaskDescription
> Android TaskDescription component for React Native

## Overview

Allows configuration of the [Android TaskDescription](http://developer.android.com/reference/android/app/ActivityManager.TaskDescription.html), allowing
you to change the background color and text of the TaskDescription shown on the recent apps Overview Cards.  Changing the icon is not yet supported.

### Examples

#### Change the color

```javascript
import TaskDescriptionAndroid from 'react-native-android-taskdescription'

  // ...
  render() {
    return (
      <View>
        <TaskDescriptionAndroid backgroundColor="#8fa224" />
        <Text>My awesome app!</Text>
      </View>
    )
  }
```

![Change TaskDescription background color](https://raw.githubusercontent.com/jwarby/react-native-android-taskdescription/master/screenshots/color.png)

#### Change the text

```javascript
import TaskDescriptionAndroid from 'react-native-android-taskdescription'

  // ...
  render() {
    return (
      <View>
        <TaskDescriptionAndroid label="Super Awesome App" />
        <Text>My awesome app!</Text>
      </View>
    )
  }
```

![Change TaskDescription text](https://raw.githubusercontent.com/jwarby/react-native-android-taskdescription/master/screenshots/text.png)

#### Change color and text

```javascript
import TaskDescriptionAndroid from 'react-native-android-taskdescription'

  // ...render
  render() {
    return (
      <View>
        <TaskDescriptionAndroid backgroundColor="#5c34d2" label="Super Awesome App" />

        <Text>My awesome app!</Text>
      </View>
    )
  }
```

![Change TaskDescription background color and text](https://raw.githubusercontent.com/jwarby/react-native-android-taskdescription/master/screenshots/color-and-text.png)

## Installation and setup

### Install

```bash
npm install --save react-native-android-taskdescription
```

**IMPORTANT:** for RN <= 0.28, please use version 0.2.0 and follow the README installation and usage instructions from that version, ie `npm install --save react-native-android-taskdescription@0.2.0`

### Setup

#### Option 1 (recommended): Automatically

After installing, run:

```bash
react-native link
```

#### Option 2: Manually
##### Update android/settings.gradle

```
...
include ':react-native-android-taskdescription'
project(':react-native-android-taskdescription').projectDir = new File(settingsDir, '../node_modules/react-native-android-taskdescription/android')
```

##### Update android/app/build.gradle

```
...
dependencies {
  ...
  compile project(':react-native-android-taskdescription')
}
```

#### Register module in `MainApplication.java`

```java
  import com.jwarby.reactnativeandroidtaskdescription.TaskDescriptionPackage; // <--- import package

  // ...
  @Override
  protected List<ReactPackage> getPackages() {
    return Arrays.<ReactPackage>asList(
      new MainReactPackage(),
      new TaskDescriptionPackage() // <--- add package
    );
  }
```
