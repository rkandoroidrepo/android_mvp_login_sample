package com.mvp.com.android_mvp_login_sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mvp.com.android_mvp_login_sample.modal.LoginDataManager;
import com.mvp.com.android_mvp_login_sample.modal.LoginRemoteDataSource;
import com.mvp.com.android_mvp_login_sample.modal.LoginResponse;
import com.mvp.com.android_mvp_login_sample.util.NetworkManager;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {

    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private Button mEmailSignInButton;
    private View parentLayout;

    // Presenter references.
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter = new LoginPresenter(this, LoginDataManager.getInstance(LoginRemoteDataSource.getInstance()));
        loginPresenter.start();
    }

    @Override
    public void showProgressBar(boolean active) {
        mProgressView.setVisibility(active ? View.VISIBLE : View.GONE);
    }

    @Override
    public void initializeUI() {
        // Set up the login form.
        mEmailView = findViewById(R.id.email);
        mPasswordView = findViewById(R.id.password);

        parentLayout = findViewById(R.id.root_view);
        mEmailSignInButton = findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.doLogin(new NetworkManager(LoginActivity.this), mEmailView.getText().toString(), mPasswordView.getText().toString());
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    @Override
    public void launchUserProfileActivity(LoginResponse userDetails) {
        Intent intent = new Intent(LoginActivity.this, UserProfileActivity.class);
        intent.putExtra("email", userDetails.getUserName());
        intent.putExtra("fullName", userDetails.getFullName());
        intent.putExtra("phone", userDetails.getPhoneNumber());
        intent.putExtra("address", userDetails.getUserAddress());
        startActivity(intent);

    }

    @Override
    public void showMessage(String type, String message) {
        if (!type.contains("toast")) {
            Snackbar.make(parentLayout, message, Snackbar.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showLoginFormView(boolean active) {
        mLoginFormView.setVisibility(active ? View.VISIBLE : View.GONE);
    }

    @Override
    public String getMsgString(int resourceId) {
        return getResources().getString(resourceId);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.loginPresenter = (LoginPresenter) presenter;
    }
}

