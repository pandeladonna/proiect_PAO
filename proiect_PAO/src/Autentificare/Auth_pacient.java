package Autentificare;

import Pacienti.Pacient;

public class Auth_pacient implements Auth
{
    private Pacient pacient;
    private String parola;

    @Override
    public String getUserName() { return pacient.getNume(); }

    @Override
    public String getParola() { return parola; }

}
