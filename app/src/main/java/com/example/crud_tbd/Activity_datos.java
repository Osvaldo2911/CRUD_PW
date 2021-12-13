package com.example.crud_tbd;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_datos extends AppCompatActivity implements View.OnTouchListener {
    TextView nom,ap,am,fn,dir,suel,sdni,dni,dno,sex;
    boolean activo[] = {true,true,true,true,true,true,true,true,true,true,true};
    Button agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        TextView filOcultar = (TextView) findViewById(R.id.lbl_filtros);
        ConstraintLayout contenedor = (ConstraintLayout) findViewById(R.id.cl_f_opciones);
        ConstraintLayout contenedor2 = (ConstraintLayout) findViewById(R.id.cl_datos);
        TextView ic = (TextView) findViewById(R.id.lbl_f_icono);
        ic.setRotation(0);
        contenedor2.setTranslationY(20);
        contenedor.setVisibility(View.GONE);

        nom = findViewById(R.id.lbl_f_nom);
        ap = findViewById(R.id.lbl_f_ap);
        am = findViewById(R.id.lbl_f_am);
        fn = findViewById(R.id.lbl_f_fn);
        dir = findViewById(R.id.lbl_f_dir);
        suel = findViewById(R.id.lbl_f_suel);
        sdni = findViewById(R.id.lbl_f_sdni);
        dni = findViewById(R.id.lbl_f_dni);
        dno = findViewById(R.id.lbl_f_dno);
        sex = findViewById(R.id.lbl_f_sex);

        nom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activo[0] == true){
                    nom.setBackgroundResource(R.drawable.filtroa);
                    nom.setTextColor(Color.WHITE);
                    activo[0] = false;
                }else if(activo[0]==false){
                    nom.setBackgroundResource(R.drawable.filtrob);
                    nom.setTextColor(Color.BLACK);
                    activo[0] = true;
                }
            }
        });
        //---
        ap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activo[1] == true){
                    ap.setBackgroundResource(R.drawable.filtroa);
                    ap.setTextColor(Color.WHITE);
                    activo[1] = false;
                }else if(activo[1]==false){
                    ap.setBackgroundResource(R.drawable.filtrob);
                    ap.setTextColor(Color.BLACK);
                    activo[1] = true;
                }
            }
        });
        //---
        am.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activo[2] == true){
                    am.setBackgroundResource(R.drawable.filtroa);
                    am.setTextColor(Color.WHITE);
                    activo[2] = false;
                }else if(activo[2]==false){
                    am.setBackgroundResource(R.drawable.filtrob);
                    am.setTextColor(Color.BLACK);
                    activo[2] = true;
                }
            }
        });
        //---
        fn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activo[3] == true){
                    fn.setBackgroundResource(R.drawable.filtroa);
                    fn.setTextColor(Color.WHITE);
                    activo[3] = false;
                }else if(activo[3]==false){
                    fn.setBackgroundResource(R.drawable.filtrob);
                    fn.setTextColor(Color.BLACK);
                    activo[3] = true;
                }
            }
        });
        //---
        dir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activo[4] == true){
                    dir.setBackgroundResource(R.drawable.filtroa);
                    dir.setTextColor(Color.WHITE);
                    activo[4] = false;
                }else if(activo[4]==false){
                    dir.setBackgroundResource(R.drawable.filtrob);
                    dir.setTextColor(Color.BLACK);
                    activo[4] = true;
                }
            }
        });
        //---
        suel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activo[5] == true){
                    suel.setBackgroundResource(R.drawable.filtroa);
                    suel.setTextColor(Color.WHITE);
                    activo[5] = false;
                }else if(activo[5]==false){
                    suel.setBackgroundResource(R.drawable.filtrob);
                    suel.setTextColor(Color.BLACK);
                    activo[5] = true;
                }
            }
        });
        //---
        sdni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activo[6] == true){
                    sdni.setBackgroundResource(R.drawable.filtroa);
                    sdni.setTextColor(Color.WHITE);
                    activo[6] = false;
                }else if(activo[6]==false){
                    sdni.setBackgroundResource(R.drawable.filtrob);
                    sdni.setTextColor(Color.BLACK);
                    activo[6] = true;
                }
            }
        });
        //---
        dni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activo[7] == true){
                    dni.setBackgroundResource(R.drawable.filtroa);
                    dni.setTextColor(Color.WHITE);
                    activo[7] = false;
                }else if(activo[7]==false){
                    dni.setBackgroundResource(R.drawable.filtrob);
                    dni.setTextColor(Color.BLACK);
                    activo[7] = true;
                }
            }
        });
        //---
        dno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activo[8] == true){
                    dno.setBackgroundResource(R.drawable.filtroa);
                    dno.setTextColor(Color.WHITE);
                    activo[8] = false;
                }else if(activo[8]==false){
                    dno.setBackgroundResource(R.drawable.filtrob);
                    dno.setTextColor(Color.BLACK);
                    activo[8] = true;
                }
            }
        });
        //----
        sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activo[9] == true){
                    sex.setBackgroundResource(R.drawable.filtroa);
                    sex.setTextColor(Color.WHITE);
                    activo[9] = false;
                }else if(activo[9]==false){
                    sex.setBackgroundResource(R.drawable.filtrob);
                    sex.setTextColor(Color.BLACK);
                    activo[9] = true;
                }
            }
        });
//------------FILTRO OCULTAR -START

        filOcultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activo[10] == false){
                    contenedor.setVisibility(View.INVISIBLE);
                    //contenedor.setTranslationX(1200);
                    contenedor2.setTranslationY(20);
                    ic.setRotation(0);

                    activo[10] = true;
                }else if(activo[10]==true){
                    //contenedor.setTranslationX(0);
                    contenedor2.setTranslationY(400);
                   contenedor.setVisibility(View.VISIBLE);
                    activo[10] = false;
                    ic.setRotation(90);
                }
            }
        });
//------------FILTRO OCULTAR -- END
        //----regresa de pantalla
        TextView regresar = (TextView) findViewById(R.id.lbl_Regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
    public void agregarEmpleado(View v){
        Intent i = new Intent(this,Activity_agregar.class);
        startActivity(i);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
    return false;
    }
}