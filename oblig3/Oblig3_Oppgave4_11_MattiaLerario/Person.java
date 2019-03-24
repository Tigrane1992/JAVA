public class Person {

    private String forNavn;
    private int    alder;
    private String etterNavn;
    private char kjonn;

    //-----------------------------//
    //       Getters               //
    //----------------------------//



    public String getForNavn() {
        return forNavn;
    }

    public int getAlder() {
        return alder;
    }

    public String getEtterNavn() {
        return etterNavn;
    }

    public char getKjonn() {
        return kjonn;
    }




    //-----------------------------//
    //       Setters              //
    //---------------------------//


    public void setForNavn(String forNavn) {
        this.forNavn = forNavn;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public void setEtterNavn(String etterNavn) {
        this.etterNavn = etterNavn;
    }

    public void setKjonn(char kjonn) {
        this.kjonn = kjonn;
    }

    public Person(){


    }
    public String getRegissorNavn(){
        return getForNavn() + " " + getEtterNavn();

    }

    public Person(String forNavn, String etterNavn){
        this.forNavn = getForNavn();
        this.etterNavn = getEtterNavn();
    }

    public Person(String forNavn, String etterNavn, int alder, char kjonn){
        this.forNavn = forNavn;
        this.etterNavn = etterNavn;
        this.alder = alder;
        this.kjonn = kjonn;

    }




    @Override
    public String toString() {

        return "\n" +
                "\n" +
                "Person:\n--------------------------\n Fornavn:" +
                getForNavn()
                +"\n--------------------------\n Etternavn:" +
                getEtterNavn()
                +"\n--------------------------\n Alder:" +
                getAlder()
                +"\n--------------------------\n Kjønn: " +
                getKjonn();

    }
}
