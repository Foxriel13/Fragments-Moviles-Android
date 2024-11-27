package com.luismmimoviles.fragmentsejemplo.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.luismmimoviles.fragmentsejemplo.R;

public class DataFragment extends Fragment {

    private EditText txtCambiar;
    private Button boton;
    private String data;

    public DataFragment() {
        // Constructor vacío necesario
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);

        txtCambiar = (EditText) view.findViewById(R.id.txtCambiar);
        boton = (Button) view.findViewById(R.id.btnEnviar);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callback != null) {
                    data = txtCambiar.getText().toString();
                    callback.sendData(data); // Llamada al método en la actividad
                }
            }
        });
        return view;
    }

    public interface DataListener {
        void sendData(String data);
    }

    private DataListener callback;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            callback = (DataListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " should implement DataListener");
        }
    }
}
