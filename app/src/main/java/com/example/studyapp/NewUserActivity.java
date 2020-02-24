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
        EditText inputLogin = findViewById(R.id.regUsername);
        EditText inputName = findViewById(R.id.regName);
        EditText inputPass = findViewById(R.id.regPass);
        RadioButton radioEst = findViewById(R.id.estRadio);

        User user = new User(inputLogin.getText().toString(),
                inputName.getText().toString(),
                inputPass.getText().toString(),
                radioEst.isChecked() ? 1 : 2);

        UserDAO userDAO = new UserDAO(this);

        if ( userDAO.addUSer(user) ) {
            Toast.makeText(this, "Usuário Criado!", Toast.LENGTH_SHORT).show();
            this.finish();
        }
        else {
            Toast.makeText(this,"Erro ao cadastrar!", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkTypeEst(View view) {
        RadioButton admBtt = findViewById(R.id.admBtt);
        RadioButton estBtt = findViewById(R.id.radEst);

        estBtt.setChecked(true);
        admBtt.setChecked(false);
    }

    public void checkTypeAdm(View view) {
        RadioButton estBtt = findViewById(R.id.radEst);
        RadioButton admBtt = findViewById(R.id.admBtt);


        admBtt.setChecked(true);
        estBtt.setChecked(false);
    }
}
