package data;

import model.Paper;
import java.util.*;

public class InMemoryPaperRepository implements PaperRepository {
    private Map<Integer, Paper> papers = new HashMap<>();

    public Paper save(Paper p) {
        papers.put(p.getId(), p);
        return p;
    }

    public Paper update(Paper p) {
        papers.put(p.getId(), p);
        return p;
    }

    public boolean delete(int id) {
        return papers.remove(id) != null;
    }

    public Paper findById(int id) {
        return papers.get(id);
    }

    public long count() {
        return papers.size();
    }

    public List<Paper> findAllByOrderByTitle() {
        List<Paper> list = new ArrayList<>(papers.values());
        list.sort(Comparator.comparing(Paper::getTitle));
        return list;
    }

    public List<Paper> findByTitle(String title) {
        List<Paper> result = new ArrayList<>();
        for (Paper p : papers.values()) {
            if (p.getTitle().equalsIgnoreCase(title)) {
                result.add(p);
            }
        }
        return result;
    }
}
