package aditya.rupal.translate.orcandtext.application;

import android.app.Application;

import aditya.rupal.translate.orcandtext.R;
import aditya.rupal.translate.orcandtext.utils.TypefaceUtil;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class ApplicationActivity extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "GoogleSans-Regular.ttf"); // font from assets: "assets/fonts/Roboto-Regular.ttf

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("GoogleSans-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
