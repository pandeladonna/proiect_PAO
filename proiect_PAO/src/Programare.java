package pr;

import Angajati.Medic;
import p.Clinica;

import java.util.Date;

public class Programare
{
    protected Date data_programare;
    protected Integer id_programare;
    protected Integer id_clinica;
    protected String nume_medic;

    public Programare(Date data_programare, Integer id_clinica, String nume_medic,Integer id_programare)
    {
        this.data_programare = data_programare;
        this.id_clinica = id_clinica;
        this.nume_medic = nume_medic;
        this.id_programare=id_programare;
    }

    public Programare(){}

    public Date getData_programare() {
        return data_programare;
    }

    public void setData_programare(Date data_programare) { this.data_programare = data_programare; }

    public Integer getId_clinica() { return id_clinica; }

    public void setId_clinica(Integer id_clinica) { this.id_clinica = id_clinica; }

    public String getNume_medic() { return nume_medic; }

    public void setNume_medic(String nume_medic) { this.nume_medic = nume_medic; }

    public Integer getId_programare() { return id_programare; }

    public void setId_programare(Integer id_programare) { this.id_programare = id_programare; }

}
