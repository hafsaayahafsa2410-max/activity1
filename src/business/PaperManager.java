package business;

import data.PaperRepository;
import model.Paper;
import java.util.List;

public class PaperManager {

    private PaperRepository repo;

    public PaperManager(PaperRepository repo) {
        this.repo = repo;
    }

    public Paper save(Paper paper) {
        return repo.save(paper);
    }

    public Paper update(Paper paper) {
        return repo.update(paper);
    }

    public boolean delete(int id) {
        return repo.delete(id);
    }

    public Paper findById(int id) {
        return repo.findById(id);
    }

    public long count() {
        return repo.count();
    }

    public List<Paper> listSorted() {
        return repo.findAllByOrderByTitle();
    }

    public List<Paper> findByTitle(String title) {
        return repo.findByTitle(title);
    }
}
