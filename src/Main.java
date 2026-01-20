import data.*;
import business.*;
import app.*;
import ui.*;
/*
 * Main.java
 * This is the starting point of the program.
 * we build the app by wiring the layers together in the right order:
 * Data (repositories) -> Business (managers) -> AppFacade -> CommandLineUI.
 * Then we run the UI so the user can use the menu in the console.
 */
public class Main {
    public static void main(String[] args) {
        DoctorRepository ar = new InMemoryDoctorRepository();
        PatientRepository pr = new InMemoryPatientRepository();

        DoctorManager am = new DoctorManager(ar);
        PatientManager pm = new PatientManager(pr);

        AppFacade app = new AppFacade(am, pm);
        CommandLineUI ui = new CommandLineUI(app);

        ui.start();
    }
}
