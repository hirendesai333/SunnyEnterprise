package com.example.sunnyenterprise.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.model.loginModel.Login;
import com.example.sunnyenterprise.retrofit.ApiCallInterface;
import com.example.sunnyenterprise.retrofit.ApiService;
import com.example.sunnyenterprise.utils.Preferences;
import com.goodiebag.pinview.Pinview;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    ApiCallInterface api;
    Login loginDetails;

    EditText etMob;
    Dialog myDialog;

    ProgressDialog progressDialog;

    Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etMob = findViewById(R.id.etMobile);
        final Button button = findViewById(R.id.loginBtn);

        progressDialog = new ProgressDialog(LoginActivity.this);

        api = ApiService.createService(ApiCallInterface.class);

        preferences = new Preferences(LoginActivity.this);

        button.setOnClickListener(view -> {
            final String mobileNum = etMob.getText().toString();

            if (mobileNum.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Fill the details", Toast.LENGTH_SHORT).show();
            } else {
                progressDialog.setMessage("Loading...");
                progressDialog.show();

                Call<Login> call = api.getLoginDetails(mobileNum);
                call.enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(@NotNull Call<Login> call, @NotNull Response<Login> response) {
                        loginDetails = response.body();

                        myDialog = new Dialog(getApplicationContext());

                        final String responseMob = loginDetails.getItem().getMobile();
                        if (responseMob.equals(mobileNum)) {

                            preferences.setMobile(mobileNum);
                            preferences.setId(loginDetails.getItem().getId());

                            Log.d("ids", "customer id: " + loginDetails.getItem().getId());

                            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                            ViewGroup viewGroup = findViewById(android.R.id.content);
                            View dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.custom_otp_dialog, viewGroup, false);
                            builder.setView(dialogView);
                            AlertDialog alertDialog = builder.create();

                            Button verifyBtn = dialogView.findViewById(R.id.btnVerify);
                            Pinview pinview = dialogView.findViewById(R.id.pinview);

                            verifyBtn.setOnClickListener(view -> {
                                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                                inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);

                                String otp = String.valueOf(loginDetails.getItem().getOtp());

                                if (pinview.getValue().equals(otp)) {
                                    progressDialog.cancel();
                                    onBackPressed();
                                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                    startActivity(intent);
                                } else {
                                    progressDialog.cancel();
                                    Toast.makeText(LoginActivity.this, "otp is not valid!", Toast.LENGTH_SHORT).show();
                                }

                            });

                            /*TextView textViewResend = dialogView.findViewById(R.id.tvResend);
                            textViewResend.setOnClickListener(view -> {
                                Toast.makeText(getApplicationContext(), "code sent again!", Toast.LENGTH_SHORT).show();

                            });*/

                            alertDialog.show();

                        } else {
                            progressDialog.cancel();
                            Toast.makeText(LoginActivity.this, "didn't matched!", Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onFailure(@NotNull Call<Login> call, @NotNull Throwable t) {
                        Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }

}