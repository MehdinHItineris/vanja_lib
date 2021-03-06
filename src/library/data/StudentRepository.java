package library.data;

import library.model.Student;
import java.util.Collection;

public class StudentRepository extends Repository {
    public void add(Student entity) {
        persist(entity);
    }


    public void update(Student entity) {
        
    }
    
    public Student getById(Long id) {
        return (Student)getSingleResult("SELECT e FROM Student e WHERE e.id = " + id.toString());
    }
    
    public Collection<Student> getAll() {        
        return (Collection<Student>) getResultList("SELECT e FROM Student e");
    }

}