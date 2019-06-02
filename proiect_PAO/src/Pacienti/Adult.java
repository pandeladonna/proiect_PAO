package Pacienti;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Adult extends Pacient
{
    public Adult() {}

    public Adult(String cnp, String nume, String prenume, Integer varsta, Date dataNasterii, String nume_clinica, List<Integer> lista_programari)
    {
        super(cnp, nume, prenume, varsta, dataNasterii, nume_clinica, lista_programari);
    }
}
