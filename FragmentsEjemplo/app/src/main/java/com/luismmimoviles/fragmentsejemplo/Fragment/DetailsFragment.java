package com.luismmimoviles.fragmentsejemplo.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luismmimoviles.fragmentsejemplo.R;

public class DetailsFragment extends Fragment {
    private TextView textViewDetails;

    public DetailsFragment() {
        // Constructor vacío necesario
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        textViewDetails = view.findViewById(R.id.textView);
        return view;
    }

    public void renderData(String string) {
        if (textViewDetails != null) {
            textViewDetails.setText(string);
        }
    }
}
