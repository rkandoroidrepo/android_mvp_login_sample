package com.mvp.com.android_mvp_login_sample.modal;

import android.os.Handler;

import com.mvp.com.android_mvp_login_sample.util.LoadDataCallBack;
import com.mvp.com.android_mvp_login_sample.util.Network;

public class LoginRemoteDataSource implements DataSource {

    private static LoginRemoteDataSource INSTANCE;

    public LoginRemoteDataSource() {

    }

    public static LoginRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LoginRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void doLogin(Network network, final String userName, String password, final LoadDataCallBack<LoginResponse> callBack) {
        // Below code should be replaced with actual login service call using sany network library
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                LoginResponse loginResponse = new LoginResponse("Rk kushwaha",
                        userName,
                        "9803651243",
                        " 1600 Amphitheatre Pkwy, Mountain View, CA 94043, California, United States");
                callBack.onSuccess(loginResponse);
            }
        }, 3000);
    }
}
