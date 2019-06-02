package s;

public class Specializare
{
    protected String nume_specializare;
    public Integer nr_angajati;

    public String getNume_specializare() { return nume_specializare; }

    public void setNume_specializare(String nume_specializare) { this.nume_specializare = nume_specializare; }

    public Integer getNr_angajati() { return nr_angajati; }

    public void setNr_angajati(Integer nr_angajati) { this.nr_angajati = nr_angajati; }

    public Specializare(String nume_specializare, Integer nr_angajati)
    {
        this.nume_specializare = nume_specializare;
        this.nr_angajati = nr_angajati;
    }
    public Specializare(){}
}
