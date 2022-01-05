package com.example.crud_tbd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import ConexionBD.Conexion;
import Modelo.ClienteT;


public class Activity_agregar extends AppCompatActivity {

    EditText nom,ap,clNo,tel,rmx,entrada;
    String noms,aps,clNos,tels,rmxs;
    RadioButton rbf;
    RadioButton rbh;
    TextView btneditar,btnborrar,titulo;
    Boolean[] btn = {true,true};
    Button btn_agregarCliente,btn_EliminarCliente,btn_ModificarCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        nom=findViewById(R.id.et_nombreAgregar);
        ap=findViewById(R.id.et_apellidos);
        clNo=findViewById(R.id.et_clientNO);
        tel=findViewById(R.id.et_telefonoAgregar);
        rmx=findViewById(R.id.et_Renta_max);
        rbf = findViewById(R.id.rb_flat);
        rbh = findViewById(R.id.rb_house);
        titulo=findViewById(R.id.lbl_titulo);

        entrada = findViewById(R.id.et_clientNOBusqueda);

        btneditar = findViewById(R.id.lbl_EditarAE);
        btnborrar = findViewById(R.id.lbl_EliminarAE);
        btn_agregarCliente = findViewById(R.id.btn_AgregarCliente);
        btn_EliminarCliente = findViewById(R.id.btn_EliminarCliente);
        btn_ModificarCliente = findViewById(R.id.btn_ModificarCliente);

        TextView regresar = (TextView) findViewById(R.id.lbl_RegresarAgregar);

        entrada.setEnabled(false);
        btn_EliminarCliente.setEnabled(false);
        btn_ModificarCliente.setEnabled(false);

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void buscar(View v) {
        String idCli = entrada.getText().toString(); //CR100

        new Thread(new Runnable() {
            @Override
            public void run() {
                Conexion conexion = Conexion.gettAppDatabase(getBaseContext());

                if(idCli.equals("")){

                }else {
                    ClienteT busqueda = conexion.clienteDAO().clModificar(idCli);

                    if (busqueda == null) {

                    } else {

                        nom.setText(busqueda.getfName());
                        ap.setText(busqueda.getlName());
                        tel.setText(busqueda.getTelNo());
                        rmx.setText(busqueda.getMaxRent());
                        clNo.setText(busqueda.getClientNo());
                        if (busqueda.getPrefType().toLowerCase().equals("flat")) {
                            rbf.setChecked(true);
                        } else {
                            rbh.setChecked(true);
                        }
/*
                        nom.setEnabled(false);
                        ap.setEnabled(false);
                        tel.setEnabled(false);
                        rmx.setEnabled(false);
                        clNo.setEnabled(false);
                        rbf.setEnabled(false);
                        rbh.setEnabled(false);
                        btn_agregarCliente.setEnabled(false);
*/
                    }
                }

            }
        }).start();

    }

