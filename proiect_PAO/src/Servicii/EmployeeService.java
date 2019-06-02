package Servicii;

import Angajati.Angajat;
import Angajati.Asistent;

import java.util.List;

//pentru asistenti

public class EmployeeService implements Service
{
    private List<Asistent> angajati;

    public EmployeeService(List<Asistent> angajati)
    {
        this.angajati=angajati;
    }

    @Override
    public void display()
    {
        for (Asistent angajat : angajati)
        {
            System.out.println(angajat.getNume() + " " +angajat.getPrenume() );

        }
    }
}