/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopappgui.Frames.Panels;

import adminDataModel.DataContainer;
import adminDataModel.Customer;
import desktopappgui.Frames.FormAddBooking;
import desktopappgui.Frames.FormAddCustomer;
import desktopappgui.Frames.FormEditCustomer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import utilities.IObserver;

/**
 *
 * @author Markus
 */
public class PanelCustomer extends javax.swing.JPanel implements IObserver {

    private DataContainer peopleList;
    private DefaultTableModel tableModel;
    private List<Customer> tempCustomerList;

    public PanelCustomer() {
        peopleList = DataContainer.getInstance();
        peopleList.registerObserver(this);
        fillList();
        initComponents();
        tableModel = (DefaultTableModel) jTableUsers.getModel();
        fillTable();
        ListSelectionModel selectionModel = jTableUsers.getSelectionModel();
        selectionModel.addListSelectionListener(jTableUsers);
    }

    private void fillList() {
        tempCustomerList = new ArrayList();
        for (Customer objCurrItem : peopleList.getPeopleList()) {
            if (objCurrItem.getPassword() != null) {
                tempCustomerList.add(objCurrItem);
            }
        }
    }

    private void fillTable() {
        tableModel.setRowCount(0);
        for (Customer objCurrItem : tempCustomerList) {
            tableModel.addRow(objCurrItem.toTableData());
        }
    }

    private void filter(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
        jTableUsers.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + query));
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
        pMain = new javax.swing.JPanel();
        pContent = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsers = new javax.swing.JTable();
        pSearch = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        pControls = new javax.swing.JPanel();
        btnAddUser = new javax.swing.JButton();
        btnEditUser = new javax.swing.JButton();
        btnMakeBooking = new javax.swing.JButton();
        pHeading = new javax.swing.JPanel();
        lbHeading = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(900, 650));

        pForm.setBackground(new java.awt.Color(118, 215, 154));

        pMain.setBackground(new java.awt.Color(250, 250, 250));

        pContent.setBackground(new java.awt.Color(250, 250, 250));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        jTableUsers.setAutoCreateRowSorter(true);
        jTableUsers.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Date of Birth", "Email", "Mobile", "Address", "City"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableUsers.setGridColor(new java.awt.Color(255, 255, 255));
        jTableUsers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableUsers.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableUsers);
        if (jTableUsers.getColumnModel().getColumnCount() > 0) {
            jTableUsers.getColumnModel().getColumn(0).setResizable(false);
            jTableUsers.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTableUsers.getColumnModel().getColumn(1).setResizable(false);
            jTableUsers.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        pSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pSearch.setLayout(new javax.swing.BoxLayout(pSearch, javax.swing.BoxLayout.LINE_AXIS));

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        pSearch.add(txtSearch);

        btnSearch.setBackground(new java.awt.Color(153, 153, 153));
        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/Icons/buttons/search.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        pSearch.add(btnSearch);

        pControls.setBackground(new java.awt.Color(250, 250, 250));

        btnAddUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/Icons/buttons/add.png"))); // NOI18N
        btnAddUser.setText("Create New");
        btnAddUser.setBorder(null);
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        btnEditUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/Icons/buttons/edit.png"))); // NOI18N
        btnEditUser.setText("Edit Item");
        btnEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUserActionPerformed(evt);
            }
        });

        btnMakeBooking.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMakeBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/booking.png"))); // NOI18N
        btnMakeBooking.setBorder(null);
        btnMakeBooking.setLabel("Make Booking");
        btnMakeBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeBookingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pControlsLayout = new javax.swing.GroupLayout(pControls);
        pControls.setLayout(pControlsLayout);
        pControlsLayout.setHorizontalGroup(
            pControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pControlsLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMakeBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pControlsLayout.setVerticalGroup(
            pControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pControlsLayout.createSequentialGroup()
                .addGroup(pControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMakeBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pContentLayout = new javax.swing.GroupLayout(pContent);
        pContent.setLayout(pContentLayout);
        pContentLayout.setHorizontalGroup(
            pContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
            .addComponent(pSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pControls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pContentLayout.setVerticalGroup(
            pContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContentLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pControls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pMainLayout = new javax.swing.GroupLayout(pMain);
        pMain.setLayout(pMainLayout);
        pMainLayout.setHorizontalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pMainLayout.setVerticalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        pHeading.setBackground(new java.awt.Color(255, 255, 255));
        pHeading.setPreferredSize(new java.awt.Dimension(775, 65));

        lbHeading.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbHeading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/Icons/panels/users.png"))); // NOI18N
        lbHeading.setText("Customers");

        javax.swing.GroupLayout pHeadingLayout = new javax.swing.GroupLayout(pHeading);
        pHeading.setLayout(pHeadingLayout);
        pHeadingLayout.setHorizontalGroup(
            pHeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHeadingLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(lbHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pHeadingLayout.setVerticalGroup(
            pHeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbHeading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pFormLayout = new javax.swing.GroupLayout(pForm);
        pForm.setLayout(pFormLayout);
        pFormLayout.setHorizontalGroup(
            pFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addComponent(pMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pFormLayout.setVerticalGroup(
            pFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFormLayout.createSequentialGroup()
                .addComponent(pHeading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        FormAddCustomer objWindow = new FormAddCustomer();
        objWindow.setVisible(true);
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUserActionPerformed
        if (jTableUsers.getSelectedRow() >= 0) {
            FormEditCustomer objWindow = new FormEditCustomer();
            objWindow.setToUpdate(tempCustomerList.get(jTableUsers.getSelectedRow()));
            objWindow.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Customer needs to be selected", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnEditUserActionPerformed

    private void btnMakeBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakeBookingActionPerformed
        int p = jTableUsers.getSelectedRow() > 0 ? jTableUsers.getSelectedRow() : 0;
        FormAddBooking objWindow = new FormAddBooking();
        objWindow.setEmail(tempCustomerList.get(p).getEmail());
        objWindow.setVisible(true);
    }//GEN-LAST:event_btnMakeBookingActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String query = txtSearch.getText().toLowerCase();
        filter(query);
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnEditUser;
    private javax.swing.JButton btnMakeBooking;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsers;
    private javax.swing.JLabel lbHeading;
    private javax.swing.JPanel pContent;
    private javax.swing.JPanel pControls;
    private javax.swing.JPanel pForm;
    private javax.swing.JPanel pHeading;
    private javax.swing.JPanel pMain;
    private javax.swing.JPanel pSearch;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

//    private void refreshListModel()
//    {
//     
//        tableModel.clear();
//        for (Customer objCurrItem : tempCustomerList)
//        {
//            tableModel.addElement(objCurrItem);        
//        }
//    }
    @Override
    public void update() {
        fillList();
        fillTable();
    }
}
