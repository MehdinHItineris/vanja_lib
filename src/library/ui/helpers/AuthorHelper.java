/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.ui.helpers;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import library.data.AuthorRepository;
import library.model.Author;
import library.model.Book;

/**
 *
 * @author mehdinh
 */
public class AuthorHelper {    
    public static DefaultTableModel getTableModel(Collection<Author> list) {
        Vector dataVector = new Vector();
        Vector columnsVector = new Vector();
                
        for (Iterator<Author> i = list.iterator(); i.hasNext();) {
            Author entity = i.next();
            Vector entityVector = new Vector();
            entityVector.add(entity.getId().toString());
            entityVector.add(entity.getFirstName());
            entityVector.add(entity.getLastName());
            dataVector.add(entityVector);
        }

        columnsVector.add("Id");
        columnsVector.add("Ime");
        columnsVector.add("Prezime");        
        
        return new DefaultTableModel(dataVector, columnsVector);
    }
    
    public static DefaultTableModel getTableModel() {
        AuthorRepository repository = new AuthorRepository();
        Collection<Author> list = repository.getAll();
        return AuthorHelper.getTableModel(list);
    }      
}
