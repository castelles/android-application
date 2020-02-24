package com.example.studyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class NewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
    }

    public void registerUser(View view) {
        EditText inputLogin = (EditText) findViewById(R.id.regUsername);
        EditText inputName = (EditText) findViewById(R.id.regName);
        EditText inputPass = (EditText) findViewById(R.id.regPass);
        RadioButton radioEst = (RadioButton) findViewById(R.id.estRadio);

        User user = new User(inputLogin.getText().toString(),
                inputName.getText().toString(),
                inputPass.getText().toString(),
                radioEst.isChecked() ? 1 : 2);

        UserDAO userDAO = new UserDAO(this);

        if ( userDAO.addUSer(user) ) {
            Toast.makeText(this, "Usuário Criado!", Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            Toast.makeText(this,"Erro ao cadastrar!", Toast.LENGTH_SHORT).show();
        }
    }
}
