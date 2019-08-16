package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText username, password, confirmPassword, email;
    TextView login, textViewUsername, textViewEmail, textViewPassword, textViewConfirmPassword;
    Button btnRegister;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myDb = new DatabaseHelper(this);

        login = (TextView)findViewById(R.id.textView10);
        textViewUsername = (TextView)findViewById(R.id.textView1);
        textViewEmail = (TextView)findViewById(R.id.textView2);
        textViewPassword = (TextView)findViewById(R.id.textView3);
        textViewConfirmPassword = (TextView)findViewById(R.id.textView4);
        username = (EditText)findViewById(R.id.Username);
        password = (EditText)findViewById(R.id.Password);
        confirmPassword = (EditText)findViewById(R.id.ConfirmPassword);
        email = (EditText)findViewById(R.id.Email);
        btnRegister = (Button)findViewById(R.id.btnRegister);

        loginPage();
    }

    public void loginPage(){
        login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                }
        );
    }

    public void register(View view) {
        String Username = username.getText().toString();
        if (validate()) {
            if (!myDb.isUsernameExists(Username)) {
                boolean isInserted = myDb.insertData(new User(
                        null,
                        username.getText().toString(),
                        email.getText().toString(),
                        password.getText().toString()));

                if(isInserted = true){
                    Toast.makeText(getApplicationContext(),"Succesfuul Register",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this,HomeActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(Register.this,"Data Not Inserted", Toast.LENGTH_LONG).show();
            }
        }
    }

    public boolean validate () {
        boolean valid = true;

        String UserName = username.getText().toString();
        String Email = email.getText().toString();
        String Password = password.getText().toString();
        String ConfirmPassword = confirmPassword.getText().toString();

        if (UserName.isEmpty()) {
            textViewUsername.setText("*Please enter valid username!");
            valid = false;
        } else {
            textViewUsername.setText("");
        }

        if (Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            textViewEmail.setText("");
        } else {
            textViewEmail.setText("*Please enter valid email");
            valid = false;
        }

        if (Password.isEmpty()) {
            textViewPassword.setText("*Please enter password!");
            valid = false;
        } else {
            textViewPassword.setText("");
        }

        if (ConfirmPassword.isEmpty()) {
            textViewConfirmPassword.setText("*Please enter password!");
            valid = false;
        } else {
            textViewConfirmPassword.setText("");
        }

        if (!Password.equals(ConfirmPassword)) {
            textViewConfirmPassword.setText("*Password not same");
            valid = false;
        } else {
            textViewConfirmPassword.setText("");
        }
        return valid;
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }

}

