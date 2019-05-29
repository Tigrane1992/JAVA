package no.hiof.oblig5.data;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import no.hiof.oblig5.model.Valuta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


public class DataHandler {

    private final static ObservableList<Valuta> ValutaListe = FXCollections.observableArrayList();


    /**
     * henter ut metoden som henter ut Gson filen.
     *
     * @return
     */
    public static ObservableList<Valuta> hentValutaData() {


        if (ValutaListe.isEmpty()) {


            getJSONDATA();
        }

        return ValutaListe;

    }


    /**
     * konverterer Json fil til en Liste med innhold.
     */
    public static void getJSONDATA() {

        try {
            //Create a new Gson object
            Gson gson = new Gson();

            //Read the json file
            BufferedReader br = new BufferedReader(new FileReader("src/valutakurser.json"));

            //convert the json to  Java Array(Value)

            Type collectionType = new TypeToken<List<Valuta>>() {
            }.getType();
            List<Valuta> valutakurser = gson.fromJson(br, collectionType);

            ValutaListe.addAll(valutakurser);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
