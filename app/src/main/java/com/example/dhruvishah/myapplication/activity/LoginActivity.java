package com.example.dhruvishah.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dhruvishah.myapplication.R;
import com.example.dhruvishah.myapplication.database.DataBaseHandler;
import com.example.dhruvishah.myapplication.utils.PreferenceUtils;

public class LoginActivity extends AppCompatActivity {
    Button login;
    EditText email, password;
    DataBaseHandler db = new DataBaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.login_button);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        if (PreferenceUtils.isRegistered(this)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        email.setText(PreferenceUtils.getEmail(this));
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isValidEmail(email.getText().toString())) {
                    email.setError("Enter valid email");
                }

                if (password.getText().toString().length() == 0) {
                    password.setError("Password required");
                }
                if (isValidEmail(email.getText().toString()) && (password.getText().toString().length() != 0)) {
                    db.addData();
                    Intent launchactivity = new Intent(LoginActivity.this, MainActivity.class);
                    PreferenceUtils.setIsRegistered(LoginActivity.this, true);
                    PreferenceUtils.setEmail(LoginActivity.this, email.getText().toString());
                    startActivity(launchactivity);
                    finish();
                }
            }

        });
    }

    public static boolean isValidEmail(CharSequence email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
