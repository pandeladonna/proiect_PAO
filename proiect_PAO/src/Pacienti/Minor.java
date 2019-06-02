package Pacienti;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Minor extends Pacient
{

    protected String numeTutore;

    public Minor() {}

    public String getNumeTutore() { return numeTutore; }

    public void setNumeTutore(String numeTutore) { this.numeTutore = numeTutore; }

    public Minor(String cnp, String nume, String prenume, Integer varsta, Date dataNasterii, String nume_clinica, List<Integer> lista_programari, String numeTutore)
    {
        super(cnp, nume, prenume, varsta, dataNasterii, nume_clinica, lista_programari);
        this.numeTutore = numeTutore;
    }
}
