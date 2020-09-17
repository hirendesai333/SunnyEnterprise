package com.example.sunnyenterprise.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.model.loginModel.Item;
import com.example.sunnyenterprise.model.loginModel.Login;
import com.example.sunnyenterprise.retrofit.ApiCallInterface;
import com.example.sunnyenterprise.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    ApiCallInterface api;
    Item loginDetails;

    EditText etMob, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etMob = findViewById(R.id.etMobile);
        etPass = findViewById(R.id.etPassword);
        final Button button = findViewById(R.id.loginBtn);

        api = ApiService.createService(ApiCallInterface.class);

        Call<Login> call = api.getLoginDetails("9601258730", "1234");
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                loginDetails = response.body().getItem();

                final String responseMob = loginDetails.getMobile();
                final String responsePass = loginDetails.getPassword();

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String mobileNum = etMob.getText().toString();
                        final String password = etPass.getText().toString();

                        if (mobileNum.isEmpty() || password.isEmpty()){
                            Toast.makeText(LoginActivity.this, "fill the details!", Toast.LENGTH_SHORT).show();
                        }else {
                            if (responseMob.equals(mobileNum) && responsePass.equals(password)){
                                Toast.makeText(LoginActivity.this, "matched!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(LoginActivity.this, "didn't matched!", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                });

            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}