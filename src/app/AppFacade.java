package app;

import business.AuthorManager;
import business.PaperManager;
import model.Author;
import model.Paper;

import java.util.List;

public class AppFacade {
    private final AuthorManager authorManager;
    private final PaperManager paperManager;

    public AppFacade(AuthorManager authorManager, PaperManager paperManager) {
        this.authorManager = authorManager;
        this.paperManager = paperManager;
    }

    // ---------- AUTHOR operations ----------
    public Author saveAuthor(Author a) { return authorManager.save(a); }
    public Author updateAuthor(Author a) { return authorManager.update(a); }
    public boolean deleteAuthor(int id) { return authorManager.delete(id); }
    public Author findAuthorById(int id) { return authorManager.findById(id); }
    public long countAuthors() { return authorManager.count(); }
    public List<Author> listAuthorsSortedByName() { return authorManager.listSorted(); }
    public List<Author> findAuthorsByName(String name) { return authorManager.findByName(name); }

    // ---------- PAPER operations ----------
    public Paper savePaper(Paper p) { return paperManager.save(p); }
    public Paper updatePaper(Paper p) { return paperManager.update(p); }
    public boolean deletePaper(int id) { return paperManager.delete(id); }
    public Paper findPaperById(int id) { return paperManager.findById(id); }
    public long countPapers() { return paperManager.count(); }
    public List<Paper> listPapersSortedByTitle() { return paperManager.listSorted(); }
    public List<Paper> findPapersByTitle(String title) { return paperManager.findByTitle(title); }
}
