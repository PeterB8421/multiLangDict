/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiLangDict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author student
 */
public class mainWindow extends javax.swing.JFrame {

	private final DefaultTableModel model;
	private Connection databaseConnection;

	/**
	 * Creates new form mainWindow
	 */
	public mainWindow() {
		initComponents();
		model = (DefaultTableModel) table.getModel();
		if (!dbConnected()) {
			System.exit(0);
		}
		this.listData(this.getAllRecords());
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        insert = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchedString = new javax.swing.JTextField();
        find = new javax.swing.JButton();
        addLangBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vícejazyčný slovník");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "cs", "en"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.PAGE_START);

        insert.setText("Nový");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        update.setText("Změnit");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("Smazat");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel1.setText("Vyhledávání:");

        find.setText("Hledat");
        find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findActionPerformed(evt);
            }
        });

        addLangBtn.setText("Přidat jazyk");
        addLangBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLangBtnActionPerformed(evt);
            }
        });

        jButton2.setText("Odebrat jazyk");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(insert)
                                .addGap(18, 18, 18)
                                .addComponent(update)
                                .addGap(18, 18, 18)
                                .addComponent(delete))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(searchedString, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(find))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addLangBtn)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(393, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insert)
                    .addComponent(update)
                    .addComponent(delete))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchedString, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(find))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addLangBtn)
                    .addComponent(jButton2))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
		String[] slova = {"", ""};
		insertWord insertWord = new insertWord(this, true, slova);
		if (insertWord.showDialog().equalsIgnoreCase("OK")) {
			insertRecord(insertWord.getEnglish(), insertWord.getCzech());
		}
		listData(this.getAllRecords());
    }//GEN-LAST:event_insertActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
		int id = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
		String[] words = {table.getModel().getValueAt(table.getSelectedRow(), 1).toString(),
			table.getModel().getValueAt(table.getSelectedRow(), 2).toString()};
		insertWord insertWord = new insertWord(this, true, words);
		if (insertWord.showDialog().equalsIgnoreCase("OK")) {
			updateRecord(id, insertWord.getEnglish(), insertWord.getCzech());
		}
		listData(this.getAllRecords());
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
		int id = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
		deleteRecord(id);
		listData(this.getAllRecords());
    }//GEN-LAST:event_deleteActionPerformed

    private void findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findActionPerformed
		String keyWords = searchedString.getText();
		try {
			ResultSet data = searchEn(keyWords);
			data.next();
			int id = data.getInt(1);
			String czech = data.getString("cs");
			String english = data.getString("en");
			JOptionPane.showMessageDialog(this, "Anglicky: \"" + english + "\"\nČesky: \"" + czech + "\"", "Hledané slovo", JOptionPane.PLAIN_MESSAGE);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Záznam nebyl nalezen","Chyba", JOptionPane.ERROR_MESSAGE);
		}

    }//GEN-LAST:event_findActionPerformed

    private void addLangBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLangBtnActionPerformed
		String lang = JOptionPane.showInputDialog(this, "Zadejte zkratku jazyka");
    }//GEN-LAST:event_addLangBtnActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new mainWindow().setVisible(true);
			}
		});
	}

	private boolean dbConnected() {
		try {
			databaseConnection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/multilangdict?useUnicode=true&characterEncoding=utf-8", "mld", "multilangdict");
			return true;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Nepodařilo se připojit k databázi. Java hlásí chybu \"" + ex + "\"", "Chyba", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	private ResultSet getAllRecords() {
		ResultSet results = null;
		try {
			PreparedStatement dotaz = databaseConnection.prepareStatement("SELECT * FROM words");
			results = dotaz.executeQuery();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Chyba při komunikaci s databází.", "Chyba", JOptionPane.ERROR_MESSAGE);
		}
		return results;
	}

	private void listData(ResultSet data) {
		/* Odstranění všech řádků z tabulky */
		for (int i = table.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		try {
			/* Vložení řádků do tabulky a jejich naplnění daty ze získané dynamické sady */
			while (data.next()) {
				int id = data.getInt(1);
				String cesky = data.getString("cs");
				String anglicky = data.getString("en");
				model.addRow(new Object[]{id, cesky, anglicky});
			}
			/* Zapnutí nebo vypnutí tlačítek Změnit a Smazat v závislosti na existenci záznamů
 (řádků) v tabulce */
			if (table.getRowCount() > 0) {
				table.setRowSelectionInterval(0, 0);
				/* Označení prvního řádku tabulky */
				update.setEnabled(true);
				delete.setEnabled(true);
			} else {
				update.setEnabled(false);
				delete.setEnabled(false);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Chyba při komunikaci s databází",
					"Chyba", JOptionPane.ERROR_MESSAGE);
		}
	}

	private int insertRecord(String enWord, String csWord) {
		int numRows = 0;
		try {
			PreparedStatement query
					= databaseConnection.prepareStatement("INSERT INTO words (cs, en) VALUES (?, ?)");
			query.setString(1, csWord);
			query.setString(2, enWord);
			numRows = query.executeUpdate();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Chyba při komunikaci s databází", "Chyba", JOptionPane.ERROR_MESSAGE);
		}
		return numRows;
	}

	private int updateRecord(int id, String enWord, String csWord) {
		int numRows = 0;
		try {
			PreparedStatement query
					= databaseConnection.prepareStatement("UPDATE words SET cs=?, en=? WHERE id=?");
			query.setString(1, csWord);
			query.setString(2, enWord);
			query.setInt(3, id);
			numRows = query.executeUpdate();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Chyba při komunikaci s databází", "Chyba", JOptionPane.ERROR_MESSAGE);
		}
		return numRows;
	}

	private int deleteRecord(int id) {
		int numRows = 0;
		try {
			PreparedStatement query = databaseConnection.prepareStatement("DELETE FROM words WHERE id =  ?");
			query.setInt(1, id);
			numRows = query.executeUpdate();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Chyba při komunikaci s databází", "Chyba", JOptionPane.ERROR_MESSAGE);
		}
		return numRows;
	}

	private ResultSet searchEn(String enWord) {
		ResultSet results = null;
		try {
			PreparedStatement query = databaseConnection.prepareStatement("SELECT * FROM words WHERE en =  ?");
			query.setString(1, enWord);
			results = query.executeQuery();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Chyba při komunikaci s databází", "Chyba", JOptionPane.ERROR_MESSAGE);
		}
		return results;
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addLangBtn;
    private javax.swing.JButton delete;
    private javax.swing.JButton find;
    private javax.swing.JButton insert;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchedString;
    private javax.swing.JTable table;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
