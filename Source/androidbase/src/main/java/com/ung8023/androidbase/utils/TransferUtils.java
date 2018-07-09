package com.ung8023.androidbase.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class TransferUtils {
    private TransferUtils() {

    }

    public static void toBrowser(Context context, String url) {
        try{
            Intent intent = browserIntent(url);
            openOuterActivity(context, intent);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Intent browserIntent(String uri) {
        return new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
    }

    private static void openOuterActivity(Context context, Intent intent) {
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

}
