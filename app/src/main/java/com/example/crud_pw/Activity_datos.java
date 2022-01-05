package com.example.crud_tbd;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import ConexionBD.AdaptadorRegistros;
import ConexionBD.Conexion;
import Modelo.ClienteT;

public class Activity_datos extends AppCompatActivity {
    TextView reDatos;
    boolean[] activo = {true,true,true,true,true,true,true}; //En Conjunto con el metodo cambioBoton
    String[] datos = new String[6]; //En Conjunto con el metodo cambioBoton
    TextView nom,ap,clNo,tel,rmx,prtyp,filtro;
    String noms,aps,clNos,tels,rmxs,prtyps;
    EditText busquedaFiltro;
    boolean[] btn = new boolean[2];
    TextView btnBuscar;

    RecyclerView recicler;
    RecyclerView.Adapter adaper;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        recicler=findViewById(R.id.rv_datosTabla);



        //---boton de regresar al inicio
        reDatos = findViewById(R.id.lbl_Regresar);
        regresar(reDatos);
        //--->

        //--- Cambio del estilo de boton al precionarlo
        nom=findViewById(R.id.lbl_f_nom);
        ap=findViewById(R.id.lbl_f_ap);
        clNo=findViewById(R.id.lbl_f_sdni);
        tel=findViewById(R.id.lbl_f_fn);
        rmx=findViewById(R.id.lbl_f_am);
        prtyp=findViewById(R.id.lbl_f_dir);
        busquedaFiltro=findViewById(R.id.ed_busqueda_filtro);
        filtro=findViewById(R.id.lbl_filtros);


        cambioBoton(nom,0,busquedaFiltro);
        cambioBoton(ap,1,busquedaFiltro);
        cambioBoton(clNo,2,busquedaFiltro);
        cambioBoton(tel,3,busquedaFiltro);
        cambioBoton(rmx,4,busquedaFiltro);
        cambioBoton(prtyp,5,busquedaFiltro);


        ConstraintLayout cl = findViewById(R.id.cl_f_opciones); //chico
        TextView ic = findViewById(R.id.lbl_f_icono);
        ConstraintLayout cl2 = findViewById(R.id.cl_datos);

        ic.setRotation(0);
        cl2.setTranslationY(20);
        cl.setVisibility(View.INVISIBLE);

        // Mostrar seccion de filtros
        filtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activo[6] == false){
                    cl.setVisibility(View.INVISIBLE);
                    cl2.setTranslationY(20);
                    ic.setRotation(0);
                    activo[6] = true;
                }else if(activo[6]==true){
                    cl2.setTranslationY(400);
                    cl.setVisibility(View.VISIBLE);
                    activo[6] = false;
                    ic.setRotation(90);
                }
            }
        });
        //--->

        btnBuscar=findViewById(R.id.lbl_buscarBTN);

    } // fin constructor


    public void cambioBoton(TextView boton,int index,EditText entradaSalida){

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activo[index] == true){
                    boton.setBackgroundResource(R.drawable.filtroa);
                    boton.setTextColor(Color.WHITE);
                    String cbS = entradaSalida.getText().toString().trim();
                    datos[index] = cbS;
                    entradaSalida.setText("");
                    activo[index] = false;
                }else if(activo[index]==false){
                    boton.setBackgroundResource(R.drawable.filtrob);
                    boton.setTextColor(Color.BLACK);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    String[] b = new String[0];
                                    adaper = new AdaptadorRegistros(b);
                                    recicler.setAdapter(adaper);
                                }
                            });
                        }
                    }).start();
                    //entradaSalida.setText(datos[index]);
                    activo[index] = true;
                }
            }
        });
    }

    public void regresar(TextView re){
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void agregarEmpleado(View v) {
        Intent i = new Intent(this, Activity_agregar.class);
        startActivity(i);
    }

    public void conaulta(View v){
        recicler.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recicler.setLayoutManager(layoutManager);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Conexion conexion = Conexion.gettAppDatabase(getBaseContext());

                List<ClienteT> clientes = conexion.clienteDAO().obtenerPersonalizado("%"+datos[2]+"%","%"+ datos[0] +"%","%"+datos[1]+"%","%"+datos[3]+"%","%"+datos[5]+"%","%"+datos[4]+"%");

                String[] a;

                if (clientes.size()>0) {
                    a = new String[clientes.size()];
                    int Cont=0;
                    for (ClienteT c:clientes) {
                        a[Cont]=c.toString();
                        Cont++;
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adaper = new AdaptadorRegistros(a);
                            recicler.setAdapter(adaper);
                        }
                    });

                }else{
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String[] b = new String[0];
                            adaper = new AdaptadorRegistros(b);
                            recicler.setAdapter(adaper);
                        }
                    });
                }






            }
        }).start();
    }

}