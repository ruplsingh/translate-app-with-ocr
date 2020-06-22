package aditya.rupal.translate.orcandtext.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import aditya.rupal.translate.orcandtext.R;
import aditya.rupal.translate.orcandtext.utils.TypefaceHelper;

/**
 * @author aditya gupta
 */

public class SansFontCollapsingToolbarLayout extends CollapsingToolbarLayout {
    public SansFontCollapsingToolbarLayout(Context context) {
        super(context);
        init(context);
    }

    public SansFontCollapsingToolbarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SansFontCollapsingToolbarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        Typeface typefaceBold = TypefaceHelper.get(context, getResources().getString(R.string.sans_bold));
        setExpandedTitleTypeface(typefaceBold);
        setCollapsedTitleTypeface(typefaceBold);

    }

    public void setTitle(int i) {
        setTitle(getContext().getString(i));
    }
}
