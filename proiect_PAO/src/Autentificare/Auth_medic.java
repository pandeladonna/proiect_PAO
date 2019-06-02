package Autentificare;

import Angajati.Medic;

public class Auth_medic implements Auth
{
    private Medic medic;
    private String parola;

    @Override
    public String getUserName() { return medic.getNume(); }

    @Override
    public String getParola() { return parola; }
}


