package com.example.covid.ui.mortes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.covid.R;
import com.example.covid.Resposta;

import java.util.ArrayList;
import java.util.List;

import static com.example.covid.MainActivity.paisSelecionado;
import static com.example.covid.OkHttpHandler.dadosCovid;

public class MortesFragment extends Fragment {

    private MortesViewModel mortesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mortesViewModel =
                ViewModelProviders.of(this).get(MortesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mortes, container, false);
        //final TextView textView = root.findViewById(R.id.text_gallery);


        TextView mortesNovos = root.findViewById(R.id.mortesNovos);
        TextView mortesTotal = root.findViewById(R.id.mortesTotal);
        TextView mortesData = root.findViewById(R.id.mortesData);
        TextView mortesHora = root.findViewById(R.id.mortesHora);
        Spinner spinnerC = root.findViewById(R.id.spinnerMortes);

        spinnerC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                paisSelecionado = parent.getSelectedItemPosition();
                mortesNovos.setText(String.valueOf(dadosCovid.get(parent.getSelectedItemPosition()).getDeaths().getNew()));
                mortesTotal.setText(String.valueOf(dadosCovid.get(parent.getSelectedItemPosition()).getDeaths().getTotal()));
                mortesData.setText(dadosCovid.get(parent.getSelectedItemPosition()).getDay());
                mortesHora.setText(dadosCovid.get(parent.getSelectedItemPosition()).getTime().substring(11));
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });




        mortesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });

        mortesViewModel.getOsDadosCovid().observe(getViewLifecycleOwner(), new Observer<List>() {
            @Override
            public void onChanged(List osDadosCovid) {
                ArrayList<String> countries = new ArrayList<>();
                for (Object dado : osDadosCovid) {
                    Resposta temp = (Resposta) dado;
                    countries.add((temp.getCountry()));
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, countries);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerC.setAdapter(arrayAdapter);
                spinnerC.setSelection(paisSelecionado);
            }
        });
        return root;
    }
}
