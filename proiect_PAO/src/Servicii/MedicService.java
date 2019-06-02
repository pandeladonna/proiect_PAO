package Servicii;

import Angajati.Medic;

import java.util.List;

public class MedicService implements Service {
    private List<Medic> medici;

    public MedicService(List<Medic> medici) {
        this.medici = medici;
    }

    @Override
    public void display() {
        for (Medic medic : medici) {
            System.out.println(medic.getNume() + " " + medic.getPrenume() + " " + medic.getSpecializare());

        }
    }
}