package ro.ase.pdm.events;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import ro.ase.pdm.events.model.Eveniment;

public class AdaptorEvenimente extends ArrayAdapter<Eveniment> {

    /*
    Scopul AdaptorEvenimente este sa dam display la lista de evenimente intr-un ListView.
     */

    public AdaptorEvenimente(@NonNull Context context, @NonNull List<Eveniment> objects) {
        super(context, 0, objects);

    }

    @NonNull
    @Override
    public View getView(int pos, @Nullable View view, @NonNull ViewGroup parent) {
        // 1 - Initializare view pe baza machetei
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.elem_lista, parent, false);
        }

        // 2 - Initializare controale din macheta
        TextView textViewDenumire = view.findViewById(R.id.textViewDenumire);
        TextView textViewTip = view.findViewById(R.id.textViewTip);
        TextView textViewData = view.findViewById(R.id.textViewData);
        TextView textViewLocul = view.findViewById(R.id.textViewLocul);

        // 3 - Identificare obiect curent
        Eveniment event = getItem(pos);

        // 4 - Populare controale macheta
        if (event != null) {
            textViewDenumire.setText(event.getDenumire());
            textViewTip.setText(event.getCategorie());
            textViewData.setText(event.getData());
            textViewLocul.setText(event.getLocatia());

            // 5 - Afișare specifică (culoare)
            if ("Conference".equals(event.getCategorie())) {
                view.setBackgroundColor(Color.GREEN);
            } else {
                view.setBackgroundColor(Color.WHITE);
            }
        }

        return view;
    }
}
