package no.hiof.oblig5.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import no.hiof.oblig5.data.DataHandler;
import no.hiof.oblig5.model.Valuta;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    public ImageView bilde1;
    @FXML
    public ImageView bilde2;
    @FXML
    private ComboBox<String> sorteringtabell;
    @FXML
    private Button koverterknapp;
    @FXML
    private ComboBox<Valuta> valuta1;
    @FXML
    private ComboBox<Valuta> valuta2;

    @FXML
    private TextField valuta1verdi;
    @FXML
    private TextField valuta2verdi;


    /**
     * Initializerer kontrolleren har laget det meste inne i egne metoder som kalles på Initialize.
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> sorteringsListe = FXCollections.observableArrayList("Alfabetisk Stigende", "Alfabetisk Synkende", "ValutaKode Stigende", "Valutakode Synkende");
        ObservableList<Valuta> valutaListee = DataHandler.hentValutaData();
        leggTiliCombobox(valuta1);
        leggTiliCombobox(valuta2);
        Bildevisning(valuta1, bilde1);
        Bildevisning(valuta2, bilde2);
        sortering(sorteringsListe, valutaListee);

    }


    /**
     * henter ut verdiene fra Listen med valutaer og legger disse inn i Comboboxene.
     *
     * @param valutaverdi tilsvarer JavaFX elementet Combobox.
     */
    public void leggTiliCombobox(ComboBox<Valuta> valutaverdi) {
        ObservableList<Valuta> listeValuta = DataHandler.hentValutaData();
        valutaverdi.setItems(listeValuta);
        valutaverdi.setCellFactory(new Callback<ListView<Valuta>, ListCell<Valuta>>() {
            @Override
            public ListCell<Valuta> call(ListView<Valuta> ListeMedValutaer) {
                return new ValutaCelle();
            }
        });


    }

    /**
     * metode for knapp som beregner ut valutaverdiene.
     *
     * @param actionEvent
     */

    public void kalkulerValutakurs(javafx.event.ActionEvent actionEvent) {


        Double valutaverdi = Double.parseDouble(valuta1verdi.getText());

        Double Sumavvaluta;
        Sumavvaluta = valutaverdi * valuta1.getSelectionModel().getSelectedItem().getValue();
        Sumavvaluta = Sumavvaluta / valuta2.getSelectionModel().getSelectedItem().getValue();

        String SummTekst = Double.toString(Sumavvaluta);

        valuta2verdi.setText(SummTekst);

    }


    /**
     * Metode som henter inn flaggbilder fra URL.
     *
     * @param box   tilsvarer comboboxen som tilhører bilde som skal vise.
     * @param bilde tilsvarer selve JavaFX ImageView her skal bilde som har blitt hentet ut legges.
     */
    public void Bildevisning(ComboBox<Valuta> box, ImageView bilde) {
        box.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Valuta>() {
            @Override
            public void changed(ObservableValue<? extends Valuta> observableValue, Valuta valuta, Valuta t1) {
                box.setButtonCell(new ValutaCelle());
                String landsNavn = box.getSelectionModel().getSelectedItem().getCountrycode().toLowerCase();
                String urlLink = "https://www.countryflags.io/" + landsNavn + "/shiny/64.png";
                Image nyttBilde = new Image(urlLink);
                bilde.setImage(nyttBilde);

            }


        });

    }

    /**
     * Sortering av Lister.
     *
     * @param sorterListen henter ut liste med sorteringsalternativer
     * @param valutaListe  henter ut liste med valutaer.
     */

    public void sortering(ObservableList<String> sorterListen, ObservableList<Valuta> valutaListe) {

        sorteringtabell.setItems(sorterListen);

        sorteringtabell.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (sorteringtabell.getSelectionModel().getSelectedItem().equals(sorterListen.get(0))) {
                    valutaListe.sort(Comparator.comparing(Valuta::getCountryname));

                }
                if (sorteringtabell.getSelectionModel().getSelectedItem().equals(sorterListen.get(1))) {
                    valutaListe.sort(Collections.reverseOrder(Comparator.comparing(Valuta::getCountryname)));

                }
                if (sorteringtabell.getSelectionModel().getSelectedItem().equals(sorterListen.get(2))) {
                    valutaListe.sort(Comparator.comparing(Valuta::getCurrencycode));

                }
                if (sorteringtabell.getSelectionModel().getSelectedItem().equals(sorterListen.get(3))) {
                    valutaListe.sort(Collections.reverseOrder(Comparator.comparing(Valuta::getCurrencycode)));

                }
            }
        });


    }

    /**
     * @param actionEvent bytter om vinduene
     */
    public void switchVindu(javafx.event.ActionEvent actionEvent) {


        Valuta valutavenstre = valuta1.getSelectionModel().getSelectedItem();
        Valuta valutahøyre = valuta2.getSelectionModel().getSelectedItem();

        valuta1.getSelectionModel().select(valutahøyre);
        valuta2.getSelectionModel().select(valutavenstre);

        String valutateksthøyre = valuta2verdi.getText();
        String valutatekstvenstre = valuta1verdi.getText();

        valuta2verdi.setText(valutatekstvenstre);
        valuta1verdi.setText(valutateksthøyre);

    }


    //
    private class ValutaCelle extends ListCell<Valuta> {
        /**
         * Setter teksten inne i comboboxene til det ønskede oppsettet.
         *
         * @param enValuta parameter for valuta
         * @param empty    tom boolean som blir endret til true eller false ut ifra resultatet.
         */
        @Override
        protected void updateItem(Valuta enValuta, boolean empty) {
            super.updateItem(enValuta, empty);

            if (empty || enValuta == null) {
                setText(null);
            } else {
                setText(enValuta.getCountryname() + " - " + enValuta.getCurrencycode());
            }
        }


    }


}



