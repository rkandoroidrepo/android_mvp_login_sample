package com.mvp.com.android_mvp_login_sample;

import com.mvp.com.android_mvp_login_sample.modal.LoginResponse;
import com.mvp.com.android_mvp_login_sample.util.BasePresenter;
import com.mvp.com.android_mvp_login_sample.util.BaseView;
import com.mvp.com.android_mvp_login_sample.util.Network;

public interface LoginContract {

    interface LoginView extends BaseView<Presenter> {

        /**
         * show/hide progress bar
         * @param active
         */
        void showProgressBar(boolean active);

        /**
         * initialize UI references
         */
        void initializeUI();

        /**
         * start UserProfileActivity
         * @param userDetails
         */
        void launchUserProfileActivity(LoginResponse userDetails);

        /**
         * show message
         * @param type (snack bar or toast)
         * @param message content
         */
        void showMessage(String type, String message);

        /**
         * show/hide login form
         * @param active
         */
        void showLoginFormView(boolean active);

        /**
         * get string from resource
         * @param resourceId
         * @return
         */
        String getMsgString(int resourceId);
    }

    interface Presenter extends BasePresenter {
        /**
         * do login after validating required field
         * @param network
         * @param userName
         * @param password
         */
        void doLogin(Network network, String userName, String password);

        /**
         * to validate email
         * @param email
         * @return
         */
        boolean validateEmail(String email);

        /**
         * to validate password
         * @param password
         * @return
         */
        boolean validatePassword(String password);

        /**
         * filter message
         * @param code
         * @return
         */
        String getMessage(Object code);
    }
}
