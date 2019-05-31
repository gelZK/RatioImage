# RatioImage
设置ImageView宽高比  
如果使用的是Fresco，可以将RatioImageView继承SimpleDraweeView或者自定义的DraweeView  
 app:ratio_dominant="width"//取值：width:以宽度为基准值;height:以高度为基准值;normal:不设置比例(默认)  
 app:ratio_width="3"//设置宽度占比  
 app:ratio_height="1"//设置高度占比  
 #### 注：ratio_width和ratio_height 必须成对出现，否则设置无效。
