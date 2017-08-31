/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Iterator;
import library.data.AuthorRepository;
import library.data.BookRepository;
import library.model.Author;
import library.model.Book;
import library.ui.helpers.AuthorHelper;

/**
 *
 * @author mehdinh
 */
public class FBookDialog extends java.awt.Dialog {

    /**
     * Creates new form FBookDialog
     */
    public FBookDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setResizable(false);
        setTitle("Podaci o knjizi");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        loadData(0L);
    }

    public FBookDialog(java.awt.Frame parent, boolean modal, Long id) {
        super(parent, modal);
        initComponents();

        setResizable(false);
        setTitle("Podaci o knjizi");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        loadData(id);
    }
    
    private Book book;
    private void loadData(Long id) {
        if (id == 0L) {
            this.book = new Book();
        } else {
            BookRepository bookRepository = new BookRepository();
            this.book = bookRepository.getById(id);
            
            this.nameField.setText(book.getName());                    
            authorsTable.setModel(AuthorHelper.getTableModel(book.getAuthors()));
        }
        
        allAuthorsTable.setModel(AuthorHelper.getTableModel());
    }
    
    private void saveData() {
        BookRepository bookRepository = new BookRepository();
        
        if (book.getId() == 0L) {
            bookRepository.add(book);
        } else {
            
            bookRepository.update(book);
        }            
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        isbnLabel = new javax.swing.JLabel();
        isbnField = new javax.swing.JTextField();
        authorsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        authorsTable = new javax.swing.JTable();
        addExistingAuthorButton = new javax.swing.JButton();
        removeExistingAuthorButton = new javax.swing.JButton();
        addAuthorButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        allAuthorsTable = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        nameLabel.setText("Naziv knjige");

        isbnLabel.setText("ISBN");

        authorsLabel.setText("Autori");

        authorsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(authorsTable);

        addExistingAuthorButton.setText("<");
        addExistingAuthorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExistingAuthorButtonActionPerformed(evt);
            }
        });

        removeExistingAuthorButton.setText(">");
        removeExistingAuthorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeExistingAuthorButtonActionPerformed(evt);
            }
        });

        addAuthorButton.setText("Add author");
        addAuthorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAuthorButtonActionPerformed(evt);
            }
        });

        allAuthorsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(allAuthorsTable);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Odustani");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(isbnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(isbnField, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(addExistingAuthorButton, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addComponent(removeExistingAuthorButton, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addComponent(addAuthorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(authorsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(isbnLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isbnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(authorsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(addExistingAuthorButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeExistingAuthorButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addAuthorButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void addExistingAuthorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExistingAuthorButtonActionPerformed
        // TODO add your handling code here:
        for (Iterator<Author> i = book.getAuthors().iterator(); i.hasNext();) {
            Author entity = i.next();
            if (entity.getId().toString() == (String)allAuthorsTable.getValueAt(allAuthorsTable.getSelectedRow(), 0)) {
                return;
            }
        }

        AuthorRepository authorRepository = new AuthorRepository();
        Author author = authorRepository.getById(Long.parseLong((String)allAuthorsTable.getValueAt(allAuthorsTable.getSelectedRow(), 0)));
        book.getAuthors().add(author);
        authorsTable.setModel(AuthorHelper.getTableModel(book.getAuthors()));
        saveData();
        loadData(1L);
    }//GEN-LAST:event_addExistingAuthorButtonActionPerformed

    private void removeExistingAuthorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeExistingAuthorButtonActionPerformed
        // TODO add your handling code here:
        book.getAuthors().remove(authorsTable.getSelectedRow());
        authorsTable.setModel(AuthorHelper.getTableModel(book.getAuthors()));
        saveData();
        loadData(1L);
    }//GEN-LAST:event_removeExistingAuthorButtonActionPerformed

    private void addAuthorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAuthorButtonActionPerformed
        FAuthorDialog fAuthor = new FAuthorDialog(null, true);
        fAuthor.setVisible(true);
    }//GEN-LAST:event_addAuthorButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        saveData();
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FBookDialog dialog = new FBookDialog(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAuthorButton;
    private javax.swing.JButton addExistingAuthorButton;
    private javax.swing.JTable allAuthorsTable;
    private javax.swing.JLabel authorsLabel;
    private javax.swing.JTable authorsTable;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField isbnField;
    private javax.swing.JLabel isbnLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton removeExistingAuthorButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}