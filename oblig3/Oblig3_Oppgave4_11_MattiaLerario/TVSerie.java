
import java.util.ArrayList;



public class TVSerie{


    private String tittel;
    private String beskrivelse;
    private String localDate;
    private int antallSesonger;
    private int alleEpisoder = 0;
    private ArrayList<Episode> episodeListe = new ArrayList<>();
    private int gjennomSnittligSpilletid;


    //-----------------------------//
    //        Constructors        //
    //---------------------------//


    public TVSerie() {


    }


    public TVSerie(String tittel, String beskrivelse, String localDate, int antallSesonger) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.localDate = localDate;
        this.antallSesonger = antallSesonger;
    }

    public TVSerie(String tittel, String beskrivelse, String localDate, int antallSesonger, ArrayList<Episode> episodeListe) {

        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.localDate = localDate;
        this.episodeListe = episodeListe;
        this.antallSesonger = antallSesonger;
    }


    //-----------------------------//
    //        Getters             //
    //---------------------------//

    public String getTittel() { return tittel; }

    public String getBeskrivelse() { return beskrivelse;}

    public String getLocalDate() { return localDate; }

    public int getAntallSesonger() { return antallSesonger; }

    public int getGjennomSnittligSpilletid() {
        return gjennomSnittligSpilletid;
    }

    public int getEpisodeAntall() {return alleEpisoder; }

    public ArrayList<Episode> getEpisodeListe() {
        return new ArrayList<>(episodeListe);
    }


    //-----------------------------//
    //        Setters             //
    //---------------------------//

    public void setTittel(String newTittel) {
        tittel = newTittel;
    }

    public void setBeskrivelse(String newBeskrivelse) {
        beskrivelse = newBeskrivelse;
    }

    public void setlocalDate(String newLocalDate) {
        localDate = newLocalDate;
    }


    //----------------------------//
    //        Array Objekter     //
    //--------------------------//

    /* Legger til episoder  i Ønsket tvserie med vanlig for løkke,
     og sjekker opp mot at dersom listen med episoder er innenfor gitte parametere skal den legge til episoden,
     hente ut gjennomsnittelig spilletid av episoden og legge den til i gjennomsnittlig spilletid samt oppdatereden for hver episode som legges til.*/

    public void leggTilEpisode(Episode newEpisode) {
            if (newEpisode.getSesong() <= getAntallSesonger()+1) {
                episodeListe.add(newEpisode);
                oppdaterGjennomsnittligSpilletid();
                alleEpisoder++;


             if (antallSesonger < newEpisode.getSesong()) {
                antallSesonger = newEpisode.getSesong();
            }
            }
            else{
                System.out.println("Episoden i sesong: " + newEpisode.getSesong() + " tilhører en sesong som er alt for høy");

            }

        }


    public ArrayList<Episode> hentEpisoderISesong(int sesongNummer) {
        ArrayList<Episode> episoderISesong = new ArrayList<>();

        for (Episode episode : episodeListe) {
            if (episode.getSesong() == sesongNummer) {
                episoderISesong.add(episode);
            }
        }

        return episoderISesong;
    }

    private void oppdaterGjennomsnittligSpilletid() {
        int totalSpilletid = 0;

        for (Episode episode : episodeListe) {
            totalSpilletid += episode.getSpilleTid();
        }

        gjennomSnittligSpilletid = totalSpilletid / episodeListe.size();
    }


    public ArrayList<Rolle> hentRollebesetning() {
        ArrayList<Rolle> rollebesetning = new ArrayList<>();

        for (Episode enEpisode : episodeListe) {
            for (Rolle enRolle : enEpisode.getRolleListe()) {
                if (rollebesetning.contains(enRolle))
                    rollebesetning.add(enRolle);
            }
        }

        return rollebesetning;
    }



        //-----------------------------//
        //        Utskrift             //
        //---------------------------//

        public String getTVShow () {

            return "\n-------------TVSerie Utskrift Spesifikasjoner-----------------"+ "\n Tittel: " + getTittel() + "\n Beskrivelse: " + getBeskrivelse() + "\n Release Date: " + getLocalDate() + "\n Sesonger: " + getAntallSesonger() + "\n Gjennomsnittlig spilletid: "+ getGjennomSnittligSpilletid() + "\n----------------------------------\n";
        }


        //-----------------------------//
        //Override toString() Method  //
        //---------------------------//

        @Override
        public String toString () {
            return tittel + " " + beskrivelse + " " + localDate + " " + episodeListe + " " + antallSesonger;
        }


    }





