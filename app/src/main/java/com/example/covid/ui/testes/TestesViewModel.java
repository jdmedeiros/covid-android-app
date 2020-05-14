package com.example.covid.ui.testes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.covid.OkHttpHandler.dadosCovid;

public class TestesViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<ArrayList<String>> aLista = new MutableLiveData<ArrayList<String>>();
    private MutableLiveData<List> osDadosCovid = new MutableLiveData<List>();

    public TestesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is teste fragment");
        osDadosCovid.setValue(dadosCovid);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List> getOsDadosCovid() {
        return osDadosCovid;
    }
}