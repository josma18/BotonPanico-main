package com.sise.botonpanico.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sise.botonpanico.entities.Incidencia;
import com.sise.botonpanico.entities.Usuario;
import com.sise.botonpanico.repositories.UsuarioRepository;
import com.sise.botonpanico.shared.Callback;
import com.sise.botonpanico.shared.LiveDataResponse;

public class UsuarioViewModel extends ViewModel {

    private MutableLiveData<LiveDataResponse<Boolean>> insertarUsuarioLiveData;
    private UsuarioRepository usuarioRepository;

    public UsuarioViewModel(){
        insertarUsuarioLiveData = new MutableLiveData<>();
        usuarioRepository = new UsuarioRepository();
    }

    public LiveData<LiveDataResponse<Boolean>> getinsertarUsuarioLiveData(){
        return insertarUsuarioLiveData;
    }

    public void insertarUsuario(Usuario usuario){
        usuarioRepository.insertarUsuario(usuario, new Callback<Usuario>() {
            @Override
            public void onSuccess(Usuario result) {
                insertarUsuarioLiveData.postValue(LiveDataResponse.success(true));
            }

            @Override
            public void onFailure() {
                insertarUsuarioLiveData.postValue(LiveDataResponse.error());
            }
        });
    }


}
