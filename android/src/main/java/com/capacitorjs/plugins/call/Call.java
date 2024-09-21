package com.capacitorjs.plugins.call;

import android.content.Intent;
import android.net.Uri;

public class Call {

    public Intent call(String number) {
        String formattedNumber = number.replaceAll("#", "%23");
        if (!number.startsWith("tel:")) {
            formattedNumber = String.format("tel:%s", formattedNumber);
        }
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(formattedNumber));
            return intent;
        } catch (Exception e) {
            return null;
        }
    }
}
