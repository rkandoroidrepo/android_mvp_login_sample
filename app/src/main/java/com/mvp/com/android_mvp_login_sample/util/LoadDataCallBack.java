package com.mvp.com.android_mvp_login_sample.util;

public interface LoadDataCallBack<T> {
    void onSuccess(T response);

    void onError(Object errorCode);
}
