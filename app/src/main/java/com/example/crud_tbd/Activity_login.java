package com.example.crud_tbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_login extends AppCompatActivity implements View.OnTouchListener {
    TextView a;
    EditText user,contra;
    Button iniciarSesion;
    Button iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        a=(TextView) findViewById(R.id.lbl_creaCuenta);
        a.setOnTouchListener(this);

        //-------------------

        iniciarSesion = (Button) findViewById(R.id.btn_iniciar);

        user = findViewById(R.id.et_User);
        contra = findViewById(R.id.et_ps_contra);
        iniciar = findViewById(R.id.btn_iniciar);

        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int n = 0;
                if (!(user.getText().toString().trim().equals(""))){
                    n= n+1;
                }
                if (!(user.getText().toString().trim().equals(""))){
                    n= n+1;
                }
                if (n==2){
                    //Inicio de la aplicacion
                        Toast.makeText(getApplicationContext(),
                                "Inicio con exito",
                                Toast.LENGTH_LONG)
                                .show();
                        //-------------------------- habre nueva ventana
                            inicio(v);

                        //--------------------------


                        n=0;
                }else{
                    Toast.makeText(getApplicationContext(),
                            "Inicio fallido",
                            Toast.LENGTH_LONG)
                            .show();
                    n=0;
                }
            }
        });

        //-------------------

    }

        public void inicio(View v){
            Intent i = new Intent(this,Activity_inicio.class);
            startActivity(i);
        }


        @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            Intent i;
            i = new Intent(this, Activity_Registro.class);
            startActivity(i);
        }
        return false;
    }
}