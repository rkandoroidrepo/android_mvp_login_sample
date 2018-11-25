package com.mvp.com.android_mvp_login_sample.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkManager implements Network {
    private Context context;

    public NetworkManager(Context context) {
        this.context = context;
    }

    @Override
    public boolean isAvailable() {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            // Device is online
            return true;
        } else {
            // Device is not online
            return false;
        }
    }
}
