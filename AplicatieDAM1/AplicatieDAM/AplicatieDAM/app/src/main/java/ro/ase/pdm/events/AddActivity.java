package ro.ase.pdm.events;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button buttonAdauga = findViewById(R.id.buttonSalveaza);
        buttonAdauga.setOnClickListener(v -> {

            EditText editTextNume = findViewById(R.id.editTextDenumire);
            Spinner spinnerCategorie = findViewById(R.id.spinnerTip);
            EditText editTextData = findViewById(R.id.editTextData);
            EditText editTextOra = findViewById(R.id.editTextOra);
            EditText editTextLocul = findViewById(R.id.editTextLocul);
            EditText editTextDescriere = findViewById(R.id.editTextDescriere);

//            editTextNume.getText()
//            spinnerCategorie.
            Toast.makeText(this, "A fost adaugat un nou eveniment", Toast.LENGTH_SHORT).show();
            // Tema: De instantiat obiectul Eveniment cu datele din AddActivity.
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}