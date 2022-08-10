package com.jonnathan.gallegos.usuarios;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jonnathan.gallegos.usuarios.Modelo.ModeloUsuario;

public class UserDetailsActivity extends AppCompatActivity {

    private TextView userid,userauthor,useren;
    private Button btnRegreso;
    ModeloUsuario userResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        asignaciónVariables();
        intentViewSalida();
        event();
    }

    private void asignaciónVariables(){
        userid = (TextView) findViewById(R.id.userid);
        userauthor = (TextView) findViewById(R.id.userauthor);
        useren = (TextView) findViewById(R.id.useren);
        btnRegreso = (Button) findViewById(R.id.btnRegreso);
    }

    private void intentViewSalida(){
        Intent intent = getIntent();
        if(intent.getExtras() !=null){
            userResponse = (ModeloUsuario) intent.getSerializableExtra("data");

            String usernamedata = userResponse.getId();
            String useremail = userResponse.getAuthor();
            String userjoined = userResponse.getEn();

            userid.setText("ID: \n"+usernamedata);
            userauthor.setText("AUTOR: \n"+useremail);
            useren.setText("DESCIPCIÓN: \n"+userjoined);
        }
    }
    private void event(){
        btnRegreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
