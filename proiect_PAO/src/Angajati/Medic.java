package Angajati;

import java.util.Date;
import s.Specializare;

import java.util.ArrayList;

public class Medic extends Angajat
{
    protected String specializare;

    public Medic(){}

    public Medic(String cnp, String nume, String prenume, Date dataAngajarii, Integer salariu, String numeClinica,
                 String specializare)
    {
        super(cnp, nume, prenume, dataAngajarii, salariu, numeClinica);
        this.specializare = specializare;
    }

    public String getSpecializare() { return specializare; }

    public void setSpecializare(String specializare) { this.specializare = specializare; }
}
