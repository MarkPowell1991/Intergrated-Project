/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopappgui.Frames;

import adminDataModel.DataContainer;
import adminDataModel.Event;
import adminDataModel.EventType;
import adminDataModel.Genre;
import validation.*;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author damdirtyape
 */
public class FormAddTask extends javax.swing.JFrame {

    DataContainer admin = DataContainer.getInstance();
    DefaultComboBoxModel<Genre> genreComboModel;
    DefaultComboBoxModel<EventType> typeComboModel;

    /**
     * Creates new form AddUserFrame
     */
    public FormAddTask() {
        Genre[] genres = {Genre.Classical, Genre.Comedy, Genre.Drama, Genre.Pop, Genre.Rock, Genre.Romantic};
        genreComboModel = new DefaultComboBoxModel(genres);
        EventType[] types = {EventType.Concert, EventType.Movie, EventType.Musical, EventType.Sport, EventType.Theatre};
        typeComboModel = new DefaultComboBoxModel(types);
        initComponents();

        // Set custom visuals
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/graphics/addForm.png")));
        this.setLocationRelativeTo(null); // Centre window

        // <editor-fold defaultstate="collapsed" desc="Input Validation">
        txtTaskName.setInputVerifier(new AlphaNumericalValidator(txtTaskName, 1, 35, false));
        txtDescription.setInputVerifier(new TextAreaAlphaNumericalValidator(txtDescription, 1, 225, false));
        // </editor-fold>
    }

