/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopappgui.Frames.Panels;

import adminDataModel.DataContainer;
import adminDataModel.Event;
import adminDataModel.Show;
import adminDataModel.Venue;
import desktopappgui.Frames.FormAddBooking;
import desktopappgui.Frames.FormAddEvent;
import desktopappgui.Frames.FormAddShow;
import desktopappgui.Frames.FormAddVenue;
import desktopappgui.Frames.FormEditEvent;
import desktopappgui.Frames.FormEditShow;
import desktopappgui.Frames.FormEditVenue;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import utilities.IObserver;

public class PanelEvent extends javax.swing.JPanel implements IObserver {

    /**
     * Creates new form EventPanel2
     */
    DefaultTableModel tableModelEvents;
    DefaultTableModel tableModelVenues;
    DefaultListModel yearListModel;
    DefaultListModel<LocalDate> dateListModel;
    DefaultListModel<LocalTime> timeListModel;
    DataContainer eventList = DataContainer.getInstance();
    ArrayList<Venue> tempVenueList = new ArrayList();
    ArrayList<Show> tempShowList = new ArrayList();

    DefaultTableModel venueTableModel;
    DefaultTableModel eventTableModel;
    DefaultComboBoxModel<LocalDate> monthModel = new DefaultComboBoxModel<>();

    public PanelEvent() {
        dateListModel = new DefaultListModel();
        timeListModel = new DefaultListModel();
        initComponents();
        eventList.registerObserver(this);
        tableModelEvents = (DefaultTableModel) jTableEvents.getModel();
        tableModelVenues = (DefaultTableModel) jTableVenues.getModel();
        refreshTables();
    }

    private void refreshTables() {
        refreshEventTable();
        refreshVenueTable();
        refreshMonthBox();
    }

    private void refreshEventTable() {
        tableModelEvents.setRowCount(0);
        for (Event objCurrItem : eventList.getEventList()) {
            tableModelEvents.addRow(objCurrItem.toTableData());
        }
    }

    private void refreshVenueTable() {
        tableModelVenues.setRowCount(0);
        for (Venue objCurrItem : tempVenueList) {
            tableModelVenues.addRow(objCurrItem.toTableData());
        }
    }

    private void refreshMonthBox() {
        cmbMonth.removeAllItems();
        ArrayList<Month> tempMonthList = new ArrayList();
        for (Show curr : tempShowList) {
            if (!tempMonthList.contains(curr.getStartTime().getMonth())) {
                tempMonthList.add(curr.getStartTime().getMonth());
            }
        }
        for (Month curr : tempMonthList) {
            cmbMonth.addItem(curr);
        }
    }

    private void refreshDateList(Month m) {
        dateListModel.removeAllElements();
        ArrayList<LocalDate> tempDateList = new ArrayList();
        for (Show curr : tempShowList) {
            if (curr.getStartTime().getMonth() == m && !checkDateInList(tempDateList, curr.getStartTime().toLocalDate())) {
                tempDateList.add(curr.getStartTime().toLocalDate());
            }
        }
        for (LocalDate curr : tempDateList) {
            dateListModel.addElement(curr);
        }
    }

    private void refreshTimeList(LocalDate date) {
        timeListModel.removeAllElements();
        for (Show curr : tempShowList) {
            if (curr.getStartTime().toLocalDate().equals(date)) {
                timeListModel.addElement(curr.getStartTime().toLocalTime());
            }
        }
    }

    private boolean checkDateInList(ArrayList<LocalDate> list, LocalDate date) {
        for (LocalDate curr : list) {
            if (curr.equals(date)) {
                return true;
            }
        }
        return false;
    }

