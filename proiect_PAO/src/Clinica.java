package p;

import java.util.ArrayList;

public class Clinica
{
    protected Integer id_clinica;
    protected String nume_clinica;
    protected String adresa;
    protected Integer numar_pacienti;

    public Clinica(Integer id_clinica, String nume_clinica, String adresa, Integer numar_pacienti)
    {
        this.id_clinica = id_clinica;
        this.nume_clinica = nume_clinica;
        this.adresa = adresa;
        this.numar_pacienti = numar_pacienti;
    }

    public Clinica() { }

    public Integer getId_clinica() { return id_clinica; }

    public void setId_clinica(Integer id_clinica) { this.id_clinica = id_clinica; }

    public String getNume_clinica() { return nume_clinica; }

    public void setNume_clinica(String nume_clinica) { this.nume_clinica = nume_clinica; }

    public String getAdresa() { return adresa; }

    public void setAdresa(String adresa) { this.adresa = adresa; }

    public Integer getNumar_pacienti() { return numar_pacienti; }

    public void setNumar_pacienti(Integer numar_pacienti) { this.numar_pacienti = numar_pacienti; }
}
