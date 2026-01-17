package data;

import model.Doctor;

import java.util.*;

public class InMemoryDoctorRepository implements DoctorRepository {
    private Map<Integer, Doctor> authors = new HashMap<>();

    public Doctor save(Doctor a) {
        authors.put(a.getId(), a);
        return a;
    }

    public Doctor update(Doctor a) {
        authors.put(a.getId(), a);
        return a;
    }

    public boolean delete(int id) {
        return authors.remove(id) != null;
    }

    public Doctor findById(int id) {
        return authors.get(id);
    }

    public long count() {
        return authors.size();
    }

    public List<Doctor> findAllByOrderByName() {
        List<Doctor> list = new ArrayList<>(authors.values());
        list.sort(Comparator.comparing(Doctor::getName));
        return list;
    }

    public List<Doctor> findByName(String name) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor a : authors.values()) {
            if (a.getName().equalsIgnoreCase(name)) {
                result.add(a);
            }
        }
        return result;
    }
}
