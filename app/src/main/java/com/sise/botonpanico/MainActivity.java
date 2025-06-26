package com.sise.botonpanico;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sise.botonpanico.activities.InicioActivity;
import com.sise.botonpanico.activities.PerfilCiudadanoActivity;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Ejecutado metodo onCreate()");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onClickPerfilCiudadano(View view){
        Intent intent = new Intent(this, PerfilCiudadanoActivity.class);
        startActivity(intent);
        //finish();
    }

    public void onClickInicio(View view){
        Intent intent = new Intent(this, InicioActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Ejecutado metodo onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Ejecutado metodo onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Ejecutado metodo onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Ejecutado metodo onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Ejecutado metodo onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Ejecutado metodo onDestroy()");
    }
}