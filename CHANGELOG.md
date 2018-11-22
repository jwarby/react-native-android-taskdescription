# `v1.0.5 (22nd Nov 2018)`

- If root project defines compile/targetSdkVersion/buildToolsVersion, use those

# `v1.0.4 (24th May 2018)`

- Added a dummy implementation for iOS so that apps using this module can be
  built on iOS without error

# `v1.0.3 (22nd Sep 2017)`

- Migrate from React.PropTypes to `prop-types` package - `a287c10a` (thanks @sladkoff)

# `v1.0.2 (12th Sep 2017)`

- Updates for React Native >= 0.47 - remove `@overrides` declaration from `createJSModules` - `1973b66d` (thanks @christophervalles)

# `v1.0.1 (20th Oct 2016)`

Add support for linking project using `react-native link`.

# `v1.0.0 (8th Jul 2016)`

- Changes to make plugin compatible with React Native 0.29
- Change API for setting text - use label prop instead of `<Text />` child component

# `v0.2.0 (20th May 2016)`

Import React, Component and PropTypes from `react` instead of `react-native` as per changes in `react-native@0.25+`.
RN 0.25 spat out warnings about importing these from `react-native`, and 0.26 removed the warnings and just failed instead.

# `v0.1.0 (14th Apr 2016)`

First released version.
