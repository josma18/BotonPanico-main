package com.sise.botonpanico.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sise.botonpanico.entities.TipoIncidencia;
import java.util.List;

public class TipoIncidenciaSpinnerAdapter extends ArrayAdapter<TipoIncidencia> {

    private List<TipoIncidencia> tipoIncidencias;

    public TipoIncidenciaSpinnerAdapter(@NonNull Context context, List<TipoIncidencia> tipoIncidencias) {
        super(context, android.R.layout.simple_spinner_item ,tipoIncidencias);
        this.tipoIncidencias = tipoIncidencias;
    }

    @Override
    public int getCount() {
        return this.tipoIncidencias != null ? this.tipoIncidencias.size() : 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //spinner
        View view = super.getView(position, convertView, parent);

        //textview dentro de spinner
        TextView textView = view.findViewById(android.R.id.text1);
        TipoIncidencia tipoIncidencia = getItem(position);
        if(tipoIncidencia != null){
            textView.setText(tipoIncidencia.getDescripcion());
        }
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //spinner
        View view = super.getView(position, convertView, parent);

        //textview dentro de spinner
        TextView textView = view.findViewById(android.R.id.text1);
        TipoIncidencia tipoIncidencia = getItem(position);
        if(tipoIncidencia != null){
            textView.setText((position+1)+". "+tipoIncidencia.getDescripcion()+" ("+tipoIncidencia.getIdTipoIncidencia()+")");
        }
        return view;
    }
}
