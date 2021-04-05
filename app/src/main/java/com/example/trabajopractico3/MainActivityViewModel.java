package com.example.trabajopractico3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<Boolean> Dolares;
    private MutableLiveData<Boolean> Euros;
    private MutableLiveData<Boolean> RbA;
    private MutableLiveData<Boolean> RbB;
    private MutableLiveData<String> resultadoMutable;

    public LiveData<Boolean> getDolares(){
        if (Dolares==null){
            Dolares = new MutableLiveData<>();
        }
        return Dolares;
    }
    public LiveData<Boolean> getEuros(){
        if (Euros==null){
            Euros = new MutableLiveData<>();
        }
        return Euros;
    }
    public LiveData<Boolean> getRbA(){
        if (RbA==null){
            RbA = new MutableLiveData<>();
        }
        return RbA;
    }
    public LiveData<Boolean> getRbB(){
        if (RbB==null){
            RbB = new MutableLiveData<>();
        }
        return RbB;
    }
    public LiveData<String> getResultadoMutable() {
        if (resultadoMutable==null){
            resultadoMutable = new MutableLiveData<>();
        }
        return resultadoMutable;
    }

    public void cambiar(int view, int RbA, int RbB) {
        if ( view == RbA) {
            Euros.setValue(true);
            Dolares.setValue(false);
        } else {
            Euros.setValue(false);
            Dolares.setValue(true);
        }
    }

    public void convirtiendo(Boolean rbA, String etDorales, String etEuros) {

            double resultado;
            if (rbA) {//Si esta seleccionado el radiobutton rbA se pasara de Euros a Dolares....1 euro es igual a 1,18 dolares
                double euros = Double.parseDouble(etEuros);
                resultado = euros * 1.18;
                resultadoMutable.setValue(resultado + " dolares");
            } else {//Sino, al estar seleccionado el radiobutton rbB se pasara de Dolares a Euros....1 dolar es igual a 0.85 euros
                double dolares = Double.parseDouble(etDorales);
                resultado = dolares * 0.85;
                resultadoMutable.setValue(resultado + " euros");
            }
    }
}
