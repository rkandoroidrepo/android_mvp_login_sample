package com.mvp.com.android_mvp_login_sample.modal;

import com.mvp.com.android_mvp_login_sample.util.BasePresenter;
import com.mvp.com.android_mvp_login_sample.util.LoadDataCallBack;
import com.mvp.com.android_mvp_login_sample.util.Network;

public class LoginDataManager implements DataSource {

    private static LoginDataManager ourInstance;
    private LoginRemoteDataSource remoteDataSource;

    private LoginDataManager(LoginRemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public static LoginDataManager getInstance(LoginRemoteDataSource remoteDataSource) {
        if (ourInstance == null) {
            ourInstance = new LoginDataManager(remoteDataSource);
        }
        return ourInstance;
    }

    @Override
    public void doLogin(Network network, String userName, String password, final LoadDataCallBack<LoginResponse> callBack) {
        if (network.isAvailable()) {
            remoteDataSource.doLogin(network, userName, password, new LoadDataCallBack<LoginResponse>() {
                @Override
                public void onSuccess(LoginResponse response) {
                    callBack.onSuccess(response);
                }

                @Override
                public void onError(Object errorCode) {
                    callBack.onError(errorCode);
                }
            });
        } else {
            callBack.onError(BasePresenter.AppConstants.NETWORK_ERROR);
        }
    }
}
