package com.sise.botonpanico.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.sise.botonpanico.R;
import com.sise.botonpanico.adapters.TipoDocumentoSpinnerAdapter;
import com.sise.botonpanico.dto.TipoDocumento;
import com.sise.botonpanico.entities.Usuario;
import com.sise.botonpanico.shared.Data;
import com.sise.botonpanico.shared.Message;
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

        observeUsuarioViewModel();

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


    private void observeUsuarioViewModel(){
        usuarioViewModel.getinsertarUsuarioLiveData().observe(PerfilCiudadanoActivity.this, liveDataResponse -> {
            if(!liveDataResponse.isSuccess() || liveDataResponse.getData() == null ) {
                Toast.makeText(PerfilCiudadanoActivity.this, Message.INTENTAR_MAS_TARDE,Toast.LENGTH_LONG).show();
                return;
            }
            Toast.makeText(getApplicationContext(),"¡Se ha enviado correctamente!", Toast.LENGTH_LONG).show();
        });
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


        // Validaciones
        if (spTipoDocumentos.getSelectedItem() == null) {
            Toast.makeText(this, "Seleccione un tipo de documento", Toast.LENGTH_SHORT).show();
            return;
        }

        String numeroDocumento = etNumeroDocumento.getText().toString().trim();
        if (numeroDocumento.isEmpty() || numeroDocumento.length() < 8) {
            etNumeroDocumento.setError("Ingrese un número de documento válido (mínimo 8 caracteres)");
            return;
        }

        String apellidoPaterno = etApellidoPaterno.getText().toString().trim();
        if (apellidoPaterno.isEmpty()) {
            etApellidoPaterno.setError("Ingrese el apellido paterno");
            return;
        }

        String apellidoMaterno = etApellidoMaterno.getText().toString().trim();
        if (apellidoMaterno.isEmpty()) {
            etApellidoMaterno.setError("Ingrese el apellido materno");
            return;
        }

        String nombres = etNombres.getText().toString().trim();
        if (nombres.isEmpty()) {
            etNombres.setError("Ingrese los nombres");
            return;
        }

        String celular = etCelular.getText().toString().trim();
        if (celular.isEmpty() || celular.length() != 9 || !celular.matches("\\d+")) {
            etCelular.setError("Ingrese un número celular válido de 9 dígitos");
            return;
        }

        String correo = etCorreo.getText().toString().trim();
        if (correo.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            etCorreo.setError("Ingrese un correo electrónico válido");
            return;
        }

        String direccion = etDireccion.getText().toString().trim();
        if (direccion.isEmpty()) {
            etDireccion.setError("Ingrese la dirección");
            return;
        }


        // Llama al ViewModel
        usuarioViewModel.insertarUsuario(usuario);


    }

}