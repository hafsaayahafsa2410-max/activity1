package business;

import data.AuthorRepository;
import model.Author;
import java.util.List;

public class AuthorManager {
    private AuthorRepository repo;

    public AuthorManager(AuthorRepository repo) {
        this.repo = repo;
    }

    public Author save(Author a) { return repo.save(a); }
    public Author update(Author a) { return repo.update(a); }
    public boolean delete(int id) { return repo.delete(id); }
    public Author findById(int id) { return repo.findById(id); }
    public long count() { return repo.count(); }
    public List<Author> listSorted() { return repo.findAllByOrderByName(); }
    public List<Author> findByName(String name) { return repo.findByName(name); }
}
