package Angajati;

import java.util.Date;

import p.Clinica;

public abstract class Angajat
{
    protected String cnp;
    protected String nume;
    protected String prenume;
    protected Date dataAngajarii;
    protected Integer salariu;
    protected String numeClinica;

    public String getCnp() {return cnp; }

    public void setCnp(String cnp) {this.cnp = cnp; }

    public String getNume() {return nume;}

    public void setNume(String nume) { this.nume = nume; }

    public String getPrenume() { return prenume; }

    public void setPrenume(String prenume) { this.prenume = prenume; }

    public Date getDataAngajarii() { return dataAngajarii; }

    public void setDataAngajarii(Date dataAngajarii) { this.dataAngajarii = dataAngajarii; }

    public Integer getSalariu() { return salariu; }

    public void setSalariu(Integer salariu) { this.salariu = salariu; }

    public String getNumeClinica() { return numeClinica; }

    public void setNumeClinica(String numeClinica) { this.numeClinica = numeClinica; }

    public Angajat(String cnp, String nume, String prenume, Date dataAngajarii, Integer salariu, String numeClinica)
    {
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
        this.dataAngajarii = dataAngajarii;
        this.salariu = salariu;
        this.numeClinica = numeClinica;
    }

    public Angajat(){}


}
