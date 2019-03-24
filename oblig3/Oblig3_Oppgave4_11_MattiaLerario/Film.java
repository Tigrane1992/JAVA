import java.time.LocalDate;
import java.util.ArrayList;

public class Film extends Produksjon {

    //-----------------------------//
    //       Constructors         //
    //---------------------------//


    public Film() {
    }

    public Film(String filmTittel, String filmBeskrivelse) {
        super(filmTittel, filmBeskrivelse);
    }

    public Film(String filmTittel, String filmBeskrivelse, double spilletid, LocalDate utgivelsesDato,Person regissor) {
        super(filmTittel, filmBeskrivelse, spilletid, utgivelsesDato,regissor);
    }


    @Override
    public String toString(){
        return "\n--------------------------\n Movie Title:" +
                getFilmTittel()
                +"\n--------------------------\n Movie Description:" +
                getFilmBeskrivelse()
                +"\n--------------------------\n Playtime:" +
                getSpilleTid()
                +"\n--------------------------\n Release Date: " +
                getUtgivelsesDato()
                +"\n--------------------------\n Release Date: " +
                getRegissor();
    }
}

