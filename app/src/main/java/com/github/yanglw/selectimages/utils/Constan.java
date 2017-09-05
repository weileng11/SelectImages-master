package com.github.yanglw.selectimages.utils;

/**
 * 用于定义一些常量。<br/>
 * <br/>
 * Created by yanglw on 2014/8/15.
 */
public class Constan
{
    /** 表示通过Intent传递到下一个Activity的图片列表。 */
    public static final String ARG_PHOTO_LIST = "com.github.yanglw.selectimages.PHOTO_LIST";
    /** 表示通过Intent传递到上一个Activity的图片列表。 */
    public static final String RES_PHOTO_LIST = "com.github.yanglw.selectimages.PHOTO_LIST";

    /** 表示选择的图片发生了变化。 */
    public static final int RESULT_CHANGE = 10010;

    /** 最多能够选择的图片个数，如果数值小于0，则表示没有上限限制。 */
    public static final int MAX_SIZE = 10;
}
