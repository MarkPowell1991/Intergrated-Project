/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopappgui.Frames;

import adminDataModel.DataContainer;
import java.awt.Toolkit;
import javax.swing.DefaultListModel;

/**
 *
 * @author mpowell1
 */
public class FormMainWindow extends javax.swing.JFrame 
{
    
    private DataContainer peopleList;
    private DefaultListModel listModel;
            
    

    /**
     * Creates new form MainFrame
     */
    public FormMainWindow() {
        initComponents();
        
        // Set custom visuals
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/graphics/appIcon.png")));
        this.setLocationRelativeTo(null); // Centre window
        
       // frmLogin objWindow = new frmLogin();
       // objWindow.setVisible(true);  
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enclosingPanel = new javax.swing.JPanel();
        tabNavPanel = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        pIcon = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pSplitter = new javax.swing.JPanel();
        pNavigation = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JButton();
        btnUsers = new javax.swing.JButton();
        btnVenues = new javax.swing.JButton();
        btnEvents = new javax.swing.JButton();
        btnBookings = new javax.swing.JButton();
        btnAdvertisements = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        dynamicPanel = new javax.swing.JPanel();
        panelDashboard = new desktopappgui.Frames.Panels.PanelDashboard();
        panelVenue = new desktopappgui.Frames.Panels.PanelVenue();
        userPanel21 = new desktopappgui.Frames.Panels.PanelCustomer();
        panelEvent = new desktopappgui.Frames.Panels.PanelEvent();
        panelBooking = new desktopappgui.Frames.Panels.PanelBooking();
        panelAdvertisements = new desktopappgui.Frames.Panels.PanelAdvertisements();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicketDirect Administration");
        setMinimumSize(new java.awt.Dimension(600, 600));

        enclosingPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tabNavPanel.setBackground(new java.awt.Color(245, 245, 245));

        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/Icons/buttons/exit.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        pIcon.setBackground(new java.awt.Color(245, 245, 245));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/Icons/panels/main.png"))); // NOI18N

        javax.swing.GroupLayout pIconLayout = new javax.swing.GroupLayout(pIcon);
        pIcon.setLayout(pIconLayout);
        pIconLayout.setHorizontalGroup(
            pIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pIconLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(75, 75, 75))
        );
        pIconLayout.setVerticalGroup(
            pIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pIconLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, 0))
        );

        pSplitter.setBackground(new java.awt.Color(204, 204, 204));
        pSplitter.setPreferredSize(new java.awt.Dimension(4, 100));

        javax.swing.GroupLayout pSplitterLayout = new javax.swing.GroupLayout(pSplitter);
        pSplitter.setLayout(pSplitterLayout);
        pSplitterLayout.setHorizontalGroup(
            pSplitterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        pSplitterLayout.setVerticalGroup(
            pSplitterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pNavigation.setBackground(new java.awt.Color(245, 245, 245));
        pNavigation.setLayout(new java.awt.GridLayout(6, 0, 4, 8));

        btnDashboard.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(32, 32, 32));
        btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/navIcons/dashboard.png"))); // NOI18N
        btnDashboard.setText("DASHBOARD");
        btnDashboard.setBorder(null);
        btnDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDashboard.setIconTextGap(12);
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });
        pNavigation.add(btnDashboard);

        btnUsers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUsers.setForeground(new java.awt.Color(32, 32, 32));
        btnUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/navIcons/users.png"))); // NOI18N
        btnUsers.setText("CUSTOMERS");
        btnUsers.setBorder(null);
        btnUsers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUsers.setIconTextGap(12);
        btnUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersActionPerformed(evt);
            }
        });
        pNavigation.add(btnUsers);

        btnVenues.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVenues.setForeground(new java.awt.Color(32, 32, 32));
        btnVenues.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/navIcons/venues.png"))); // NOI18N
        btnVenues.setText("VENUES");
        btnVenues.setBorder(null);
        btnVenues.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVenues.setIconTextGap(12);
        btnVenues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenuesActionPerformed(evt);
            }
        });
        pNavigation.add(btnVenues);

        btnEvents.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEvents.setForeground(new java.awt.Color(32, 32, 32));
        btnEvents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/navIcons/events.png"))); // NOI18N
        btnEvents.setText("EVENTS");
        btnEvents.setBorder(null);
        btnEvents.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEvents.setIconTextGap(12);
        btnEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEventsActionPerformed(evt);
            }
        });
        pNavigation.add(btnEvents);

        btnBookings.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBookings.setForeground(new java.awt.Color(32, 32, 32));
        btnBookings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/navIcons/bookings.png"))); // NOI18N
        btnBookings.setText("BOOKINGS");
        btnBookings.setBorder(null);
        btnBookings.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBookings.setIconTextGap(12);
        btnBookings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingsActionPerformed(evt);
            }
        });
        pNavigation.add(btnBookings);

        btnAdvertisements.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdvertisements.setForeground(new java.awt.Color(32, 32, 32));
        btnAdvertisements.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/navIcons/advertisements.png"))); // NOI18N
        btnAdvertisements.setText("ADVERTS");
        btnAdvertisements.setToolTipText("");
        btnAdvertisements.setBorder(null);
        btnAdvertisements.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAdvertisements.setIconTextGap(12);
        btnAdvertisements.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdvertisementsActionPerformed(evt);
            }
        });
        pNavigation.add(btnAdvertisements);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 6));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setPreferredSize(new java.awt.Dimension(0, 6));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout tabNavPanelLayout = new javax.swing.GroupLayout(tabNavPanel);
        tabNavPanel.setLayout(tabNavPanelLayout);
        tabNavPanelLayout.setHorizontalGroup(
            tabNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabNavPanelLayout.createSequentialGroup()
                .addGroup(tabNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addGroup(tabNavPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(tabNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabNavPanelLayout.createSequentialGroup()
                                .addGroup(tabNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pNavigation, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                                .addGap(10, 10, 10))
                            .addGroup(tabNavPanelLayout.createSequentialGroup()
                                .addComponent(pIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                .addComponent(pSplitter, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tabNavPanelLayout.setVerticalGroup(
            tabNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabNavPanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(pIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(pNavigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(113, 113, 113)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(pSplitter, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
        );

        dynamicPanel.setLayout(new java.awt.CardLayout());
        dynamicPanel.add(panelDashboard, "card9");
        dynamicPanel.add(panelVenue, "card7");
        dynamicPanel.add(userPanel21, "card8");
        dynamicPanel.add(panelEvent, "card10");
        dynamicPanel.add(panelBooking, "card11");
        dynamicPanel.add(panelAdvertisements, "card7");

        javax.swing.GroupLayout enclosingPanelLayout = new javax.swing.GroupLayout(enclosingPanel);
        enclosingPanel.setLayout(enclosingPanelLayout);
        enclosingPanelLayout.setHorizontalGroup(
            enclosingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enclosingPanelLayout.createSequentialGroup()
                .addComponent(tabNavPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dynamicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1073, Short.MAX_VALUE))
        );
        enclosingPanelLayout.setVerticalGroup(
            enclosingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dynamicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
            .addComponent(tabNavPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(enclosingPanel, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBorder(null);
        jMenuBar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jMenu1.setBorder(null);
        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersActionPerformed
        dynamicPanel.removeAll();
        dynamicPanel.add(userPanel21);
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
    }//GEN-LAST:event_btnUsersActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        new FormLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnAdvertisementsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdvertisementsActionPerformed
        dynamicPanel.removeAll();
        dynamicPanel.add(panelAdvertisements);
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
    }//GEN-LAST:event_btnAdvertisementsActionPerformed

    private void btnBookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingsActionPerformed
        dynamicPanel.removeAll();
        dynamicPanel.add(panelBooking);
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
    }//GEN-LAST:event_btnBookingsActionPerformed

    private void btnEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventsActionPerformed
        dynamicPanel.removeAll();
        dynamicPanel.add(panelEvent);
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
    }//GEN-LAST:event_btnEventsActionPerformed

    private void btnVenuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenuesActionPerformed
        dynamicPanel.removeAll();
        dynamicPanel.add(panelVenue);
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
    }//GEN-LAST:event_btnVenuesActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        dynamicPanel.removeAll();
        dynamicPanel.add(panelDashboard);
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
    }//GEN-LAST:event_btnDashboardActionPerformed

    
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
            java.util.logging.Logger.getLogger(FormMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FormMainWindow().setVisible(true);
            }
        });
        DataContainer.disposeInstance();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdvertisements;
    private javax.swing.JButton btnBookings;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnEvents;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUsers;
    private javax.swing.JButton btnVenues;
    private javax.swing.JPanel dynamicPanel;
    private javax.swing.JPanel enclosingPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel pIcon;
    private javax.swing.JPanel pNavigation;
    private javax.swing.JPanel pSplitter;
    private desktopappgui.Frames.Panels.PanelAdvertisements panelAdvertisements;
    private desktopappgui.Frames.Panels.PanelBooking panelBooking;
    private desktopappgui.Frames.Panels.PanelDashboard panelDashboard;
    private desktopappgui.Frames.Panels.PanelEvent panelEvent;
    private desktopappgui.Frames.Panels.PanelVenue panelVenue;
    private javax.swing.JPanel tabNavPanel;
    private desktopappgui.Frames.Panels.PanelCustomer userPanel21;
    // End of variables declaration//GEN-END:variables
}
