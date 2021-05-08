/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieLibrary;



import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author batko
 */
public class MovieLibrary extends javax.swing.JFrame {
    
    private static final String username ="filmiarz";
    private static final String password ="filmiarz";
    private static final String conn ="jdbc:sqlserver://localhost\\sqlexpress;databaseName=MovieLibrary";
            
    Connection polaczenie = null;
    PreparedStatement skladnia = null;
    ResultSet rezultat = null;
    int q, i, id, delete;
    
    
    public MovieLibrary() {
        initComponents();
    }

    public void aktualizujBaze(){
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Zaladowanie sterownika
            polaczenie = DriverManager.getConnection(conn,username,password); //Polaczenie z baza danych przy uzyciu DriverManagera. Zmienne sa zdeklarowane wyzej aby kod wyglądał przejrzyściej.
            skladnia = polaczenie.prepareStatement("{call dbo.pobierzDane}");  //Uzycie procedury w celu zabezpieczenia przed SQL injection
            //skladnia sluzy do wykonywania zapytań w bazie danych. 
            rezultat = skladnia.executeQuery(); //executeQuery dla selectów, executeBatch dla insertów. 
            
            //NIE POWINNO SIE JAWNIE PRZEKAZYWAC ZAPYTAN ZE WZGLEDU NA NIEBEZPIECZENSTWO SQL injection. 
            
            ResultSetMetaData stData = rezultat.getMetaData();
            
            q = stData.getColumnCount();
            
            DefaultTableModel Tabela = (DefaultTableModel) jTable1.getModel();
                    Tabela.setRowCount(0);

                    
            while(rezultat.next()){
                Vector columnData = new Vector();  //Jezeli rezultat odczytuje kolejny rekord jest on przekazywany do tabeli
                //Vectory sa dynamicznymi tabelami które mogą się rozszerzać i zmniejszać. W przeciwieńśtwie do tablicy nie występuje limit miejsca.
                //Tylko jeden wątek może uzyskać dostęp do kodu. 
                for (i = 1; i < q; i++)
                {
                    columnData.add(rezultat.getInt("ID"));
                    columnData.add(rezultat.getString("nazwa"));
                    columnData.add(rezultat.getString("rezyser"));
                    columnData.add(rezultat.getString("gatunek"));
                    columnData.add(rezultat.getString("dostepny"));
                    
                }
                
                Tabela.addRow(columnData);
                
                //Nie uzywamy ze ArrayList tylko Vectora aby dynamicznie poszerzać wiersze w tabeli.
            }
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Błąd " +e.getMessage(),
                    "Błąd aplikacji", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtxtID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtNazwa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxtRezyser = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtxtGatunek = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtxtDostepny = new javax.swing.JTextField();
        jbtnUsun = new javax.swing.JButton();
        jbtnDodaj = new javax.swing.JButton();
        jbtnEdytuj = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 3, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 44, 80, 40));

        jtxtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtIDActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 220, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Nazwa ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 80, 40));
        jPanel1.add(jtxtNazwa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 220, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Reżyser");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 80, 40));

        jtxtRezyser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtRezyserActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtRezyser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 220, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Gatunek");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 80, 40));
        jPanel1.add(jtxtGatunek, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 220, 50));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Dostepny");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 80, 40));
        jPanel1.add(jtxtDostepny, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 220, 50));

        jbtnUsun.setBackground(new java.awt.Color(0, 102, 102));
        jbtnUsun.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtnUsun.setForeground(new java.awt.Color(255, 255, 255));
        jbtnUsun.setText("Usuń");
        jbtnUsun.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnUsun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUsunActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnUsun, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 90, 70));

        jbtnDodaj.setBackground(new java.awt.Color(0, 102, 102));
        jbtnDodaj.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtnDodaj.setForeground(new java.awt.Color(255, 255, 255));
        jbtnDodaj.setText("Dodaj");
        jbtnDodaj.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDodajActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnDodaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 90, 70));

        jbtnEdytuj.setBackground(new java.awt.Color(0, 102, 102));
        jbtnEdytuj.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtnEdytuj.setForeground(new java.awt.Color(255, 255, 255));
        jbtnEdytuj.setText("Edytuj");
        jbtnEdytuj.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnEdytuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEdytujActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnEdytuj, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 90, 70));

        jButton1.setText("jButton1");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(921, 429, 60, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 390, 490));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 3, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nazwa", "Reżyser", "Gatunek", "Dostepny"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 17, 370, 750));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 390, 780));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel6.setBackground(new java.awt.Color(0, 102, 102));
        jLabel6.setFont(new java.awt.Font("Verdana", 0, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("<html>\nMovie <p>\nLibrary");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 390, 280));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtIDActionPerformed

    private void jtxtRezyserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtRezyserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtRezyserActionPerformed

    private void jbtnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDodajActionPerformed
     try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Zaladowanie sterownika
            polaczenie = DriverManager.getConnection(conn,username,password); //Polaczenie z baza danych przy uzyciu DriverManagera. Zmienne sa zdeklarowane wyzej aby kod wyglądał przejrzyściej.
            skladnia = polaczenie.prepareStatement("insert into movies(ID,nazwa,rezyser,gatunek,dostepny)values(?,?,?,?,?)");
        
            skladnia.setString(1, jtxtID.getText());
            skladnia.setString(2, jtxtNazwa.getText());
            skladnia.setString(3, jtxtRezyser.getText());
            skladnia.setString(4, jtxtGatunek.getText());
            skladnia.setString(5, jtxtDostepny.getText());
            
            skladnia.executeUpdate();
            JOptionPane.showMessageDialog(this, "Dodano Film");
            aktualizujBaze();
        }
     
        catch(ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(java.sql.Connection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch(SQLException ex) {
                        java.util.logging.Logger.getLogger(java.sql.Connection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
     
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnDodajActionPerformed

    private void jbtnEdytujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEdytujActionPerformed
        DefaultTableModel Tabela = (DefaultTableModel) jTable1.getModel();
          int wybranyRzad = jTable1.getSelectedRow();
          
        try
        {
            id = Integer.parseInt(Tabela.getValueAt(wybranyRzad, 0).toString());
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Zaladowanie sterownika
            polaczenie = DriverManager.getConnection(conn,username,password); //Polaczenie z baza danych przy uzyciu DriverManagera. Zmienne sa zdeklarowane wyzej aby kod wyglądał przejrzyściej.
            skladnia = polaczenie.prepareStatement("update movies set ID =?, nazwa=?, rezyser=?, gatunek=?, dostepny=?");
        
            skladnia.setString(1, jtxtID.getText());
            skladnia.setString(2, jtxtNazwa.getText());
            skladnia.setString(3, jtxtRezyser.getText());
            skladnia.setString(4, jtxtGatunek.getText());
            skladnia.setString(5, jtxtDostepny.getText());
            
            skladnia.executeUpdate();
            JOptionPane.showMessageDialog(this, "Zaktualizowano Film");
            aktualizujBaze();
        }
     
        catch(ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(java.sql.Connection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        }
        
    }//GEN-LAST:event_jbtnEdytujActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
  
        DefaultTableModel Tabela = (DefaultTableModel) jTable1.getModel();
          int wybranyRzad = jTable1.getSelectedRow();  
          
          jtxtID.setText(Tabela.getValueAt(wybranyRzad, 0).toString());
          jtxtNazwa.setText(Tabela.getValueAt(wybranyRzad, 1).toString());
          jtxtRezyser.setText(Tabela.getValueAt(wybranyRzad, 2).toString());
          jtxtGatunek.setText(Tabela.getValueAt(wybranyRzad, 3).toString());
          jtxtDostepny.setText(Tabela.getValueAt(wybranyRzad, 4).toString());
          
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void jbtnUsunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUsunActionPerformed

         DefaultTableModel Tabela = (DefaultTableModel) jTable1.getModel();
          int wybranyRzad = jTable1.getSelectedRow();
          
          try
          {
              id = Integer.parseInt(Tabela.getValueAt(wybranyRzad, 0).toString());
              
              delete = JOptionPane.showConfirmDialog(null,"Potwierdź, jeśli chcesz usunąć film",
                      "Uwaga",JOptionPane.YES_NO_OPTION);
              if (delete==JOptionPane.YES_OPTION)
              {
                  
                       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Zaladowanie sterownika
            polaczenie = DriverManager.getConnection(conn,username,password); //Polaczenie z baza danych przy uzyciu DriverManagera. Zmienne sa zdeklarowane wyzej aby kod wyglądał przejrzyściej.
            skladnia = polaczenie.prepareStatement("delete from movies where id=?");
            
            skladnia.setInt(1,id);
            skladnia.executeUpdate();
           JOptionPane.showMessageDialog(this, "Film poprawnie usunięty");
           aktualizujBaze();
           
           jtxtID.setText("");
           jtxtID.requestFocus();
           jtxtNazwa.setText("");
           jtxtRezyser.setText("");
           jtxtGatunek.setText("");
           jtxtDostepny.setText("");
              }
          }
          
          catch (ClassNotFoundException | SQLException ex) {
              java.util.logging.Logger.getLogger(java.sql.Connection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);                     
              System.err.println(ex);
        
          }        
    }//GEN-LAST:event_jbtnUsunActionPerformed

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
            java.util.logging.Logger.getLogger(MovieLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovieLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovieLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovieLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovieLibrary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtnDodaj;
    private javax.swing.JButton jbtnEdytuj;
    private javax.swing.JButton jbtnUsun;
    private javax.swing.JTextField jtxtDostepny;
    private javax.swing.JTextField jtxtGatunek;
    private javax.swing.JTextField jtxtID;
    private javax.swing.JTextField jtxtNazwa;
    private javax.swing.JTextField jtxtRezyser;
    // End of variables declaration//GEN-END:variables
}