    private void createTask() {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pForm = new javax.swing.JPanel();
        pEventDetails = new javax.swing.JPanel();
        pHeader1 = new javax.swing.JPanel();
        lbNewTask = new javax.swing.JLabel();
        pContent1 = new javax.swing.JPanel();
        pLabels1 = new javax.swing.JPanel();
        lbEventName = new javax.swing.JLabel();
        lbDuration = new javax.swing.JLabel();
        pInputs1 = new javax.swing.JPanel();
        txtTaskName = new javax.swing.JTextField();
        jdcDueDate = new com.toedter.calendar.JDateChooser();
        pLabels1a = new javax.swing.JPanel();
        lbDescription = new javax.swing.JLabel();
        pInputs1a = new javax.swing.JPanel();
        spDescription = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        pConfirmArea = new javax.swing.JPanel();
        pInputs = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Task");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        pForm.setBackground(new java.awt.Color(255, 255, 255));
        pForm.setForeground(new java.awt.Color(204, 204, 204));

        pEventDetails.setBackground(new java.awt.Color(255, 255, 255));

        pHeader1.setBackground(new java.awt.Color(255, 255, 255));

        lbNewTask.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbNewTask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/contact.png"))); // NOI18N
        lbNewTask.setText("New Task");
        lbNewTask.setToolTipText("");

        javax.swing.GroupLayout pHeader1Layout = new javax.swing.GroupLayout(pHeader1);
        pHeader1.setLayout(pHeader1Layout);
        pHeader1Layout.setHorizontalGroup(
            pHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbNewTask)
        );
        pHeader1Layout.setVerticalGroup(
            pHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbNewTask)
        );

        pContent1.setBackground(new java.awt.Color(255, 255, 255));
        pContent1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        pLabels1.setBackground(new java.awt.Color(255, 255, 255));
        pLabels1.setLayout(new java.awt.GridLayout(2, 1, 11, 11));

        lbEventName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEventName.setForeground(new java.awt.Color(42, 42, 42));
        lbEventName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbEventName.setText("Task Name*");
        pLabels1.add(lbEventName);

        lbDuration.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbDuration.setForeground(new java.awt.Color(42, 42, 42));
        lbDuration.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDuration.setText("Date Due");
        pLabels1.add(lbDuration);

        pInputs1.setBackground(new java.awt.Color(255, 255, 255));
        pInputs1.setLayout(new java.awt.GridLayout(2, 0, 0, 11));

        txtTaskName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTaskName.setName("Task Name"); // NOI18N
        pInputs1.add(txtTaskName);

        jdcDueDate.setToolTipText("");
        jdcDueDate.setDate(new Date());
        jdcDueDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jdcDueDate.setMinSelectableDate(new java.util.Date(-2208985112000L));
        pInputs1.add(jdcDueDate);

        pLabels1a.setBackground(new java.awt.Color(255, 255, 255));
        pLabels1a.setLayout(new java.awt.GridLayout(1, 0));

        lbDescription.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbDescription.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDescription.setText("Description*");
        pLabels1a.add(lbDescription);

        pInputs1a.setBackground(new java.awt.Color(255, 255, 255));
        pInputs1a.setLayout(new java.awt.GridLayout(1, 0));

        spDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(171, 173, 179)));

        txtDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDescription.setRows(5);
        txtDescription.setName("Description"); // NOI18N
        spDescription.setViewportView(txtDescription);

        pInputs1a.add(spDescription);

        javax.swing.GroupLayout pContent1Layout = new javax.swing.GroupLayout(pContent1);
        pContent1.setLayout(pContent1Layout);
        pContent1Layout.setHorizontalGroup(
            pContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContent1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pLabels1a, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pLabels1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pInputs1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(pInputs1a, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pContent1Layout.setVerticalGroup(
            pContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContent1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pLabels1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pInputs1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pContent1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(pInputs1a, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pContent1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pLabels1a, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pEventDetailsLayout = new javax.swing.GroupLayout(pEventDetails);
        pEventDetails.setLayout(pEventDetailsLayout);
        pEventDetailsLayout.setHorizontalGroup(
            pEventDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEventDetailsLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pEventDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pContent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        pEventDetailsLayout.setVerticalGroup(
            pEventDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEventDetailsLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pContent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pConfirmArea.setBackground(new java.awt.Color(242, 242, 242));
        pConfirmArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        pInputs.setBackground(new java.awt.Color(242, 242, 242));
        pInputs.setLayout(new java.awt.GridLayout(1, 1, 6, 4));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/tick.png"))); // NOI18N
        btnSave.setText("Create");
        btnSave.setIconTextGap(1);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        pInputs.add(btnSave);

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/cancel.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setIconTextGap(1);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        pInputs.add(btnCancel);

        javax.swing.GroupLayout pConfirmAreaLayout = new javax.swing.GroupLayout(pConfirmArea);
        pConfirmArea.setLayout(pConfirmAreaLayout);
        pConfirmAreaLayout.setHorizontalGroup(
            pConfirmAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pConfirmAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pInputs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pConfirmAreaLayout.setVerticalGroup(
            pConfirmAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pConfirmAreaLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(pInputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout pFormLayout = new javax.swing.GroupLayout(pForm);
        pForm.setLayout(pFormLayout);
        pFormLayout.setHorizontalGroup(
            pFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pConfirmArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pEventDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        pFormLayout.setVerticalGroup(
            pFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pEventDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pConfirmArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        createTask();
        dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormAddTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAddTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAddTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAddTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAddTask().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private com.toedter.calendar.JDateChooser jdcDueDate;
    private javax.swing.JLabel lbDescription;
    private javax.swing.JLabel lbDuration;
    private javax.swing.JLabel lbEventName;
    private javax.swing.JLabel lbNewTask;
    private javax.swing.JPanel pConfirmArea;
    private javax.swing.JPanel pContent1;
    private javax.swing.JPanel pEventDetails;
    private javax.swing.JPanel pForm;
    private javax.swing.JPanel pHeader1;
    private javax.swing.JPanel pInputs;
    private javax.swing.JPanel pInputs1;
    private javax.swing.JPanel pInputs1a;
    private javax.swing.JPanel pLabels1;
    private javax.swing.JPanel pLabels1a;
    private javax.swing.JScrollPane spDescription;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtTaskName;
    // End of variables declaration//GEN-END:variables

}