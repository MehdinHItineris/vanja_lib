package library.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import library.model.Student;

public class StudentRepository extends Repository {
    public void add(Student entity) {
        persist(entity);
    }
}
