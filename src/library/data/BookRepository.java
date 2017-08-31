/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.data;

import java.util.Collection;
import library.model.Book;

/**
 *
 * @author mehdinh
 */
public class BookRepository extends Repository {
    public void add(Book entity) {
        persist(entity);
    }
    
    public void update(Book entity) {
        merge(entity);
    }
    
    public Book getById(Long id) {
        return (Book)getSingleResult("SELECT e FROM Book e WHERE e.id = " + id.toString());
    }
    
    public Collection<Book> getAll() {        
        return (Collection<Book>) getResultList("SELECT e FROM Book e");
    }

}
