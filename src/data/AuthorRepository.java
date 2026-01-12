package data;

import model.Author;
import java.util.List;

public interface AuthorRepository extends CrudRepository<Author> {
    List<Author> findAllByOrderByName();
    List<Author> findByName(String name);
}
