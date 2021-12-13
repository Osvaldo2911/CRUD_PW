package com.example.crud_tbd;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.*;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Registro extends AppCompatActivity implements View.OnTouchListener {
    TextView a;
     Button registro;
     EditText nombre, user, contra, confirmar;
     CheckBox terminos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        a=(TextView) findViewById(R.id.lbl_iniciaSesion);
        a.setOnTouchListener(this);

        registro = (Button) findViewById(R.id.btn_registrar);

        nombre = findViewById(R.id.et_NombreFullRegistro);
        user = findViewById(R.id.et_UserRegistro);
        contra = findViewById(R.id.et_ps_contraRegistrar);
        confirmar = findViewById(R.id.et_ps_contraConfirmarRegistrar);
        terminos = findViewById(R.id.terminosCondiciones);

        registro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int n = 0;
                if (!(nombre.getText().toString().trim().equals(""))){
                    n= n+1;
                }
                if (!(user.getText().toString().trim().equals(""))){
                    n= n+1;
                }
                if (!(contra.getText().toString().trim().equals(""))){
                    n= n+1;
                }
                if (!(confirmar.getText().toString().trim().equals(""))){
                    n= n+1;
                }
                if (n==4 && terminos.isChecked()){
                    //Inicio de la aplicacion
                    Toast.makeText(getApplicationContext(),
                            "Registro con exito",
                            Toast.LENGTH_LONG)
                            .show();
                    n=0;
                }else{
                    Toast.makeText(getApplicationContext(),
                            "Registro fallido",
                            Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            onBackPressed();
        }
        return false;
    }
}