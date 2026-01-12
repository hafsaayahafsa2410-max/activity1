package business;

import data.PaperRepository;
import model.Paper;

import java.util.List;

public class PaperManager {
    private final PaperRepository repo;

    public PaperManager(PaperRepository repo) {
        this.repo = repo;
    }

    public Paper save(Paper p) { return repo.save(p); }
    public Paper update(Paper p) { return repo.update(p); }
    public boolean delete(int id) { return repo.delete(id); }
    public Paper findById(int id) { return repo.findById(id); }
    public long count() { return repo.count(); }
    public List<Paper> listSorted() { return repo.findAllByOrderByTitle(); }
    public List<Paper> findByTitle(String title) { return repo.findByTitle(title); }
}
