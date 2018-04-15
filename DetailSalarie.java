/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import DAO.ClientDAO;
import DAO.DepenseDAO;
import DAO.NoteFraisDAO;
import DAO.UtilisateurDAO;
import DAO.ValidationDAO;
import Metier.Client;
import Metier.Depense;
import Metier.NoteFrais;
import Metier.Utilisateur;
import Metier.Validation;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author coolye
 */
public class DetailSalarie extends javax.swing.JFrame {

    /**
     * Creates new form DetailSalarie
     */
    public DetailSalarie() throws SQLException {
        initComponents();
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        Utilisateur oneUtilisateur = utilisateurDAO.readOneUtilisateur(1);
        textNom.setText(oneUtilisateur.getNom_Utilisateur());
        textPrenom.setText(oneUtilisateur.getPrenom_Utilisateur());
        textMail.setText(oneUtilisateur.getMail_Utilisateur());
        textAdresse.setText(oneUtilisateur.getAdresse_Utilisateur());
        textCp.setText(oneUtilisateur.getCp_Utilisateur());
        textVille.setText(oneUtilisateur.getVille_Utilisateur());
        textTel.setText(oneUtilisateur.getTelephone_Utilisateur());
        
        NoteFraisDAO notefraisDAO = new NoteFraisDAO();
        ArrayList<NoteFrais> listeNotefrais = notefraisDAO.listNoteFraisById(oneUtilisateur.getId_Utilisateur());
        
        JTable jTable_Frais = TabDetailSalarie;
        DefaultTableModel dm = (DefaultTableModel) jTable_Frais.getModel();
        
        for(NoteFrais oneNotefrais : listeNotefrais){
            ClientDAO clientDAO = new ClientDAO();
            Client oneClient = clientDAO.readOneClient(oneNotefrais.getId_Client());
            
            DepenseDAO depenseDAO = new DepenseDAO();
            float total = depenseDAO.montantTotalNote(oneNotefrais.getId_Notefrais());
            
            ValidationDAO validationDAO = new ValidationDAO();
            ArrayList<Depense> listDepense = depenseDAO.listDepenseByIdNote(oneNotefrais.getId_Notefrais());
            ArrayList<Validation> listValidation = validationDAO.listValidationByIdNode(oneNotefrais.getId_Notefrais());
            String statut;
            if (listDepense.size() == listValidation.size()){
                statut = "Validé";
            } else {
                int ecart = listDepense.size() - listValidation.size();
                statut = "Reste "+ecart+" dépense(s) à valider";
            }
            
            String leTotal = String.valueOf(total);
            String a[] = {oneClient.getNom_Client()+" "+oneClient.getPrenom_Client(), oneNotefrais.getDate_Notefrais(), leTotal, statut};
            dm.addRow(a);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titreVue = new javax.swing.JLabel();
        labNom = new javax.swing.JLabel();
        labPrenom = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabDetailSalarie = new javax.swing.JTable();
        ButRetour = new javax.swing.JButton();
        titreHistorique = new javax.swing.JLabel();
        labMail = new javax.swing.JLabel();
        textNom = new javax.swing.JLabel();
        textPrenom = new javax.swing.JLabel();
        textMail = new javax.swing.JLabel();
        labAdresse = new javax.swing.JLabel();
        labCp = new javax.swing.JLabel();
        labVille = new javax.swing.JLabel();
        labTel = new javax.swing.JLabel();
        textAdresse = new javax.swing.JLabel();
        textCp = new javax.swing.JLabel();
        textVille = new javax.swing.JLabel();
        textTel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titreVue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titreVue.setText("Detail du salarie");

        labNom.setText("Nom :");

        labPrenom.setText("Prenom :");

        TabDetailSalarie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Client", "Date", "Montant", "Statut"
            }
        ));
        jScrollPane1.setViewportView(TabDetailSalarie);

        ButRetour.setText("Retour");
        ButRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButRetourActionPerformed(evt);
            }
        });

        titreHistorique.setText("Historique des notes de frais");

        labMail.setText("Email : ");

        textNom.setText("jLabelNomSalarie");

        textPrenom.setText("jLabelPrenomSalarie");

        textMail.setText("jLabelMailSalarie");

        labAdresse.setText("Adresse :");

        labCp.setText("Code Postal :");

        labVille.setText("Ville :");

        labTel.setText("Telephone :");

        textAdresse.setText("LabelAdresse");

        textCp.setText("LabelCp");

        textVille.setText("LabelVille");

        textTel.setText("LabelTel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(329, 329, 329)
                .addComponent(titreVue)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ButRetour))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(titreHistorique, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(labMail)
                                        .addGap(27, 27, 27))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labPrenom)
                                            .addComponent(labNom))
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textNom, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textMail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textPrenom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labAdresse)
                            .addComponent(labCp)
                            .addComponent(labVille)
                            .addComponent(labTel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textAdresse)
                            .addComponent(textCp)
                            .addComponent(textVille)
                            .addComponent(textTel))
                        .addGap(136, 136, 136)))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(titreVue)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labNom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labPrenom)
                            .addComponent(textPrenom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labMail))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textNom)
                            .addComponent(labAdresse)
                            .addComponent(textAdresse))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labCp)
                            .addComponent(textCp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textMail)
                            .addComponent(labVille)
                            .addComponent(textVille))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labTel)
                    .addComponent(textTel))
                .addGap(14, 14, 14)
                .addComponent(titreHistorique)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(ButRetour)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButRetourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButRetourActionPerformed

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
            java.util.logging.Logger.getLogger(DetailSalarie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailSalarie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailSalarie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailSalarie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DetailSalarie().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DetailSalarie.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButRetour;
    private javax.swing.JTable TabDetailSalarie;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labAdresse;
    private javax.swing.JLabel labCp;
    private javax.swing.JLabel labMail;
    private javax.swing.JLabel labNom;
    private javax.swing.JLabel labPrenom;
    private javax.swing.JLabel labTel;
    private javax.swing.JLabel labVille;
    private javax.swing.JLabel textAdresse;
    private javax.swing.JLabel textCp;
    private javax.swing.JLabel textMail;
    private javax.swing.JLabel textNom;
    private javax.swing.JLabel textPrenom;
    private javax.swing.JLabel textTel;
    private javax.swing.JLabel textVille;
    private javax.swing.JLabel titreHistorique;
    private javax.swing.JLabel titreVue;
    // End of variables declaration//GEN-END:variables
}
