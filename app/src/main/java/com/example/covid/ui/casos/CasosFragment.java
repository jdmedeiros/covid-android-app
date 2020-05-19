package com.example.covid.ui.casos;

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

import com.example.covid.OkHttpHandler;
import com.example.covid.R;
import com.example.covid.Resposta;

import java.util.ArrayList;
import java.util.List;

import static com.example.covid.OkHttpHandler.dadosCovid;
import static com.example.covid.MainActivity.paisSelecionado;

public class CasosFragment extends Fragment {

    private CasosViewModel casosViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        casosViewModel =
                ViewModelProviders.of(this).get(CasosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_casos, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);

        TextView casosNovos = root.findViewById(R.id.novos);
        TextView casosAtivos = root.findViewById(R.id.ativos);
        TextView casosCriticos = root.findViewById(R.id.criticos);
        TextView casosRecuperados = root.findViewById(R.id.recuperados);
        TextView casosTotal = root.findViewById(R.id.casosTotal);
        TextView casosData = root.findViewById(R.id.casosData);
        TextView casosHora = root.findViewById(R.id.casosHora);
        Spinner spinnerC = root.findViewById(R.id.spinnerCasos);
        spinnerC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                paisSelecionado = parent.getSelectedItemPosition();
                casosNovos.setText(dadosCovid.get(parent.getSelectedItemPosition()).getCases().getNew());
                casosAtivos.setText(String.valueOf(dadosCovid.get(parent.getSelectedItemPosition()).getCases().getActive()));
                casosCriticos.setText(String.valueOf(dadosCovid.get(parent.getSelectedItemPosition()).getCases().getCritical()));
                casosRecuperados.setText(String.valueOf(dadosCovid.get(parent.getSelectedItemPosition()).getCases().getRecovered()));
                casosTotal.setText(String.valueOf(dadosCovid.get(parent.getSelectedItemPosition()).getCases().getTotal()));
                casosData.setText(dadosCovid.get(parent.getSelectedItemPosition()).getDay());
                casosHora.setText(dadosCovid.get(parent.getSelectedItemPosition()).getTime().substring(11));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        casosViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });


        casosViewModel.getOsDadosCovid().observe(getViewLifecycleOwner(), new Observer<List>() {
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
