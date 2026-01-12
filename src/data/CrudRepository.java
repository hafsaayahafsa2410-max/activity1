package data;

public interface CrudRepository<E> {
    E save(E e);
    E update(E e);
    boolean delete(int id);
    E findById(int id);
    long count();
}
