package library.ui.helpers;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import library.data.LibrarianRepository;
import library.model.Librarian;

public class LibrarianHelper {
    public static DefaultTableModel getTableModel() {
        Vector dataVector = new Vector();
        Vector columnsVector = new Vector();
                
        LibrarianRepository repository = new LibrarianRepository();
        Collection<Librarian> list = repository.getAll();
        
        for (Iterator<Librarian> i = list.iterator(); i.hasNext();) {
            Librarian entity = i.next();
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
}
