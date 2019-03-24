import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //-----------------------------//
        //Sesonger/Episoder oppgave4  //
        //---------------------------//



        System.out.println("**************************\n");


        TVSerie GameOfThrones = new TVSerie("Game Of Thrones", "Best TV Show Evah!","17/04/2011",5);

        Random randomTallGenerator = new Random();

        for (int sesongNr = 1; sesongNr <= 5; sesongNr++) {
            for (int episodeNr = 1; episodeNr <= 20; episodeNr++) {
                GameOfThrones.leggTilEpisode(new Episode(episodeNr,sesongNr,"Generic Title",randomTallGenerator.nextInt(11) +20));

            }
        }

        Episode ep1S6 = new Episode(1,6,"NySesong Episode",22.1);
        Episode ep2S6 = new Episode(2,6,"NySesong Episode",22.1);
        Episode ep1S8 = new Episode(1,8,"For Høy Sesong",22.1);
        Episode ep2S8 = new Episode(2,8,"For Høy Sesong",22.1);

        GameOfThrones.leggTilEpisode(ep2S6);
        GameOfThrones.leggTilEpisode(ep1S6);


        GameOfThrones.leggTilEpisode(ep2S8);
        GameOfThrones.leggTilEpisode(ep1S8);


        //-----------------------------//
        //      Person   Objekter     //
        //---------------------------//


        Person GeorgeRRM = new Person("George","Raymond Richard Martin",70,'M');
        Person jhonnyKnoxville = new Person("Jhonny","Knoxville",45,'M');
        Person kitHarrington = new Person("Kit","Harrington",34,'M');
        Person bamMargera = new Person("Bam","Margera",34,'M');
        Person EmiliaClarke = new Person("Emilia","Clarke",34,'F');
        Person MattiaLerario = new Person("Mattia","Lerario",26,'M');


        //-----------------------------//
        //        RolleObjekter       //
        //---------------------------//



        Rolle rolle1 = new Rolle("Jhonny","knoxville",jhonnyKnoxville);
        Rolle rolle2 = new Rolle("John","Snow",kitHarrington);
        Rolle rolle3 = new Rolle("Daenerys","Targereyan",EmiliaClarke);
        Rolle rolle4 = new Rolle("Drunk","Dude",MattiaLerario);
        Rolle rolle5 = new Rolle("Bam","Margera",bamMargera);



        //-----------------------------//
        //        FilmObjekter        //
        //---------------------------//



        Film BadGrandpa = new Film("Bad grandpa","The worst way to raise a child in america by his grandfather",1.45, LocalDate.of(2013,10,24),jhonnyKnoxville);
        Film fireAndFlames = new Film("A tale of Fire and ice","Game of thrones movie",3.10,LocalDate.of(2019,10,24),GeorgeRRM);





        //--------------------------------------//
        // Legger til Roller i TVSerie og film  //
        //--------------------------------------//

        // Film 1
        BadGrandpa.leggTilRolle(rolle1);
        BadGrandpa.leggTilRolle(rolle5);

        // Film 2
        fireAndFlames.leggTilRolle(rolle2);
        fireAndFlames.leggTilRolle(rolle3);
        fireAndFlames.leggTilRolle(rolle4);
        fireAndFlames.leggTilRolle(rolle5);

        // TvSerie
        GameOfThrones.leggTilRolle(rolle2);
        GameOfThrones.leggTilRolle(rolle3);
        GameOfThrones.leggTilRolle(rolle4);



        ArrayList<Episode> GameOfThronesRoller = GameOfThrones.getEpisodeListe();

        for(int i=0; i< GameOfThronesRoller.size();i++ ){
            GameOfThrones.getEpisodeListe().get(i).leggTilMangeRoller(GameOfThrones.getRolleListe());
        }





        //--------------------------------------//
        //     Henter ut  episoder + print      //
        //--------------------------------------//

        ArrayList<Episode> episodeListe = GameOfThrones.getEpisodeListe();

        System.out.println("**************************");
        System.out.println("* " + GameOfThrones + " *");
        System.out.println("**************************");
        System.out.println("-------Alle Episoder------");


        for (Episode enEpisode : episodeListe) {
            System.out.println(enEpisode);
        }



        //--------------------------------------//
        //     Henter ut  Roller   + print      //
        //--------------------------------------//



        System.out.println("------------------------------ BAD GRANDPA MOVIE ------------------------------");
        System.out.println(BadGrandpa.getRolleListe());
        System.out.println("-----------------------------FIRE AND FLAMES ( FAKE MOVIE) --------------------------------------------------");

        System.out.println(fireAndFlames.getRolleListe());
        //Henter ut alle roller som er i en enkel episode.
        System.out.println("----------------------------HENTER UT ROLLER FRA ENKEL EPISODE I GAME OF THRONES-----------------------------------------------");

        System.out.println(ep2S6.getRolleListe());
        //Henter ut alle roller i selve tvserien
        System.out.println("--------------------------------GAME OF THRONES SERIE-----------------------------------------");
        System.out.println(GameOfThrones.hentRollebesetning());



























    }

}
