package com.sise.botonpanico.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.sise.botonpanico.MainActivity;
import com.sise.botonpanico.R;
import com.sise.botonpanico.adapters.TipoDocumentoSpinnerAdapter;
import com.sise.botonpanico.dto.TipoDocumento;
import com.sise.botonpanico.entities.TipoIncidencia;
import com.sise.botonpanico.entities.Usuario;
import com.sise.botonpanico.shared.Data;
import com.sise.botonpanico.viewmodel.IncidenciaViewModel;
import com.sise.botonpanico.viewmodel.UsuarioViewModel;

public class PerfilCiudadanoActivity extends AppCompatActivity {

    private UsuarioViewModel usuarioViewModel;
    private final String TAG = PerfilCiudadanoActivity.class.getSimpleName();
    private Spinner spTipoDocumentos;
    private EditText etNumeroDocumento;
    private EditText etApellidoPaterno;
    private EditText etApellidoMaterno;
    private EditText etNombres;
    private EditText etCelular;
    private EditText etCorreo;
    private EditText etDireccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Ejecutado metodo onCreate()");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_perfil_ciudadano);

        usuarioViewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spTipoDocumentos = findViewById(R.id.activityperfilciudadano_spn_tipodocumento);
        etNumeroDocumento = findViewById(R.id.activityperfilciudadano_et_numerodocumento);
        etApellidoPaterno = findViewById(R.id.activityperfilciudadano_et_apellidopaterno);
        etApellidoMaterno = findViewById(R.id.activityperfilciudadano_et_apellidomaterno);
        etNombres = findViewById(R.id.activityperfilciudadano_et_nombres);
        etCelular = findViewById(R.id.activityperfilciudadano_et_celular);
        etCorreo = findViewById(R.id.activityperfilciudadano_et_correo);
        etDireccion = findViewById(R.id.activityperfilciudadano_et_dirrecion);

        TipoDocumentoSpinnerAdapter tipoDocumentoSpinnerAdapter = new TipoDocumentoSpinnerAdapter(PerfilCiudadanoActivity.this, Data.getTipoDocumentos());
        spTipoDocumentos.setAdapter(tipoDocumentoSpinnerAdapter);
    }

    public void onClickRegistrarse(View view){
        Usuario usuario = new Usuario();
        usuario.setTipoDocumento(((TipoDocumento)spTipoDocumentos.getSelectedItem()).getCodigo());
        usuario.setNumeroDocumento(etNumeroDocumento.getText().toString());
        usuario.setApellidoPaterno(etApellidoPaterno.getText().toString());
        usuario.setApellidoMaterno(etApellidoMaterno.getText().toString());
        usuario.setNombres(etNombres.getText().toString());
        usuario.setCelular(etCelular.getText().toString());
        usuario.setCorreo(etCorreo.getText().toString());
        usuario.setDireccion(etDireccion.getText().toString());
        usuarioViewModel.insertarUsuario(usuario);


    }

}