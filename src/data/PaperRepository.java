package data;

import model.Paper;
import java.util.List;

public interface PaperRepository extends CrudRepository<Paper> {
    List<Paper> findAllByOrderByTitle();
    List<Paper> findByTitle(String title);
}