    public void registroBtn(View v){
        new Thread(new Runnable() {
            @Override
            public void run() {
                //--------------------
                Conexion conexion = Conexion.gettAppDatabase(getBaseContext());

                noms = nom.getText().toString();
                aps = ap.getText().toString();
                clNos = clNo.getText().toString();
                tels = tel.getText().toString();
                rmxs = rmx.getText().toString();

                if (!nom.equals("")) {
                    if (!aps.equals("")) {

                        if (!clNos.equals("")) {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    conexion.clienteDAO().clModificar(clNos);
                                }
                            });
                            if (!(tels.equals(""))) {
                                if (!(rmxs.equals(""))) {
                                    //--------------------------------------------------
                                    if (rbf.isChecked()){
                                        conexion.clienteDAO().insertarCliente(new ClienteT(clNos, noms, aps, tels, "flat", rmxs));
                                        new Thread(new Runnable() {
                                            @Override
                                            public void run() {
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Toast.makeText(getBaseContext(), "Se agrego con exito", Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                            }
                                        }).start();
                                    }else{
                                        conexion.clienteDAO().insertarCliente(new ClienteT(clNos, noms, aps, tels, "house", rmxs));
                                        new Thread(new Runnable() {
                                            @Override
                                            public void run() {
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Toast.makeText(getBaseContext(), "Se agrego con exito", Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                            }
                                        }).start();
                                    }

                                    nom.setText("");
                                    ap.setText("");
                                    tel.setText("");
                                    clNo.setText("");
                                    rbf.setChecked(false);
                                    rbh.setChecked(false);
                                    rmx.setText("");
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

                                //--------------------------------------------------
                            }else {
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
                    }else {
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
                //----------------------
            }
        }).start();
    }

    public void modificar (View v){
        if (btn[0] == true){
            btneditar.setBackgroundResource(R.drawable.lnegro);
            titulo.setText("Modificar Empleado");
            entrada.setEnabled(true);
            nom.setEnabled(true);
            ap.setEnabled(true);
            tel.setEnabled(true);
            rmx.setEnabled(true);
            rbf.setEnabled(true);
            rbh.setEnabled(true);
            clNo.setEnabled(false);
            btn_agregarCliente.setEnabled(false);
            btn_EliminarCliente.setEnabled(false);
            btn_ModificarCliente.setEnabled(true);
            btn[0] = false;
        }else if(btn[0] ==false){
            btneditar.setBackgroundResource(R.drawable.lblanco);
            titulo.setText("Agregar Empleado");
            clNo.setText("");
            nom.setText("");
            ap.setText("");
            tel.setText("");
            rmx.setText("");
            clNo.setEnabled(true);
            btn_agregarCliente.setEnabled(true);
            entrada.setText("");
            entrada.setEnabled(false);
            btn_EliminarCliente.setEnabled(false);
            btn_ModificarCliente.setEnabled(false);
            btn[0] = true;
        }
    }

    public void eliminarCliente(View v){

        new Thread(new Runnable() {
            @Override
            public void run() {

                Conexion conexion = Conexion.gettAppDatabase(getBaseContext());
                if(!(clNo.getText().toString().equals(""))){
                    conexion.clienteDAO().eliminarC(clNo.getText().toString());
                    nom.setText("");
                    ap.setText("");
                    tel.setText("");
                    clNo.setText("");
                    rbf.setChecked(false);
                    rbh.setChecked(false);
                    rmx.setText("");
                }

            }
        }).start();


    }

    public void ModificarCliente(View v){

        Conexion conexion = Conexion.gettAppDatabase(getBaseContext());

        new Thread(new Runnable() {
            @Override
            public void run() {

                if (!noms.equals("")) {
                    if (!aps.equals("")) {
                        if (!clNos.equals("")) {
                            if (!(tels.equals(""))) {
                                if (!(rmxs.equals(""))) {
                                    if(!(clNo.getText().toString().equals(""))){
                                        String fla;
                                        if (rbf.isChecked()==true){
                                            fla=rbf.getText().toString().toLowerCase();
                                        }else{
                                            fla=rbh.getText().toString().toLowerCase();
                                        }
                                        conexion.clienteDAO().modificarC(
                                                clNo.getText().toString(),
                                                nom.getText().toString(),
                                                ap.getText().toString(),
                                                tel.getText().toString(),
                                                fla+"",
                                                rmx.getText().toString());

                                        nom.setText("");
                                        ap.setText("");
                                        tel.setText("");
                                        clNo.setText("");
                                        rbf.setChecked(false);
                                        rbh.setChecked(false);
                                        rmx.setText("");

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
                                }
                            }
                        }
                    }
                }
            }
        }).start();


    }

    public void borrar (View v){
        if (btn[1] == true){
            btnborrar.setBackgroundResource(R.drawable.bnegro);
            titulo.setText("Eliminar Empleado");
            entrada.setEnabled(true);
            nom.setEnabled(true);
            ap.setEnabled(true);
            tel.setEnabled(true);
            rmx.setEnabled(true);
            rbf.setEnabled(true);
            rbh.setEnabled(true);
            clNo.setEnabled(false);
            btn_agregarCliente.setEnabled(false);
            btn_EliminarCliente.setEnabled(true);
            btn_ModificarCliente.setEnabled(false);
            btn[1] = false;
        }else if(btn[1] ==false){
            btnborrar.setBackgroundResource(R.drawable.bblanco);
            titulo.setText("Agregar Empleado");
            clNo.setText("");
            nom.setText("");
            ap.setText("");
            tel.setText("");
            rmx.setText("");
            clNo.setEnabled(true);
            entrada.setText("");
            entrada.setEnabled(false);
            btn_agregarCliente.setEnabled(true);
            btn_EliminarCliente.setEnabled(false);
            btn_ModificarCliente.setEnabled(false);
            btn[1] = true;
        }
    }
}