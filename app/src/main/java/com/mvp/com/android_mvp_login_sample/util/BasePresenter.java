package com.mvp.com.android_mvp_login_sample.util;

public interface BasePresenter {
    void start();

    class AppConstants {

        public static final int INVALID_EMAIL = 11;
        public static final int INVALID_PASSWORD = 12;
        public static final int NETWORK_ERROR = 100;
        public static final int LOGIN_SUCCESS = 13;
        public static final int SIGN_UP_SUCCESS = 14;

    }
}
