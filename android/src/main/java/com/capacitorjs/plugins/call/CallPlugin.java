package com.capacitorjs.plugins.call;

import android.content.Intent;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "Call")
public class CallPlugin extends Plugin {

    private final Call implementation = new Call();

    @PluginMethod
    public void call(PluginCall call) {
        String number = call.getString("number");

        if (number == null || number.isEmpty()) {
            call.reject("error-missing-number");
            return;
        }

        try {
            Intent intent = implementation.call(number);
            if (intent == null) {
                call.reject("error-call-failed");
            } else {
                this.getContext().startActivity(intent);
            }
        } catch (Exception e) {
            call.reject(e.getMessage());
        }
    }
}
