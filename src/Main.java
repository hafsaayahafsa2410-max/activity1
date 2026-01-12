import data.*;
import business.*;
import app.*;
import ui.*;

public class Main {
    public static void main(String[] args) {
        AuthorRepository ar = new InMemoryAuthorRepository();
        PaperRepository pr = new InMemoryPaperRepository();

        AuthorManager am = new AuthorManager(ar);
        PaperManager pm = new PaperManager(pr);

        AppFacade app = new AppFacade(am, pm);
        CommandLineUI ui = new CommandLineUI(app);

        ui.start();
    }
}