    private void filterEvent(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(tableModelEvents);
        jTableEvents.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + query));
    }

    private void filterVenue(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(tableModelVenues);
        jTableVenues.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + query));
    }

    private int confirmationDialog() {
        return JOptionPane.showConfirmDialog(this, "Are you sure you want to delete?", "Delete Confirmation!", YES_NO_OPTION, WARNING_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pHeading = new javax.swing.JPanel();
        lbHeading = new javax.swing.JLabel();
        pForm = new javax.swing.JPanel();
        pEventSection = new javax.swing.JPanel();
        lbEvents = new javax.swing.JLabel();
        pEvents = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEvents = new javax.swing.JTable();
        pSearchEvents = new javax.swing.JPanel();
        txtSearchEvent = new javax.swing.JTextField();
        btnSearchEvent = new javax.swing.JButton();
        pEventControls = new javax.swing.JPanel();
        btnAddEvent = new javax.swing.JButton();
        btnEditEvent = new javax.swing.JButton();
        btnMakeBooking1 = new javax.swing.JButton();
        pVenueSection = new javax.swing.JPanel();
        pVenues = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableVenues = new javax.swing.JTable();
        pSearchVenues = new javax.swing.JPanel();
        txtSearchVenue = new javax.swing.JTextField();
        btnVenueSearch = new javax.swing.JButton();
        pVenueControls = new javax.swing.JPanel();
        btnAddVenue = new javax.swing.JButton();
        btnEditVenue = new javax.swing.JButton();
        lbVenues = new javax.swing.JLabel();
        pEventScheduleSection = new javax.swing.JPanel();
        pBooking = new javax.swing.JPanel();
        pTimePicker = new javax.swing.JPanel();
        lbTime = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListTime = new javax.swing.JList<>();
        pDatePicker = new javax.swing.JPanel();
        lbDate = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListDate = new javax.swing.JList<>();
        pMonthPicker = new javax.swing.JPanel();
        lbMonth = new javax.swing.JLabel();
        cmbMonth = new javax.swing.JComboBox();
        pVenueControls1 = new javax.swing.JPanel();
        btnEditShowing = new javax.swing.JButton();
        btnAddShowing = new javax.swing.JButton();
        btnMakeBooking = new javax.swing.JButton();
        lbEventShedule = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 100, 98));
        setPreferredSize(new java.awt.Dimension(1200, 650));

        pHeading.setBackground(new java.awt.Color(255, 255, 255));
        pHeading.setPreferredSize(new java.awt.Dimension(775, 65));

        lbHeading.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbHeading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/Icons/panels/events.png"))); // NOI18N
        lbHeading.setText("Events");

        javax.swing.GroupLayout pHeadingLayout = new javax.swing.GroupLayout(pHeading);
        pHeading.setLayout(pHeadingLayout);
        pHeadingLayout.setHorizontalGroup(
            pHeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHeadingLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(lbHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pHeadingLayout.setVerticalGroup(
            pHeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pHeadingLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pForm.setBackground(new java.awt.Color(245, 245, 245));
        pForm.setPreferredSize(new java.awt.Dimension(940, 579));

        pEventSection.setBackground(new java.awt.Color(245, 245, 245));

        lbEvents.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbEvents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/event.png"))); // NOI18N
        lbEvents.setText("Event Listing");
        lbEvents.setToolTipText("");

        pEvents.setBackground(new java.awt.Color(250, 250, 250));
        pEvents.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        jTableEvents.setAutoCreateRowSorter(true);
        jTableEvents.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title", "Type", "Genre", "Rating", "Description", "Price", "Refundable"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEvents.setGridColor(new java.awt.Color(240, 240, 240));
        jTableEvents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableEvents.setShowHorizontalLines(false);
        jTableEvents.setShowVerticalLines(false);
        jTableEvents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEventsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEvents);
        if (jTableEvents.getColumnModel().getColumnCount() > 0) {
            jTableEvents.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        pSearchEvents.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pSearchEvents.setLayout(new javax.swing.BoxLayout(pSearchEvents, javax.swing.BoxLayout.LINE_AXIS));

        txtSearchEvent.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        pSearchEvents.add(txtSearchEvent);

        btnSearchEvent.setBackground(new java.awt.Color(153, 153, 153));
        btnSearchEvent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSearchEvent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/Icons/buttons/search.png"))); // NOI18N
        btnSearchEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchEventActionPerformed(evt);
            }
        });
        pSearchEvents.add(btnSearchEvent);

        pEventControls.setBackground(new java.awt.Color(250, 250, 250));

        btnAddEvent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAddEvent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/Icons/buttons/add.png"))); // NOI18N
        btnAddEvent.setText("Create New");
        btnAddEvent.setBorder(null);
        btnAddEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEventActionPerformed(evt);
            }
        });

        btnEditEvent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditEvent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/Icons/buttons/edit.png"))); // NOI18N
        btnEditEvent.setText("Edit Item");
        btnEditEvent.setBorder(null);
        btnEditEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditEventActionPerformed(evt);
            }
        });

        btnMakeBooking1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMakeBooking1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/Icons/buttons/view.png"))); // NOI18N
        btnMakeBooking1.setText("Create Advert");
        btnMakeBooking1.setBorder(null);
        btnMakeBooking1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnMakeBooking1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeBooking1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pEventControlsLayout = new javax.swing.GroupLayout(pEventControls);
        pEventControls.setLayout(pEventControlsLayout);
        pEventControlsLayout.setHorizontalGroup(
            pEventControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEventControlsLayout.createSequentialGroup()
                .addComponent(btnAddEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMakeBooking1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pEventControlsLayout.setVerticalGroup(
            pEventControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEventControlsLayout.createSequentialGroup()
                .addGroup(pEventControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMakeBooking1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pEventsLayout = new javax.swing.GroupLayout(pEvents);
        pEvents.setLayout(pEventsLayout);
        pEventsLayout.setHorizontalGroup(
            pEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEventsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pEventControls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                    .addComponent(pSearchEvents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pEventsLayout.setVerticalGroup(
            pEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEventsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pSearchEvents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pEventControls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout pEventSectionLayout = new javax.swing.GroupLayout(pEventSection);
        pEventSection.setLayout(pEventSectionLayout);
        pEventSectionLayout.setHorizontalGroup(
            pEventSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEventSectionLayout.createSequentialGroup()
                .addGroup(pEventSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbEvents)
                    .addComponent(pEvents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        pEventSectionLayout.setVerticalGroup(
            pEventSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEventSectionLayout.createSequentialGroup()
                .addComponent(lbEvents)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pEvents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pVenueSection.setBackground(new java.awt.Color(245, 245, 245));
        pVenueSection.setPreferredSize(new java.awt.Dimension(495, 330));

        pVenues.setBackground(new java.awt.Color(250, 250, 250));
        pVenues.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        jTableVenues.setAutoCreateRowSorter(true);
        jTableVenues.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableVenues.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableVenues.setGridColor(new java.awt.Color(255, 255, 255));
        jTableVenues.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableVenues.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVenuesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableVenues);

        pSearchVenues.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pSearchVenues.setLayout(new javax.swing.BoxLayout(pSearchVenues, javax.swing.BoxLayout.LINE_AXIS));

        txtSearchVenue.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        pSearchVenues.add(txtSearchVenue);

        btnVenueSearch.setBackground(new java.awt.Color(153, 153, 153));
        btnVenueSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVenueSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/Icons/buttons/search.png"))); // NOI18N
        btnVenueSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenueSearchActionPerformed(evt);
            }
        });
        pSearchVenues.add(btnVenueSearch);

        pVenueControls.setBackground(new java.awt.Color(250, 250, 250));

        btnAddVenue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAddVenue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/Icons/buttons/add.png"))); // NOI18N
        btnAddVenue.setText("Create New");
        btnAddVenue.setBorder(null);
        btnAddVenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVenueActionPerformed(evt);
            }
        });

        btnEditVenue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditVenue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/Icons/buttons/edit.png"))); // NOI18N
        btnEditVenue.setText("Edit Item");
        btnEditVenue.setBorder(null);
        btnEditVenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditVenueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pVenueControlsLayout = new javax.swing.GroupLayout(pVenueControls);
        pVenueControls.setLayout(pVenueControlsLayout);
        pVenueControlsLayout.setHorizontalGroup(
            pVenueControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pVenueControlsLayout.createSequentialGroup()
                .addComponent(btnAddVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pVenueControlsLayout.setVerticalGroup(
            pVenueControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pVenueControlsLayout.createSequentialGroup()
                .addGroup(pVenueControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pVenuesLayout = new javax.swing.GroupLayout(pVenues);
        pVenues.setLayout(pVenuesLayout);
        pVenuesLayout.setHorizontalGroup(
            pVenuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pVenuesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pVenuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pVenueControls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pSearchVenues, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        pVenuesLayout.setVerticalGroup(
            pVenuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pVenuesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pSearchVenues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pVenueControls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        lbVenues.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbVenues.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/venue.png"))); // NOI18N
        lbVenues.setText("Venue Listing (By Event)");
        lbVenues.setToolTipText("");

        javax.swing.GroupLayout pVenueSectionLayout = new javax.swing.GroupLayout(pVenueSection);
        pVenueSection.setLayout(pVenueSectionLayout);
        pVenueSectionLayout.setHorizontalGroup(
            pVenueSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pVenues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pVenueSectionLayout.createSequentialGroup()
                .addComponent(lbVenues)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pVenueSectionLayout.setVerticalGroup(
            pVenueSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pVenueSectionLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lbVenues)
                .addGap(4, 4, 4)
                .addComponent(pVenues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pEventScheduleSection.setBackground(new java.awt.Color(245, 245, 245));
        pEventScheduleSection.setPreferredSize(new java.awt.Dimension(585, 220));

        pBooking.setBackground(new java.awt.Color(204, 204, 204));
        pBooking.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        pTimePicker.setBackground(new java.awt.Color(230, 230, 230));
        pTimePicker.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lbTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/time.png"))); // NOI18N
        lbTime.setText("Start Time");
        lbTime.setIconTextGap(6);

        jScrollPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jListTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jListTime.setModel(timeListModel);
        jListTime.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane5.setViewportView(jListTime);

        javax.swing.GroupLayout pTimePickerLayout = new javax.swing.GroupLayout(pTimePicker);
        pTimePicker.setLayout(pTimePickerLayout);
        pTimePickerLayout.setHorizontalGroup(
            pTimePickerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTimePickerLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );
        pTimePickerLayout.setVerticalGroup(
            pTimePickerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTimePickerLayout.createSequentialGroup()
                .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        pDatePicker.setBackground(new java.awt.Color(230, 230, 230));
        pDatePicker.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pDatePicker.setForeground(new java.awt.Color(204, 204, 204));

        lbDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/Day.png"))); // NOI18N
        lbDate.setText("Date");
        lbDate.setIconTextGap(6);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jListDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jListDate.setModel(dateListModel);
        jListDate.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListDate.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListDateValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(jListDate);

        javax.swing.GroupLayout pDatePickerLayout = new javax.swing.GroupLayout(pDatePicker);
        pDatePicker.setLayout(pDatePickerLayout);
        pDatePickerLayout.setHorizontalGroup(
            pDatePickerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
            .addGroup(pDatePickerLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pDatePickerLayout.setVerticalGroup(
            pDatePickerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDatePickerLayout.createSequentialGroup()
                .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        pMonthPicker.setBackground(new java.awt.Color(250, 250, 250));

        lbMonth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/month.png"))); // NOI18N
        lbMonth.setText("Month:");
        lbMonth.setIconTextGap(6);

        cmbMonth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMonthActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pMonthPickerLayout = new javax.swing.GroupLayout(pMonthPicker);
        pMonthPicker.setLayout(pMonthPickerLayout);
        pMonthPickerLayout.setHorizontalGroup(
            pMonthPickerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMonthPickerLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(lbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pMonthPickerLayout.setVerticalGroup(
            pMonthPickerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMonthPickerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pVenueControls1.setBackground(new java.awt.Color(250, 250, 250));

        btnEditShowing.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditShowing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/Icons/buttons/edit.png"))); // NOI18N
        btnEditShowing.setText("Edit Showing");
        btnEditShowing.setBorder(null);
        btnEditShowing.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnEditShowing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditShowingActionPerformed(evt);
            }
        });

        btnAddShowing.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAddShowing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/show.png"))); // NOI18N
        btnAddShowing.setText("Add Showing");
        btnAddShowing.setBorder(null);
        btnAddShowing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddShowingActionPerformed(evt);
            }
        });

        btnMakeBooking.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMakeBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/booking.png"))); // NOI18N
        btnMakeBooking.setText("Make Booking");
        btnMakeBooking.setBorder(null);
        btnMakeBooking.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnMakeBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeBookingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pVenueControls1Layout = new javax.swing.GroupLayout(pVenueControls1);
        pVenueControls1.setLayout(pVenueControls1Layout);
        pVenueControls1Layout.setHorizontalGroup(
            pVenueControls1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pVenueControls1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnAddShowing, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditShowing, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMakeBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        pVenueControls1Layout.setVerticalGroup(
            pVenueControls1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pVenueControls1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pVenueControls1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddShowing, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditShowing, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMakeBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout pBookingLayout = new javax.swing.GroupLayout(pBooking);
        pBooking.setLayout(pBookingLayout);
        pBookingLayout.setHorizontalGroup(
            pBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBookingLayout.createSequentialGroup()
                .addGroup(pBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pBookingLayout.createSequentialGroup()
                        .addComponent(pDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addComponent(pTimePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pMonthPicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pVenueControls1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        pBookingLayout.setVerticalGroup(
            pBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBookingLayout.createSequentialGroup()
                .addComponent(pMonthPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(pBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pTimePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addComponent(pVenueControls1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lbEventShedule.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbEventShedule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/eventShedule.png"))); // NOI18N
        lbEventShedule.setText("Current Event Schedule");
        lbEventShedule.setToolTipText("");

        javax.swing.GroupLayout pEventScheduleSectionLayout = new javax.swing.GroupLayout(pEventScheduleSection);
        pEventScheduleSection.setLayout(pEventScheduleSectionLayout);
        pEventScheduleSectionLayout.setHorizontalGroup(
            pEventScheduleSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEventScheduleSectionLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pEventScheduleSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pEventScheduleSectionLayout.createSequentialGroup()
                        .addComponent(lbEventShedule)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pBooking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        pEventScheduleSectionLayout.setVerticalGroup(
            pEventScheduleSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEventScheduleSectionLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lbEventShedule)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pBooking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pFormLayout = new javax.swing.GroupLayout(pForm);
        pForm.setLayout(pFormLayout);
        pFormLayout.setHorizontalGroup(
            pFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pEventSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pEventScheduleSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pVenueSection, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
                .addContainerGap())
        );
        pFormLayout.setVerticalGroup(
            pFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFormLayout.createSequentialGroup()
                        .addComponent(pVenueSection, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                        .addGap(11, 11, 11)
                        .addComponent(pEventScheduleSection, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                    .addComponent(pEventSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
            .addComponent(pForm, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pHeading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableEventsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEventsMouseClicked
        tempVenueList = new ArrayList();
        Event selected = eventList.getEventList().get(jTableEvents.getSelectedRow());
        Boolean b;
        for (Show curr : eventList.getShowList()) {
            if (curr.getEvent().getEventId() == selected.getEventId()) {
                b = true;
                for (Venue v : tempVenueList) {
                    if (v.getVenueId() == curr.getVenue().getVenueId()) {
                        b = false;
                        break;
                    }
                }
                if (b) {
                    tempVenueList.add(curr.getVenue());
                }
            }
        }
        refreshVenueTable();
        refreshMonthBox();
    }//GEN-LAST:event_jTableEventsMouseClicked

    private void cmbMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMonthActionPerformed
        Month m = (Month) cmbMonth.getSelectedItem();
        refreshDateList(m);
    }//GEN-LAST:event_cmbMonthActionPerformed

    private void jTableVenuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVenuesMouseClicked
        Venue v = tempVenueList.get(jTableVenues.getSelectedRow());
        Event selected = eventList.getEventList().get(jTableEvents.getSelectedRow());
        tempShowList = new ArrayList();
        if (selected != null && v != null) {
            for (Show object : eventList.getShowList()) {
                if (object.getEvent().getEventId() == selected.getEventId() && v.getVenueId() == object.getVenue().getVenueId() && !tempShowList.contains(object)) {
                    tempShowList.add(object);
                }
            }
        }
        refreshMonthBox();
    }//GEN-LAST:event_jTableVenuesMouseClicked

    private void jListDateValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListDateValueChanged
        LocalDate date = null;
        date = (LocalDate) jListDate.getSelectedValue();
        refreshTimeList(date);
    }//GEN-LAST:event_jListDateValueChanged

    private void btnAddEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEventActionPerformed
        FormAddEvent objWindow = new FormAddEvent();
        objWindow.setVisible(true);
    }//GEN-LAST:event_btnAddEventActionPerformed

    private void btnAddShowingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddShowingActionPerformed
        FormAddShow objWindow = new FormAddShow();
        int e = jTableEvents.getSelectedRow() >= 0 ? jTableEvents.getSelectedRow() : 0, v = jTableVenues.getSelectedRow() > 0 ? jTableVenues.getSelectedRow() : 0;
        objWindow.setSelectedEvent(eventList.getEventList().get(e));
        objWindow.setSelectedVenue(tempVenueList.get(v));
        objWindow.setVisible(true);
    }//GEN-LAST:event_btnAddShowingActionPerformed

    private void btnMakeBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakeBookingActionPerformed
        FormAddBooking objWindow = new FormAddBooking();
        int e = jTableEvents.getSelectedRow() > 0 ? jTableEvents.getSelectedRow() : 0;
        int v = jTableVenues.getSelectedRow() > 0 ? jTableVenues.getSelectedRow() : 0;
        int d = jListDate.getSelectedIndex();
        objWindow.setSelectedEvent(eventList.getEventList().get(e));
        objWindow.setSelectedVenue(tempVenueList.get(v));
        for (Show curr : eventList.getShowList()) {
            if (curr.getEvent() == eventList.getEventList().get(e) && curr.getVenue() == tempVenueList.get(v)
                    && d > 0 && curr.getStartTime().toLocalDate().isEqual((LocalDate) jListDate.getSelectedValue())) {
                objWindow.setSelectedTime(curr.getStartTime());
            }
        }
        objWindow.setVisible(true);
    }//GEN-LAST:event_btnMakeBookingActionPerformed

    private void btnSearchEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchEventActionPerformed
        String query = txtSearchEvent.getText().toLowerCase();
        filterEvent(query);
    }//GEN-LAST:event_btnSearchEventActionPerformed

    private void btnVenueSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenueSearchActionPerformed
        String query = txtSearchVenue.getText().toLowerCase();
        filterVenue(query);
    }//GEN-LAST:event_btnVenueSearchActionPerformed

    private void btnAddVenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVenueActionPerformed
        FormAddVenue objWindow = new FormAddVenue();
        objWindow.setVisible(true);
    }//GEN-LAST:event_btnAddVenueActionPerformed

    private void btnEditVenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditVenueActionPerformed
        // Pass Edit Data
        FormEditVenue objWindow = new FormEditVenue();
        objWindow.setToUpdate(eventList.getVenueList().get(jTableVenues.getSelectedRow()));
        objWindow.setVisible(true);
    }//GEN-LAST:event_btnEditVenueActionPerformed

    private void btnEditEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditEventActionPerformed
        FormEditEvent objWindow = new FormEditEvent();
        objWindow.setToUpdate(eventList.getEventList().get(jTableEvents.getSelectedRow()));
        objWindow.setVisible(true);
    }//GEN-LAST:event_btnEditEventActionPerformed

    private void btnEditShowingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditShowingActionPerformed
        FormEditShow objWindow = new FormEditShow();
        int e = jTableEvents.getSelectedRow() > 0 ? jTableEvents.getSelectedRow() : 0;
        int v = jTableVenues.getSelectedRow() > 0 ? jTableVenues.getSelectedRow() : 0;
        int d = jListDate.getSelectedIndex();
        int t = jListTime.getSelectedIndex();
        for (Show curr : eventList.getShowList()) {
            if (curr.getEvent().getEventId() == eventList.getEventList().get(e).getEventId()) {
                if (tempVenueList.size() > 0 && curr.getVenue().getVenueId() == tempVenueList.get(v).getVenueId()) {
                    if (d >= 0 && t >= 0) {
                        if (curr.getStartTime().equals(dateListModel.get(d).atTime(timeListModel.get(t)))) {
                            objWindow.setToUpdate(curr);
                            objWindow.setVisible(true);
                            break;
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnEditShowingActionPerformed

    private void btnMakeBooking1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakeBooking1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMakeBooking1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEvent;
    private javax.swing.JButton btnAddShowing;
    private javax.swing.JButton btnAddVenue;
    private javax.swing.JButton btnEditEvent;
    private javax.swing.JButton btnEditShowing;
    private javax.swing.JButton btnEditVenue;
    private javax.swing.JButton btnMakeBooking;
    private javax.swing.JButton btnMakeBooking1;
    private javax.swing.JButton btnSearchEvent;
    private javax.swing.JButton btnVenueSearch;
    private javax.swing.JComboBox cmbMonth;
    private javax.swing.JList<LocalDate> jListDate;
    private javax.swing.JList<LocalTime> jListTime;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableEvents;
    private javax.swing.JTable jTableVenues;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbEventShedule;
    private javax.swing.JLabel lbEvents;
    private javax.swing.JLabel lbHeading;
    private javax.swing.JLabel lbMonth;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lbVenues;
    private javax.swing.JPanel pBooking;
    private javax.swing.JPanel pDatePicker;
    private javax.swing.JPanel pEventControls;
    private javax.swing.JPanel pEventScheduleSection;
    private javax.swing.JPanel pEventSection;
    private javax.swing.JPanel pEvents;
    private javax.swing.JPanel pForm;
    private javax.swing.JPanel pHeading;
    private javax.swing.JPanel pMonthPicker;
    private javax.swing.JPanel pSearchEvents;
    private javax.swing.JPanel pSearchVenues;
    private javax.swing.JPanel pTimePicker;
    private javax.swing.JPanel pVenueControls;
    private javax.swing.JPanel pVenueControls1;
    private javax.swing.JPanel pVenueSection;
    private javax.swing.JPanel pVenues;
    private javax.swing.JTextField txtSearchEvent;
    private javax.swing.JTextField txtSearchVenue;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {
        refreshTables();
    }
}
