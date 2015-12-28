# ActvTranslate
two activity use one element

# Look

![](http://7xjizl.com1.z0.glb.clouddn.com/TransActivity1.0.gif)

# Usage

## 思路

共两个界面，起始Activity和目标Activity。

- 目标Act是透明的，当起始Act打开目标Act时，传递一个相关数据给目标Act（如高宽，如左上角的位置x,y）、图片信息；
- 在目标Act的特定位置显示那张图，这样只是相同的图片被覆盖了，界面其实看不出变化。
- 目标Act中覆盖在上面的图片向上移动，同时图片变化；目标Act的布局透明度由0变为1

ps：透明度变化这种方式对性能有点影响？

## 目标Activity

	public class GoActivity extends TransActivity {
	
	    @Override
	    public int setLayoutId() {
			// 目标Activity的xml布局
	        return R.layout.activity_go;
	    }
	
	    @Override
	    public void initData() {
			// 初始化一些信息，这里有待思考
	    }
	
	    @Override
	    public void animOver() {
	        super.animOver();
			// 图片动画结束后，父类调用此函数，我们可以在这里进行某些处理
	        initTop();
	    }
	
	    private void initTop() {
	        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
	        setSupportActionBar(toolbar);
	        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	
	        CollapsingToolbarLayout collapsingToolbar =
	                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
	        collapsingToolbar.setTitle("beautiful world");
	
	        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
	        imageView.setImageResource(imgRes);
	        Log.i("高度", "高度：" + collapsingToolbar.getHeight());
	    }
	}

## 起始Activity

	public void girlClick(View v){
        int[] startingLocation = new int[2];
        int imageRes = R.mipmap.girl0;
        if(v.getId() == R.id.start1_beautifulGirl1) {
            imageRes = R.mipmap.girl1 ;
        } else if(v.getId() == R.id.start1_beautifulGirl2) {
            imageRes = R.mipmap.girl2 ;
        } else if(v.getId() == R.id.start1_beautifulGirl3) {
            imageRes = R.mipmap.girl3 ;
        }
        startingLocation[0] = v.getLeft() ;
        startingLocation[1] = v.getTop() ;
        Log.i("startingLocation 1", startingLocation[0] + "   " + startingLocation[1]);
        ElementInfo info = new ElementInfo(v.getLeft(), v.getTop());
        GoActivity.startFromLocation(new Gson().toJson(info), imageRes, this, GoActivity.class);
        overridePendingTransition(0, 0); // 这句话清除了自带的Act动画

        int[] toolbarLocation = new int[2];
        toolbar.getLocationOnScreen(toolbarLocation);
        Log.i("toolbarLocation", toolbarLocation[0] + "   " + toolbarLocation[1]);
    }

这里我用到了一个类ElementInfo，是一个我自定义的类，里面包含了公用的部分的信息，这个是为以后扩展做准备的。


## 其他

具体的实现都在base.TransActivity里

因为我暂时想不到一个很好的基本模版，所以需要自己写的代码有点多，而且动画单一。



# to be continued ...