package com.fujiyama.pulp.developerprofiler.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

public class ImageHandler {
    private static final float BITMAP_SCALE = 0.4f;
    private static final float BLUR_RADIUS = 7.5f;

    public static Bitmap blur(Context context, Bitmap image) {
        int width = Math.round(image.getWidth() * BITMAP_SCALE);
        int height = Math.round(image.getHeight() * BITMAP_SCALE);

        Bitmap inputBitmap = Bitmap.createScaledBitmap(image, width, height, false);
        Bitmap outputBitmap = Bitmap.createBitmap(inputBitmap);

        RenderScript renderer = RenderScript.create(context);
        ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(renderer, Element.U8_4(renderer));

        Allocation tempIn = Allocation.createFromBitmap(renderer, inputBitmap);
        Allocation tempOut = Allocation.createFromBitmap(renderer, outputBitmap);

        blur.setRadius(BLUR_RADIUS);
        blur.setInput(tempIn);
        blur.forEach(tempOut);

        tempOut.copyTo(outputBitmap);

        return outputBitmap;
    }
}

