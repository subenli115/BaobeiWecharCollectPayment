package com.ziran.meiliao.bindingadapter;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.ziran.meiliao.GlideApp;
import com.ziran.meiliao.util.GlideCircleTransform;

/**
 * 类说明
 *
 * @author renjialiang
 * @version [版本]
 * @see [相关类]
 * @since [模块]
 */
public class ImageBindingAdapter {

    @BindingAdapter({"img:imgurl", "img:placeholder", "img:error"})
    public static void loadImage(ImageView imageView, String url, Drawable holderDrawable,
            Drawable errorDrawable) {
        if (url == null) {
            url = "";
        }
        GlideApp.with(imageView.getContext())
                .load(Uri.parse(url))
                .placeholder(holderDrawable)
                .error(errorDrawable)
                .fitCenter()
                .transform(new GlideCircleTransform())
                .into(imageView);
    }

    @BindingAdapter("img:src")
    public static void setSrc(ImageView imageView, int resId) {
        imageView.setImageResource(resId);
    }
}
