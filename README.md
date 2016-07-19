# BlurredView

Dynamic blur of Image Views for Android. This library is based on **RenderScript**. You can find more detail about RenderScript here: [RenderScript][1]

Includes library and small example project.

![demo][2]

## Gradle

```Groovy
compile 'com.qiushui:blurredview:0.8.1'
```

## Enable RenderScript support mode:

```Groovy
defaultConfig {
    renderscriptTargetApi 19
    renderscriptSupportModeEnabled true
}
```

## How to use 

```XML
<com.qiushui.blurredview.BlurredView
      app:src="@drawable/dayu"
      app:move="true"
      android:layout_width="match_parent"
      android:layout_height="match_parent"/>
```

* You can use `app:src="@drawable/XXX"` in layout to set the image to be blurred.Or you may use `mBlurredView.setBlurredImg();` in your java code to specify the image to be blurred. 
* You can use `mBlurredView.setBlurredLevel(int alpha)`to determine the level of blur. The value of alpha is between 0 to 100.
* You can use `mBlurredView.setBlurredTop(int topDistance)`to make blurred image move when `app:move="true"` is special. The value of topDistance is between 0 to 100.
* At last, you must use `mBlurredView.showBlurredView();` to make blurred view visible. Or, you can use `disableBlurredView()` method to make blurred view invisible.

If you want to know more about this library, see [my blog][3].

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

[1]: https://developer.android.com/guide/topics/renderscript/compute.html
[2]: https://github.com/wl9739/BlurredView/blob/master/Gif/demo.gif
[3]: http://wl9739.github.io/2016/07/14/%E6%95%99%E4%BD%A0%E4%B8%80%E5%88%86%E9%92%9F%E5%AE%9E%E7%8E%B0%E6%A8%A1%E7%B3%8A%E6%95%88%E6%9E%9C/




