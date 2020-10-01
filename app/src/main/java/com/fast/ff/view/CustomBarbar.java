package com.fast.ff.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * addLeftView 添加左边控件,按先后顺序排列
 * addRightView 添加右边控件,按先后顺序排列
 * addMiddleViewExist 添加中间控件,只允许同时存在一个
 *
 * @author fmh
 */
public class CustomBarbar extends RelativeLayout {
    private ArrayList<ViewItem> views = new ArrayList<>(0);

    public CustomBarbar(Context context) {
        super(context);
    }

    public CustomBarbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomBarbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public View addLeftView(View view) {
        return addCustomView(view, Model.LEFT);
    }

    public View addRightView(View view) {
        return addCustomView(view, Model.RIGHT);
    }

    public View addMiddleViewExist(View view) {
        return addCustomView(view, Model.MIDDLE);
    }

    private View addCustomView(View view, Model model) {
        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        int lastLeftId = -1;
        int rule = ALIGN_PARENT_LEFT;
        switch (model) {
            case LEFT:
                rule = ALIGN_PARENT_LEFT;
                break;
            case RIGHT:
                rule = ALIGN_PARENT_RIGHT;
                break;
            case MIDDLE:
                rule = CENTER_IN_PARENT;
                break;
        }
        for (ViewItem item : views) {
            if (item.model == model) {
                lastLeftId = item.view.getId();
            }
        }
        //中间只允许放一个
        if (model == Model.MIDDLE && lastLeftId != -1) {
            removeView(findViewById(lastLeftId));
            lastLeftId = -1;
        }

        if (lastLeftId == -1) {
            lp.addRule(rule);
        } else {
            switch (model) {
                case LEFT:
                    lp.leftMargin = 25;
                    lp.addRule(RIGHT_OF, lastLeftId);
                    break;
                case RIGHT:
                    lp.rightMargin = 25;
                    lp.addRule(LEFT_OF, lastLeftId);
                    break;
                case MIDDLE:
                    break;
            }

        }


        lp.addRule(CENTER_VERTICAL);
        addView(view, lp);
        views.add(new ViewItem(view, model));
        view.setId(views.size());
        return view;
    }

    /**
     * 获取textview
     *
     * @param text
     * @return
     */
    public TextView getTextView(String text) {
        TextView textView = new TextView(getContext());
        textView.setText(text);
        return textView;
    }

    /**
     * 获取ImageView
     *
     * @param resId
     * @return
     */
    public ImageView getImageView(int resId) {
        ImageView imageView = new ImageView(getContext());
        if (resId != NO_ID) {
            imageView.setImageResource(resId);
        }
        return imageView;
    }

    private class ViewItem {
        public View view;
        public Model model = Model.LEFT;

        public ViewItem(View view, Model model) {
            this.view = view;
            this.model = model;
        }

    }

    public enum Model {
        LEFT, MIDDLE, RIGHT
    }

}
