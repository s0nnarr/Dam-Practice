package ro.ase.pdm.events;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
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

import java.util.Random;

import ro.ase.pdm.events.model.Eveniment;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);

        MaterialToolbar toolbar = findViewById(R.id.toolbar); // Selecting the toolbar;
        Button saveButton = findViewById(R.id.buttonSalveaza);
        saveButton.setOnClickListener(v -> saveEvent());

        setSupportActionBar(toolbar);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.categorii, // string-array from strings.XML
                android.R.layout.simple_spinner_item
        );
        Spinner spinnerTip = findViewById(R.id.spinnerTip);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTip.setAdapter(adapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void saveEvent() {
        EditText editTextDenumire = findViewById(R.id.editTextDenumire);
        EditText editTextData = findViewById(R.id.editTextData);
        EditText editTextDescriere = findViewById(R.id.editTextDescriere);
        EditText editTextLocul = findViewById(R.id.editTextLocul);
        EditText editTextOra = findViewById(R.id.editTextOra);
        Spinner spinnerCategorie = findViewById(R.id.spinnerTip);

        // Validation

        String denumire = editTextDenumire.getText().toString();
        String data = editTextData.getText().toString();
        String descriere = editTextDescriere.getText().toString();
        String locul = editTextLocul.getText().toString();
        String ora = editTextOra.getText().toString();
        String categorie = spinnerCategorie.getSelectedItem().toString();

        if (denumire.isEmpty()) {
            editTextDenumire.setError("Introdu o denumire!");
            editTextDenumire.requestFocus();
            return;
        }

        if (data.isEmpty()) {
            editTextData.setError("Introdu o dată!");
            editTextData.requestFocus();
            return;
        }

        if (ora.isEmpty()) {
            editTextOra.setError("Introdu o oră!");
            editTextOra.requestFocus();
            return;
        }

        if (locul.isEmpty()) {
            editTextLocul.setError("Introdu un loc!");
            editTextLocul.requestFocus();
            return;
        }


        Random random = new Random();
        int _id = random.nextInt(999) + 1;

        Toast.makeText(this, "Eveniment salvat cu success!", Toast.LENGTH_SHORT).show();


        Eveniment e = new Eveniment(
                _id,
                categorie,
                data,
                ora,
                locul,
                descriere
                );

        Log.d("AddActivity", "S-a salvat evenimentul " + e);
        setResult(RESULT_OK, new Intent().putExtra("TRANZACTIE", e));

        Intent intent = new Intent(AddActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}