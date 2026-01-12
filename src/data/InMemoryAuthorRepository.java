package data;

import model.Author;
import java.util.*;

public class InMemoryAuthorRepository implements AuthorRepository {
    private Map<Integer, Author> authors = new HashMap<>();

    public Author save(Author a) {
        authors.put(a.getId(), a);
        return a;
    }

    public Author update(Author a) {
        authors.put(a.getId(), a);
        return a;
    }

    public boolean delete(int id) {
        return authors.remove(id) != null;
    }

    public Author findById(int id) {
        return authors.get(id);
    }

    public long count() {
        return authors.size();
    }

    public List<Author> findAllByOrderByName() {
        List<Author> list = new ArrayList<>(authors.values());
        list.sort(Comparator.comparing(Author::getName));
        return list;
    }

    public List<Author> findByName(String name) {
        List<Author> result = new ArrayList<>();
        for (Author a : authors.values()) {
            if (a.getName().equalsIgnoreCase(name)) {
                result.add(a);
            }
        }
        return result;
    }
}
