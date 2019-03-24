import java.util.ArrayList;

public class Rolle {

    private String rolleFornavn;
    private String rolleEtternavn;
    private Person skuespiller;



    public String getRolleFornavn() {
        return rolleFornavn;
    }

    public String getRolleEtternavn() {
        return rolleEtternavn;
    }

    public Person getSkuespiller() {
        return skuespiller;
    }



    public void setRolleFornavn(String rolleFornavn) {
        this.rolleFornavn = rolleFornavn;
    }

    public void setRolleEtternavn(String rolleEtternavn) {
        this.rolleEtternavn = rolleEtternavn;
    }

    public void setSkuespiller(Person skuespiller) {
        this.skuespiller = skuespiller;
    }


    public Rolle(String rolleFornavn, String rolleEtternavn, Person skuespiller) {
        this.rolleFornavn = rolleFornavn;
        this.rolleEtternavn = rolleEtternavn;
        this.skuespiller = skuespiller;

    }


    @Override
    public String toString(){
        return "\n Rollen til : " + rolleFornavn+" " +  rolleEtternavn + "\n\n Blir spilt av : " + skuespiller + "\n";
    }
}


