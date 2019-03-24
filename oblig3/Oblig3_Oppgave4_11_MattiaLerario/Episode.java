
public class Episode extends Produksjon{

    private int episodeNummer;
    private  int sesong;


    //-----------------------------//
    //        Constructors        //
    //---------------------------//


    public Episode(){


    }

    public Episode(int episodeNummer, int sesong, String episodeTittel, double spilletid){
        super(ti,spilletid);
        this.episodeNummer = episodeNummer;
        this.sesong = sesong;


    }

    public Episode(int episodeNummer, int sesong, String episodeTittel){
        super(Tittel);
        this.episodeNummer = episodeNummer;
        this.sesong = sesong;


    }



    //-----------------------------//
    //        Getters             //
    //---------------------------//

    public int getEpisodeNumber(){
        return episodeNummer;

    }

    public int getSesong(){
        return sesong;

    }



    //-----------------------------//
    //        Setters             //
    //---------------------------//

    public void setEpisodeNumber(int newEpisodeNumber){
        episodeNummer= newEpisodeNumber;

    }

    public void setSesong(int newSesong){
        sesong=newSesong;

    }


    //-----------------------------//
    //        toString() Method   //
    //---------------------------//

    @Override
    public String toString(){
        return "\n" + getEpisodeTittel() + " "  + episodeNummer + " Sesong: " + sesong + " Spilletid: " + getSpilleTid() + getRolleListe();
    }





}