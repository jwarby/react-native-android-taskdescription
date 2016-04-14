# React Native Android TaskDescription
> Android TaskDescription component for React Native

## Installation and setup

### Install

```bash
npm install --save react-native-android-taskdescription
```

### Update android/settings.gradle

```
...
include ':react-native-android-taskdescription'
project(':react-native-android-taskdescription').projectDir = new File(settingsDir, '../node_modules/react-native-android-taskdescription')
```

### Update android/app/build.gradle

```
...
dependencies {
  ...
  compile project(':react-native-android-taskdescription')
}
```

### Register module in `MainActivity.java`

```java
  import com.frogeducationsdnbhd.react.views.ReactActionBarPackage;

  // ...
 /**
  * A list of packages used by the app. If the app uses additional views
  * or modules besides the default ones, add more packages here.
  */
  @Override
  protected List<ReactPackage> getPackages() {
    return Arrays.<ReactPackage>asList(
      new MainReactPackage(),
      new ReactActionBarPackage(this) // <------- add package, the 'this' is super important
    );
  }
```

## Usage

```javascript
import TaskDescription from 'react-native-android-taskdescription'

  // ...

  render() {
    return (
      <View>
        <TaskDescription backgroundColor="#FF0000">
          <Text>My Awesome Task</Text>
        </TaskDescription>
        ...
      </View>
    )
  }
```
