package com.luismmimoviles.fragmentsejemplo.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.luismmimoviles.fragmentsejemplo.Fragment.DataFragment;
import com.luismmimoviles.fragmentsejemplo.Fragment.DetailsFragment;
import com.luismmimoviles.fragmentsejemplo.R;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void sendData(String data) {
        // Aquí se obtiene el fragmento de detalles y se actualiza
        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
        if (detailsFragment != null) {
            detailsFragment.renderData(data);
        }
    }
}