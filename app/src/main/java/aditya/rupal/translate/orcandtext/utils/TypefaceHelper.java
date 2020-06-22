package aditya.rupal.translate.orcandtext.utils;

/**
 * @author Aidan Follestad (afollestad)
 */

import android.content.Context;
import android.graphics.Typeface;

import androidx.collection.SimpleArrayMap;

public final class TypefaceHelper {

    private static final SimpleArrayMap<String, Typeface> cache = new SimpleArrayMap<>();

    public static Typeface get(Context c, String name) {
        synchronized (cache) {
            if (!cache.containsKey(name)) {
                try {
                    Typeface t = Typeface.createFromAsset(c.getAssets(), name);
                    cache.put(name, t);
                    return t;
                } catch (RuntimeException e) {
                    return null;
                }
            }
            return cache.get(name);
        }
    }
}