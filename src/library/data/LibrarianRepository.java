package library.data;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import library.model.Librarian;

public class LibrarianRepository extends Repository {
    public void add(Librarian entity) {
        persist(entity);
    }
    
    public void update(Librarian entity) {
        // TO-DO
    }
    
    public Librarian getById(Long id) {
        return (Librarian)getSingleResult("SELECT e FROM Librarian e WHERE e.id = " + id.toString());
    }
    
    public Collection<Librarian> getAll() {        
        return (Collection<Librarian>) getResultList("SELECT e FROM Librarian e");
    }
}
