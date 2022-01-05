package com.example.crud_tbd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.*;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ConexionBD.Conexion;
import Modelo.UsuarioT;

public class Activity_Registro extends AppCompatActivity implements View.OnTouchListener {
    TextView a,resultados;
     Button registro;
     EditText nombre, user, contra, confirmar;
     CheckBox terminos;
    String nom,email,cn,cnc;
    Conexion conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        a=findViewById(R.id.lbl_iniciaSesion);
        a.setOnTouchListener(this);

        registro = findViewById(R.id.btn_registrar);

        nombre = findViewById(R.id.et_NombreFullRegistro);
        user = findViewById(R.id.et_UserRegistro);
        contra = findViewById(R.id.et_ps_contraRegistrar);
        confirmar = findViewById(R.id.et_ps_contraConfirmarRegistrar);
        terminos = findViewById(R.id.terminosCondiciones);

        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (user.getText().toString().length() > 0) {
                    int punto = 0;
                    int arro = 0;

                    for (int i = 0; i < user.getText().toString().length(); i++) {
                        String ema = user.getText().toString();
                        int a = ema.charAt(i);
                        if (a == 46) {
                            punto = punto + 1;
                        }
                        if (a == 64) {
                            arro = arro + 1;
                        }
                    }

                    if (punto > 0 && arro > 0){
                        email = user.getText().toString();
                    }


                }
            }
        });


        contra.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });


    }

    public void registroBtn(View v){
        new Thread(new Runnable() {
            @Override
            public void run() {

                /// inicio hilo

        conexion = Conexion.gettAppDatabase(getBaseContext());

                nom = nombre.getText().toString();
                email = user.getText().toString();
                cn = contra.getText().toString().trim();
                cnc = confirmar.getText().toString();

        if (!nom.equals("")){

            if (!email.equals("")) {

                if (!cn.equals("")){

                    if (!(cnc.equals(""))){

                        if (terminos.isChecked()){
                            UsuarioT busqueda;
                            boolean aceptar = false;
                            String ce = "";
                            String con ="";
                            ce = emailValidar(user);
                            con = contraseñaValidar(contra);
                            if(!(ce.equals("") && !(con.equals("")))){
                                if (con.equals(cnc)){
                                    aceptar=true;
                                }else{
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText(getBaseContext(), "Confirmar contraseña tiene errores", Toast.LENGTH_LONG).show();
                                                }
                                            });
                                        }
                                    }).start();
                                }
                            }
                            if (aceptar==true){
                                busqueda = conexion.usuarioDAO().usuarioDisponible(email);
                                if (busqueda == null) {
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText(getBaseContext(), "Registro con exito", Toast.LENGTH_LONG).show();
                                                }
                                            });
                                        }
                                    }).start();

                                    conexion.usuarioDAO().insertarUsuario(new UsuarioT(nom,email,cn));
                                    nombre.setText("");
                                    user.setText("");
                                    contra.setText("");
                                    confirmar.setText("");
                                    nom ="";
                                    cn="";
                                    cnc="";
                                    terminos.setChecked(false);

                                }else{
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText(getBaseContext(), "Email en uso", Toast.LENGTH_LONG).show();
                                                }
                                            });
                                        }
                                    }).start();
                                }
                            }

                            //--------------------------------------------------
                        }else{
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(getBaseContext(), "Rellena los campos", Toast.LENGTH_LONG).show();
                                        }
                                    });
                                }
                            }).start();
                        }
                    }else{
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getBaseContext(), "Rellena los campos", Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        }).start();
                    }
                }else{
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getBaseContext(), "Rellena los campos", Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    }).start();
                }
            } else{
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(), "Rellena los campos", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }).start();
            }
        }else{

            new Thread(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getBaseContext(), "Rellena los campos", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }).start();

        }
        // fin hilo

            }
        }).start();

    }
    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            onBackPressed();
        }
        return false;
    }

    public String contraseñaValidar(EditText c) {

        if (c.getText().length() >= 8) {
            int n = 0;
            int ma = 0;
            int mi = 0;
            int sim = 0;
            for (int i = 0; i < c.getText().length(); i++) {
                String cont = c.getText().toString();
                int a = cont.charAt(i);
                if (a >= 48 && a <= 57) {
                    n = n + 1;
                }
                if (a >= 65 && a <= 90) {
                    ma = ma + 1;
                }
                if (a >= 97 && a <= 122) {
                    mi = mi + 1;
                }
                if (a >= 33 && a <= 47 || a >= 91 && a <= 96 || a >= 123 && a <= 126) {
                    sim = sim + 1;
                }
            }

            if (n > 0 && ma > 0 && mi > 0 && sim > 0) {
                return c.getText().toString();
            }
        }
        return "error";
    }

    public String emailValidar(EditText es){
        String e = es.getText().toString();
        String res;
        int cont = 0, cont2 = 0;
        for (int i = 0; i < e.length(); i++) {
            char s = e.charAt(i);
            if (s == '@') {
                cont = cont + 1;
            } else if (s == '.') {
                cont2 = cont2 + 1;
            } else {

            }
            if (cont >= 1 && cont2 >= 1) {
                return e;
            }
        }
        return "error";
    }

}