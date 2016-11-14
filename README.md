# LoadingLayout
一个简单的切换加载中，空页面，出错页面和内容页面的布局
思路很简单自定义布局继承Framelayout，默认第一个子View为StateView，第二个子view为LoadingView，第三个子布局为EmptyView。默认界面加载完成后隐藏所有用户自定义布局。只显示以上其中一个布局
![demo.gif](https://github.com/Hemumu/LoadingLayout/blob/master/app/src/main/res/raw/demo.gif)

#####使用
```

compile 'com.helin.loadinglayout:loadinglayout:0.0.1'

```

博客地址[http://www.jianshu.com/p/b366f72857e8](http://www.jianshu.com/p/b366f72857e8)
