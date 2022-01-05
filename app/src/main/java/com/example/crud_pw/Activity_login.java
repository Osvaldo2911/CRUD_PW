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

import ConexionBD.Conexion;
import Modelo.UsuarioT;

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

    }

        public void inicio(View v){
            Intent i = new Intent(this,Activity_inicio.class);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Conexion conexion = Conexion.gettAppDatabase(getBaseContext());

        String userid = user.getText().toString().trim();
        String contra2 = contra.getText().toString().trim();
            if (!(userid.equals("")) && !(contra2.equals(""))){
               //UsuarioT busqueda = conexion.usuarioDAO().usuarioLogin(userid,contra2);
                if(true){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getBaseContext(), "Bienvenido", Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    }).start();
                    startActivity(i);
                }else{
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getBaseContext(), "Correo o contraseña erroneos", Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    }).start();
                }
            }else {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(), "Rellena todos los campos", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }).start();

            }

            } // end run Thread
        }).start();
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