/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.data;

import java.util.Collection;
import library.model.Author;

/**
 *
 * @author mehdinh
 */
public class AuthorRepository extends Repository {
    public void add(Author entity) {
        persist(entity);
    }
    
    public void update(Author entity) {
        
    }
    
    public Author getById(Long id) {
        return (Author)getSingleResult("SELECT e FROM Author e WHERE e.id = " + id.toString());
    }
    
    public Collection<Author> getAll() {        
        return (Collection<Author>) getResultList("SELECT e FROM Author e");
    }
    
    public Collection<Author> getAllByBookId(Long bookId) {        
        return (Collection<Author>) getResultList("SELECT e FROM Author e INNER JOIN BookAuthor ba ON e.Id = ba.AuthorId WHERE ba.Id = " + bookId.toString());
    }

}
