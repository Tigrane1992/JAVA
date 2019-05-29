package no.hiof.oblig5.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Valuta implements Comparable<Valuta> {
    @SerializedName("countryname")
    private String countryname;
    @SerializedName("countrycode")
    private String countrycode;
    @SerializedName("currencycode")
    private String currencycode;
    @SerializedName("value")
    private double value;

    private List<String> valutaArray;

/*----------------------------
    ---
    ---         Constructor
    ---
    --------------------------
     */

    public Valuta() {

        super();

    }

    public Valuta(String countryname, String countrycode, String currencycode, Double value) {
        super();
        this.countryname = countryname;
        this.countrycode = countrycode;
        this.currencycode = currencycode;
        this.value = value;


    }

    /*----------------------------
    ---
    ---         Getters
    ---
    -------------------------------
     */

    public String getCountryname() {
        return countryname;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public double getValue() {
        return value;
    }

    public List<String> getValutaArray() {
        return valutaArray;
    }
    /*----------------------------
    ---
    ---         Setters
    ---
    -------------------------------
     */

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public void setCurrencycode(double verdi2) {
        this.currencycode = currencycode;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setValuta(List<String> valutaarray) {
        valutaArray = valutaarray;
    }


    //ToString
    @Override
    public String toString() {
        return countryname + ' ' + currencycode;
    }

    @Override
    public int compareTo(Valuta Valutanavn) {

        return this.getCountryname().toLowerCase().compareTo(Valutanavn.getCountryname().toLowerCase());

    }


}

