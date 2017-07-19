package com.blankj.utilcode.common;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

/**
 * <pre>
 *    Created by Administrator on 2017/6/30.
 *     下列为举例其用法：
 *     int r = random.nextInt(210);
 *     int g = random.nextInt(210);
 *     int b = random.nextInt(210);
 *     tv.setBackground(
 *     DrawableUtil.getSelector(DrawableUtil.getDrawable(Color.rgb(r, g, b), UIUtils.dp2px(5)),
 *     DrawableUtil.getDrawable(Color.WHITE)));
 * </pre>
 */

public class DrawableUtil {
    /**
     * 定义一个shape资源
     *
     * @param rgb  填充的颜色   还可以设置
     *             gradientDrawable.setShape(GradientDrawable.RECTANGLE);
     *              gradientDrawable.setCornerRadius(corneradius);
     *              gradientDrawable.setStroke(UIUtils.dp2px(1), rgb);  等等
     * @return
     */
    public static GradientDrawable getDrawable(int rgb) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(rgb);
        return gradientDrawable;
    }

    /**
     * 定义一个Selector资源
     * @param normalDrawable         默认状态下的图片资源
     * @param pressDrawable          被点击下的图片资源
     * @return
     */
    public static StateListDrawable getSelector(Drawable normalDrawable, Drawable pressDrawable) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        //给当前的颜色选择器添加选中图片指向状态，未选中图片指向状态
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_pressed}, pressDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled}, normalDrawable);
        //设置默认状态
        stateListDrawable.addState(new int[]{}, normalDrawable);
        return stateListDrawable;
    }
}
