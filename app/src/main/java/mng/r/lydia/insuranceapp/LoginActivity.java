package mng.r.lydia.insuranceapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void checkLogin(View view) {

        email = (EditText) findViewById(R.id.loginEmail);
        password = (EditText) findViewById(R.id.loginPassword);

        if(validateInput(email, password)){
            if(loginCredentials(email, password)){
                ProgressDialog loginDialog;
                loginDialog = ProgressDialog.show(LoginActivity.this, "Login", "Trying To Log You In", true);
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                loginDialog.dismiss();
            }
        }
    }

    public void signUp(View view) {
        startActivity(new Intent(LoginActivity.this, SignUp.class));
    }

    private boolean loginCredentials(EditText username, EditText password){
//      TODO Write Email and Password Login Logic
        return true;
    }

    private boolean validateInput(EditText email, EditText password){
        if(email.getText().toString().isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
            email.setError("Invalid Email Address");
            return false;
        }else if(password.getText().toString().isEmpty()){
            password.setError(null);
            return false;
        }
        return true;
    }
}
