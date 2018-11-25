package com.mvp.com.android_mvp_login_sample.modal;

import com.mvp.com.android_mvp_login_sample.util.LoadDataCallBack;
import com.mvp.com.android_mvp_login_sample.util.Network;

public interface DataSource {
    /**
     * call the login service
     * @param network
     * @param userName
     * @param password
     * @param callBack
     */
    void doLogin(Network network, String userName, String password, LoadDataCallBack<LoginResponse> callBack);

}
