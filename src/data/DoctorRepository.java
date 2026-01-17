package data;

import model.Doctor;
import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor> {
    List<Doctor> findAllByOrderByName();
    List<Doctor> findByName(String name);
}
