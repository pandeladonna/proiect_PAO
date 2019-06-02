package Servicii;

import Pacienti.Pacient;

import java.util.List;


public class PacientService implements Service
{
    private List<Pacient> pacienti;

    public PacientService(List<Pacient> pacienti)
    {
        this.pacienti=pacienti;
    }

    @Override
    public void display()
    {
        for (Pacient pacient : pacienti)
            System.out.println(pacient.getNume() + " " + pacient.getPrenume()+ " " + pacient.getVarsta());
    }
}
