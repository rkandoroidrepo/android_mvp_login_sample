package com.mvp.com.android_mvp_login_sample;

import com.mvp.com.android_mvp_login_sample.modal.LoginDataManager;
import com.mvp.com.android_mvp_login_sample.modal.LoginResponse;
import com.mvp.com.android_mvp_login_sample.util.LoadDataCallBack;
import com.mvp.com.android_mvp_login_sample.util.Network;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.LoginView view;
    private LoginDataManager loginDataManager;

    public LoginPresenter(LoginContract.LoginView loginView, LoginDataManager loginDataManager) {
        this.view = loginView;
        this.loginDataManager = loginDataManager;
    }

    @Override
    public void doLogin(Network network, String userName, String password) {
        if (validateEmail(userName)) {
            if (validatePassword(password)) {
                view.showProgressBar(true);
                view.showLoginFormView(false);
                loginDataManager.doLogin(network, userName, password, new LoadDataCallBack<LoginResponse>() {
                    @Override
                    public void onSuccess(LoginResponse response) {
                        view.showProgressBar(false);
                        view.showLoginFormView(true);
                        view.showMessage("toast", getMessage(AppConstants.LOGIN_SUCCESS));
                        view.launchUserProfileActivity(response);
                    }

                    @Override
                    public void onError(Object errorCode) {
                        view.showProgressBar(false);
                        view.showLoginFormView(true);
                        view.showMessage("snackBar", getMessage(errorCode));
                    }
                });
            } else {
                view.showMessage("snackBar", getMessage(AppConstants.INVALID_PASSWORD));
            }
        } else {
            view.showMessage("snackBar", getMessage(AppConstants.INVALID_EMAIL));

        }
    }

    @Override
    public boolean validateEmail(String email) {
        if (email != null && !email.isEmpty() && email.contains("@")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean validatePassword(String password) {
        if (password != null && !password.isEmpty() && password.length() >= 4) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getMessage(Object error) {
        String message;
        switch ((int) error) {
            case AppConstants.INVALID_EMAIL:
                message = view.getMsgString(R.string.error_invalid_email);
                break;
            case AppConstants.INVALID_PASSWORD:
                message = view.getMsgString(R.string.error_invalid_password);
                break;
            case AppConstants.LOGIN_SUCCESS:
                message = view.getMsgString(R.string.login_success);
                break;
            default:
                message = view.getMsgString(R.string.something_went_wrong);
                break;
        }
        return message;
    }

    @Override
    public void start() {
        view.initializeUI();
    }
}
