package Pacienti;

import pr.Programare;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Pacient
{
    protected String cnp;
    protected String nume;
    protected String prenume;
    protected Integer varsta;
    protected Date dataNasterii;
    protected String nume_clinica;
    protected List<Integer> lista_programari;

    public Pacient() {}

    public Pacient(String cnp, String nume, String prenume, Integer varsta, Date dataNasterii, String nume_clinica, List<Integer> lista_programari)
    {
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.dataNasterii = dataNasterii;
        this.nume_clinica = nume_clinica;
        this.lista_programari = lista_programari;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    public Date getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(Date dataNasterii) { this.dataNasterii = dataNasterii; }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getNume_clinica() { return nume_clinica; }

    public void setNume_clinica(String nume_clinica) { this.nume_clinica = nume_clinica; }

    public List<Integer> getLista_programari() { return lista_programari; }

    public void setLista_programari(List<Integer> lista_programari) { this.lista_programari = lista_programari; }
}
