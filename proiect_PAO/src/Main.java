import Angajati.Asistent;
import Angajati.Medic;
import Pacienti.Adult;
import Pacienti.Minor;
import Pacienti.Pacient;
import Servicii.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class Main {

    private static s.Specializare dermato = new s.Specializare("dermatologie", 0);
    private static s.Specializare cardio = new s.Specializare("cardiologie", 0);
    private static s.Specializare ofta = new s.Specializare("oftalmologie", 0);
    private static List<s.Specializare> specializari = new ArrayList<>();


    private static p.Clinica reginaMaria = new p.Clinica(1, "Regina Maria", "Policlinica Floreasca, Bucuresti, sector 2", 0);
    private static p.Clinica sanador = new p.Clinica(2, "Sanador", "Bvd Rozelor, nr 3, Bucuresti, sector 5", 0);
    private static p.Clinica expertClinique = new p.Clinica(3, "Expert clinique", "Str. Sperantei, nr 9-11, Bucuresti , sector 1", 0);


    private static void afiseazaMeniu() {
        System.out.println();

        System.out.println("Meniu:");

        System.out.println("0. Exit");
        System.out.println("1. Afiseaza Pacienti.");
        System.out.println("2. Afiseaza Medici.");
        System.out.println("3. Adauga Pacient.");
        System.out.println("4. Afiseaza asistenti");
        System.out.println("5. Afiseaza specializarea cu cei mai multi doctori");
        System.out.println("6. Sterge pacient");
        System.out.println("7. Afiseaza programarile din clinica Regina Maria");
        System.out.println("8. Modifica data programare");
        System.out.println("9. Afiseaza doctorul cel mai bine platit si specializarea lui");
        System.out.println("10. Adauga o programare la un pacient existent");

        System.out.println("Alege Optiune: ");

    }

    private static List<Pacient> pacienti = new ArrayList<>();
    private static List<Medic> medici = new ArrayList<>();
    private static List<Asistent> asistenti = new ArrayList<>();
    private static List<pr.Programare> programari = new ArrayList<>();
    private static List<p.Clinica> clinici = new ArrayList<>();


    public static void citeste_asistenti() {
        try {

            List<String> lines = Files.readAllLines(Paths.get("src\\data\\lista_asistenti.csv"));
            for (String line : lines) {
                String[] result = line.split(",");
                String cnp = result[0];
                String nume = result[1];
                String prenume = result[2];
                String data_ang = result[3];
                String salariu = result[4];
                String nume_clinica = result[5];

                //get date from string
                DateFormat formatter;
                Date date_ang;
                formatter = new SimpleDateFormat("dd-MM-yyyy");
                date_ang = (Date) formatter.parse(data_ang);

                //get integer from string
                int salariu_int = Integer.parseInt(salariu);

                Asistent a = new Asistent(cnp, nume, prenume, date_ang, salariu_int, nume_clinica);
                asistenti.add(a);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public static void citeste_medici() {

        try {
            ReadService readService = new ReadService("src/data/lista_medici.csv");

            String[] line = readService.readLine();

            while (line != null) {
                String cnp = line[0].trim();
                String nume = line[1].trim();
                String prenume = line[2].trim();
                String data_nasterii = line[3].trim();
                String salariu = line[4].trim();
                String nume_clinica = line[5].trim();
                String specializare = line[6].trim();

                DateFormat formatter;
                Date data_n = new Date();
                formatter = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    data_n = (Date) formatter.parse(data_nasterii);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                int salariu_int = Integer.parseInt(salariu);

                Medic medic = new Medic(cnp, nume, prenume, data_n, salariu_int, nume_clinica, specializare);
                medici.add(medic);

                if (specializare.equals("dermatologie"))
                    dermato.nr_angajati++;
                else if (specializare.equals("cardiologie"))
                    cardio.nr_angajati++;
                else if (specializare.equals("oftalmologie"))
                    ofta.nr_angajati++;

                line = readService.readLine();
            }
        } catch (IOException e) {
            System.out.println("A aparut o eroare la citirea din fisier");
        }
    }

    public static void citeste_programari(){
        try {
            ReadService readService = new ReadService("src/data/lista_programari.csv");

            String[] line = readService.readLine();

            while (line != null)
            {
                String data_programare =line[0].trim();
                String id_clinica=line[1].trim();
                String nume_medic=line[2].trim();
                String id_programare=line[3].trim();

                DateFormat formatter;
                Date data_p = new Date();
                formatter = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    data_p = (Date) formatter.parse(data_programare);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                int id_cl = Integer.parseInt(id_clinica);
                int id_prog=Integer.parseInt(id_programare);
                pr.Programare programare= new pr.Programare(data_p,id_cl,nume_medic,id_prog);

                programari.add(programare);

                line = readService.readLine();
            }



    }catch (IOException e) {
            System.out.println("A aparut o eroare la citirea din fisier");
        }

    }

    public static void citeste_pacienti() {
        try {
            ReadService readService = new ReadService("src/data/pacienti.csv");
            //readService.readLine();

            String[] line = readService.readLine();

            while (line != null) {
                String cnp = line[0].trim();
                String nume = line[1].trim();
                String prenume = line[2].trim();
                String varsta = line[3].trim();

                int varsta_int = Integer.parseInt(varsta);
                if (varsta_int < 18) {
                    String nume_tutore = line[4].trim();
                    String data_nasterii = line[5].trim();
                    String nume_clinica = line[6].trim();


                    DateFormat formatter;
                    Date data_n = new Date();
                    formatter = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        data_n = (Date) formatter.parse(data_nasterii);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    List<Integer> prog = new ArrayList<Integer>();
                    for (int i = 7; i < line.length; i++)
                        prog.add(Integer.parseInt(line[i].trim()));

                    Minor minor = new Minor(cnp, nume, prenume, varsta_int, data_n, nume_clinica, prog, nume_tutore);
                    pacienti.add(minor);

                } else {
                    String data_nasterii = line[4].trim();
                    String nume_clinica = line[5].trim();


                    DateFormat formatter;
                    Date data_n = new Date();
                    formatter = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        data_n = (Date) formatter.parse(data_nasterii);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    List<Integer> prog = new ArrayList<Integer>();
                    for (int i = 6; i < line.length; i++)
                        prog.add(Integer.parseInt(line[i].trim()));

                    Adult adult = new Adult(cnp, nume, prenume, varsta_int, data_n, nume_clinica, prog);
                    pacienti.add(adult);

                }

                line = readService.readLine();
            }
        } catch (IOException e) {
            System.out.println("A aparut o eroare la citirea din fisier");
        }


    }


    public static void main(String[] args) {
        afiseazaMeniu();
        citeste_asistenti();
        citeste_pacienti();
        citeste_medici();


        specializari.add(dermato);
        specializari.add(cardio);
        specializari.add(ofta);

        clinici.add(reginaMaria);
        clinici.add(sanador);
        clinici.add(expertClinique);


        for (Pacient pacient : pacienti)
            if (pacient.getNume_clinica().equals("Regina Maria")) {
                int nr = reginaMaria.getNumar_pacienti();
                nr++;
                reginaMaria.setNumar_pacienti(nr);
            } else if (pacient.getNume_clinica().equals("Sanador")) {
                int nr = sanador.getNumar_pacienti();
                nr++;
                sanador.setNumar_pacienti(nr);
            } else {
                int nr = expertClinique.getNumar_pacienti();
                nr++;
                expertClinique.setNumar_pacienti(nr);
            }


        AuditService auditService = AuditService.getInstance();


        Scanner scan = new Scanner(System.in);

        int optiune = scan.nextInt();

        while (optiune != 0) {
            switch (optiune) {
                case 1: {
                    PacientService pacientService = new PacientService(pacienti);
                    pacientService.display();
                    auditService.writeLine("Afiseaza pacienti ");
                    break;
                }

                case 2: {
                    MedicService medicService = new MedicService(medici);
                    medicService.display();
                    auditService.writeLine("Afiseaza medici ");
                    break;
                }
                case 3: {
                    System.out.println("CNP:");
                    String cnp = scan.next();
                    System.out.println("Nume:");
                    String nume = scan.next();
                    System.out.println("Prenume:");
                    String prenume = scan.next();
                    System.out.println("Varsta:");
                    int varsta = scan.nextInt();
                    System.out.println("Data nasterii:");
                    String data_nasterii = scan.next();
                    System.out.println("Nume clinica:");
                    String numeClinica = scan.next();
                    DateFormat formatter;
                    Date data_n = new Date();
                    formatter = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        data_n = (Date) formatter.parse(data_nasterii);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Nr inregistrare programare:");
                    List<Integer> list = new ArrayList<Integer>();
                    int i = scan.nextInt();
                    list.add(i);
                    if (varsta >= 18) {
                        Adult adult = new Adult(cnp, nume, prenume, varsta, data_n, numeClinica, list);
                        pacienti.add(adult);
                    } else {
                        System.out.println("Nume Tutore:");
                        String numeTutore = scan.next();
                        Minor minor = new Minor(cnp, nume, prenume, varsta, data_n, numeClinica, list, numeTutore);
                        pacienti.add(minor);
                    }

                    System.out.println("Pacient inregistrat cu succes!");
                    System.out.println("Apasa o noua tasta pentru o noua interogare sau 0 pentru iesire");
                    auditService.writeLine("Am inregistrat un pacient ");
                    break;
                }


                case 4: {
                    EmployeeService employeeService = new EmployeeService(asistenti);
                    employeeService.display();
                    auditService.writeLine("Afiseaza asistenti ");
                    break;
                }
                case 5: {
                    int max = 0;
                    for (s.Specializare specializare : specializari)
                        if (specializare.getNr_angajati() > max)
                            max = specializare.getNr_angajati();

                    for (s.Specializare specializare : specializari)
                        if (specializare.getNr_angajati() == max)
                            System.out.println(specializare.getNume_specializare() + " " + specializare.getNr_angajati());

                    auditService.writeLine("Am afisat specializarea cu cei mai multi doctori ");
                    PacientService pacientService = new PacientService(pacienti);
                    pacientService.display();


                    break;
                }
                case 6: {

                }
                case 7: {
                    //Regina maria are id=1
                for (pr.Programare programare : programari)
                    if (programare.getId_clinica()==1)
                        System.out.println(programare.getId_programare() + " " + programare.getData_programare()+ " " + programare.getNume_medic());

                }
                case 8: {

                }
                case 9: {
                    int max = 0;
                    for (Medic medic : medici)
                        if (medic.getSalariu() > max)
                            max = medic.getSalariu();

                    for (Medic medic : medici)
                        if (medic.getSalariu() == max)
                            System.out.println(medic.getNume() + " " + medic.getSalariu() + " " + medic.getSpecializare());

                    auditService.writeLine("Am afisat doctorul cel mai bine platit!");
                    System.out.println("Apasa o noua tasta pentru o noua interogare sau 0 pentru iesire");
                    break;
                }
                case 10: {
                    //adauga programare, identificare dupa CNP
                    System.out.println("CNP:");
                    String cnp = scan.next();
                    System.out.println("Id programare:");
                    int x = scan.nextInt();
                    System.out.println("Data:");
                    String data_pr = scan.next();
                    System.out.println("Clinica:");
                    int id_clinica = scan.nextInt();
                    System.out.println("Nume medic:");
                    String nume_medic = scan.next();

                    DateFormat formatter;
                    Date data_p = new Date();
                    formatter = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        data_p = (Date) formatter.parse(data_pr);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    for (Pacient pacient : pacienti) {
                        if (pacient.getCnp() == cnp)
                            pacient.getLista_programari().add(x);
                    }

                    pr.Programare pr = new pr.Programare(data_p, x, nume_medic, id_clinica);
                    programari.add(pr);
                    auditService.writeLine("Am inregistrat o programare la un pacient existent ");

                    System.out.println("Apasa o noua tasta pentru o noua interogare sau 0 pentru iesire");
                    break;
                }

            }
            optiune = scan.nextInt();
        }

    }

}