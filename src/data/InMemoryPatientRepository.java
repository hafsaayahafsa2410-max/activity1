package data;

import model.Patient;

import java.util.*;

public class InMemoryPatientRepository implements PatientRepository {
    private Map<Integer, Patient> papers = new HashMap<>();

    public Patient save(Patient p) {
        papers.put(p.getId(), p);
        return p;
    }

    public Patient update(Patient p) {
        papers.put(p.getId(), p);
        return p;
    }

    public boolean delete(int id) {
        return papers.remove(id) != null;
    }

    public Patient findById(int id) {
        return papers.get(id);
    }

    public long count() {
        return papers.size();
    }

    public List<Patient> findAllByOrderByTitle() {
        List<Patient> list = new ArrayList<>(papers.values());
        list.sort(Comparator.comparing(Patient::getTitle));
        return list;
    }

    public List<Patient> findByTitle(String title) {
        List<Patient> result = new ArrayList<>();
        for (Patient p : papers.values()) {
            if (p.getTitle().equalsIgnoreCase(title)) {
                result.add(p);
            }
        }
        return result;
    }
}
