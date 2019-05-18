package com.android.gumeoficial.fragmentsapp;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements FragmentRojo.OnFragmentInteractionListener,
        FragmentVerde.OnFragmentInteractionListener,
        FragmentAzul.OnFragmentInteractionListener{

    FragmentAzul fragmentAzul;
    FragmentRojo fragmentRojo;
    FragmentVerde fragmentVerde;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Si trabajamos con api menor de 23 debemos implementar lo siguiente

        fragmentAzul =new FragmentAzul();
        fragmentRojo = new FragmentRojo();
        fragmentVerde = new FragmentVerde();

        //Declaracion para que apareca primero sin pushar boton
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragment,fragmentRojo).commit();


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onClick(View view){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()){
            case R.id.btn1:
                     transaction.replace(R.id.contenedorFragment,fragmentRojo);
                break;
            case R.id.btn2:
                     transaction.replace(R.id.contenedorFragment,fragmentAzul);
                 break;
            case R.id.btn3:
                        transaction.replace(R.id.contenedorFragment,fragmentVerde);
                  break;
        }

        transaction.commit();


    }
}
