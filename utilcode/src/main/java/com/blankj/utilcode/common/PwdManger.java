package com.blankj.utilcode.common;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/6/29.
 * 密码的管理器
 */

public class PwdManger {
    //显示密码
    private static final String SHOW_PWD = "0";
    //隐藏密码
    private static final String HIDE_PWD = "1";

    /**
     *  显示和隐藏密码
     * @param editText           密码输入框
     * @param imageView          显示隐藏密码的图片
     * @param resId              图片资源   注：ID=0表示隐藏图片的资源ID ,ID=1表示显示图片的资源ID
     */
    public static void setPwdShowHide(EditText editText, ImageView imageView,int[] resId){
        switch ((String) imageView.getTag()){
            case SHOW_PWD:
                //隐藏密码
                imageView.setImageResource(resId[0]);
                imageView.setTag(HIDE_PWD);
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                break;

            case HIDE_PWD:
                //显示密码
                imageView.setImageResource(resId[1]);
                imageView.setTag(SHOW_PWD);
                editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                break;
        }
    }
}
