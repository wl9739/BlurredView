# BlurredView

Dynamic blur of Image Views for Android. 
Includes library and small example project.

![demo][1]

## Gradle

```Groovy
compile 'com.qiushui:blurview:0.8.0'
```

## How to use 

```XML
<com.qiushui.blurredview.BlurredView
      app:src="@drawable/dayu"
      app:move="true"
      android:layout_width="match_parent"
      android:layout_height="match_parent"/>
```

* You can use `mBlurredView.setBlurredLevel(int alpha)`to determine the level of blur.
* You can use `mBlurredView.setBlurredTop(int topDistance)`to make blurred image move when `app:move="true"` is special.

## Enable RenderScript support mode:

```Groovy
 defaultConfig {
        renderscriptTargetApi 19
        renderscriptSupportModeEnabled true
  }
```

If you want to know more about this library. see [my blog][http://wl9739.github.io/2016/07/14/%E6%95%99%E4%BD%A0%E4%B8%80%E5%88%86%E9%92%9F%E5%AE%9E%E7%8E%B0%E6%A8%A1%E7%B3%8A%E6%95%88%E6%9E%9C/]

License
-------

    Copyright 2016 Qiushui

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


[1]: https://github.com/wl9739/BlurredView/blob/master/Gif/demo.gif
