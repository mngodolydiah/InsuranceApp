package mng.r.lydia.insuranceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void checkLogin(View view) {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    public void signUp(View view) {
        startActivity(new Intent(LoginActivity.this, SignUp.class));
    }
}
