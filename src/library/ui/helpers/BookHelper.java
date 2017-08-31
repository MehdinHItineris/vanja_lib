/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.ui.helpers;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import library.data.BookRepository;
import library.model.Author;
import library.model.Book;

/**
 *
 * @author mehdinh
 */
public class BookHelper {
    public static DefaultTableModel getTableModel() {
        Vector dataVector = new Vector();
        Vector columnsVector = new Vector();
                
        BookRepository repository = new BookRepository();
        Collection<Book> list = repository.getAll();
        
        for (Iterator<Book> i = list.iterator(); i.hasNext();) {
            Book entity = i.next();
            Vector entityVector = new Vector();
            entityVector.add(entity.getId().toString());
            entityVector.add(entity.getIsbn());
            entityVector.add(entity.getName());
            
            String authorsText = "";
            for (Iterator<Author> j = entity.getAuthors().iterator(); j.hasNext();) {
                authorsText += (j.next()).getFullName() + "; ";
            }
            entityVector.add(authorsText);
            dataVector.add(entityVector);
        }

        columnsVector.add("Id");
        columnsVector.add("ISBN");
        columnsVector.add("Name");
        columnsVector.add("Autori");
        
        return new DefaultTableModel(dataVector, columnsVector);
    }       
    
}
