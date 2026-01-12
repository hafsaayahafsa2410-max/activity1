package app;

import business.*;
import model.*;
import java.util.List;

public class AppFacade {
    private AuthorManager authorManager;
    private PaperManager paperManager;

    public AppFacade(AuthorManager am, PaperManager pm) {
        this.authorManager = am;
        this.paperManager = pm;
    }

    public Author saveAuthor(Author a) { return authorManager.save(a); }
    public List<Author> listAuthors() { return authorManager.listSorted(); }

    public Paper savePaper(Paper p) { return paperManager.save(p); }
    public List<Paper> listPapers() { return paperManager.listSorted(); }
}
