/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopappgui.Frames;

import adminDataModel.DataContainer;
import adminDataModel.Event;
import adminDataModel.Venue;
import adminDataModel.Show;
import adminDataModel.Booking;
import adminDataModel.BookingStatus;
import adminDataModel.Customer;
import validation.*;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;

public class FormAddBooking extends javax.swing.JFrame {

    DataContainer admin = DataContainer.getInstance();
    DefaultComboBoxModel<Event> eventModel = new DefaultComboBoxModel();
    DefaultComboBoxModel<Venue> venueModel = new DefaultComboBoxModel();
    DefaultComboBoxModel<LocalTime> timeModel = new DefaultComboBoxModel();
    DefaultComboBoxModel<Month> monthModel = new DefaultComboBoxModel();
    DefaultComboBoxModel<LocalDate> dateModel = new DefaultComboBoxModel();
    //DefaultComboBoxModel<LocalDateTime> priceModel = new DefaultComboBoxModel();
    private boolean isDisposing;

    /**
     * Creates new form AddUserFrame
     */
    public FormAddBooking() {
        initComponents();
        // Set custom visuals
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/graphics/addForm.png")));
        this.setLocationRelativeTo(null); // Centre window

        // <editor-fold defaultstate="collapsed" desc="Input Data Validation">
        txtUserEmail.setInputVerifier(new EmailValidator(txtUserEmail));
        // </editor-fold>
        addEvents(null);
        addVenues(null);
        addMonths();
        this.isDisposing = false;
    }

    private void addEvents(Venue v) {
        eventModel.removeAllElements();
        if (v == null) {
            for (Event curr : admin.getEventList()) {
                eventModel.addElement(curr);
            }
        } else {
            for (Show curr : admin.getShowList()) {
                if (curr.getVenue() == v) {
                    eventModel.addElement(curr.getEvent());
                }
            }
        }
    }

    private void addVenues(Event e) {
        venueModel.removeAllElements();
        if (e == null) {
            for (Venue curr : admin.getVenueList()) {
                venueModel.addElement(curr);
            }
        } else {
            for (Show curr : admin.getShowList()) {
                if (curr.getEvent().equals(e) && venueModel.getIndexOf(curr.getVenue()) < 0) {
                    venueModel.addElement(curr.getVenue());
                }
            }
        }
    }

    private void addMonths() {
        monthModel.removeAllElements();
        Event e = (Event) cmbEvent.getSelectedItem();
        Venue v = (Venue) cmbVenue.getSelectedItem();
        if (e != null && v != null) {
            for (Show curr : admin.getShowList()) {
                if (curr.getEvent().equals(e) && curr.getVenue().equals(v) && monthModel.getIndexOf(curr.getStartTime().getMonth()) < 0) {
                    monthModel.addElement(curr.getStartTime().getMonth());
                }
            }
        }
    }

    private void addDates() {
        dateModel.removeAllElements();
        Event e = (Event) cmbEvent.getSelectedItem();
        Venue v = (Venue) cmbVenue.getSelectedItem();
        Month m = (Month) cmbMonth.getSelectedItem();
        if (e != null && v != null && m != null) {
            for (Show curr : admin.getShowList()) {
                if (curr.getEvent().equals(e) && curr.getVenue().equals(v) && curr.getStartTime().getMonth().equals(m) && dateModel.getIndexOf(curr.getStartTime().toLocalDate()) < 0) {
                    dateModel.addElement(curr.getStartTime().toLocalDate());
                }
            }
        }
    }

    private void addTimes() {
        timeModel.removeAllElements();
        Event e = (Event) cmbEvent.getSelectedItem();
        Venue v = (Venue) cmbVenue.getSelectedItem();
        LocalDate d = (LocalDate) cmbDate.getSelectedItem();
        if (e != null && v != null && d != null) {
            for (Show curr : admin.getShowList()) {
                if (curr.getEvent().equals(e) && curr.getVenue().equals(v) && curr.getStartTime().toLocalDate().equals(d) && timeModel.getIndexOf(curr.getStartTime().toLocalTime()) < 0) {
                    timeModel.addElement(curr.getStartTime().toLocalTime());
                }
            }
        }
    }

    public void setEmail(String email) {
        txtUserEmail.setText(email);
    }

    public void setSelectedEvent(Event e) {
        cmbEvent.setSelectedItem(e);
    }

    public void setSelectedVenue(Venue v) {
        cmbVenue.setSelectedItem(v);
    }

    public void setSelectedTime(LocalDateTime ldt) {
        cmbMonth.setSelectedItem(ldt.getMonth());
        cmbDate.setSelectedItem(ldt.toLocalDate());
        cmbTime.setSelectedItem(ldt.toLocalTime());
    }

    //DOES NOT HANDLE PRICE BANDS YET
    private void addBooking() {
        Customer c = admin.getByEmail(txtUserEmail.getText());
        if(c == null) {
            c = new Customer(txtUserEmail.getText());
            admin.addNewCustomer(c);
        }
        int seats = (int) spnSeats.getValue();
        for(Show curr : admin.getShowList()) {
            if(curr.getEvent().equals(cmbEvent.getSelectedItem()) && curr.getVenue().equals(cmbVenue.getSelectedItem()) 
                    && curr.getStartTime().equals(((LocalDate)cmbDate.getSelectedItem()).atTime(((LocalTime)cmbTime.getSelectedItem())))) {
                Booking b = new Booking(c, curr, BookingStatus.Upcoming, seats * 15, seats);
                admin.addNewBooking(b);
                break;
            }
        }
    }

    private boolean doesUserExist(String email) {
        //Do stuff that iterates through the model to see if the user exists
        for (Customer c : admin.getPeopleList()) {
            if (email.equals(c.getEmail())) {
                return true;
            }
        }
        return false;
    }

    private boolean isUserGuest(String email) {
        //Check if existant user is guest or not
        for (Customer c : admin.getPeopleList()) {
            if (c.getEmail().equals(email) && c.getPassword() == null) {
                return true;
            }
        }
        return false;
    }

    private void checkUserExists(String email) {
        if (doesUserExist(email)) {
            if (isUserGuest(email)) {
                if (dialog("A User does not exist with the entered email, do you want to register a "
                        + "new user with this email (Yes) or continue as a guest booking (No)?") == YES_OPTION) {
                    //txtUserEmail.setText("OPEN NEW USER SCREEN MAKE GUEST TO USER");
                    FormEditCustomer objWindow = new FormEditCustomer();
                    objWindow.setToUpdate(admin.getByEmail(email));
                    objWindow.setVisible(true);
                } else {
                    //txtUserEmail.setText("CONTINUE AS GUEST");
                }
            } else {
//                txtUserEmail.setText("USER EXISTS");
            }
        } else if (dialog("A User does not exist with the entered email, do you want to register a new "
                + "user with this email (Yes) or continue as a guest booking (No)?") == YES_OPTION) {
            //txtUserEmail.setText("OPEN NEW USER SCREEN");
            FormAddCustomer objWindow = new FormAddCustomer();
            objWindow.setEmail(email);
            objWindow.setVisible(true);
        } else {
            Customer guest = new Customer(email);
            admin.addNewCustomer(guest);
        }
    }

    private int dialog(String msg) {
        return JOptionPane.showConfirmDialog(this, msg, "User not found?", YES_NO_OPTION, QUESTION_MESSAGE);
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
        lbBookingDetails = new javax.swing.JLabel();
        pContent1 = new javax.swing.JPanel();
        pLabels1 = new javax.swing.JPanel();
        lbUserEmail = new javax.swing.JLabel();
        lbEvent = new javax.swing.JLabel();
        lbVenue = new javax.swing.JLabel();
        lbStartDate = new javax.swing.JLabel();
        lbStartTimes = new javax.swing.JLabel();
        pInputs1 = new javax.swing.JPanel();
        txtUserEmail = new javax.swing.JTextField();
        pEventPicker = new javax.swing.JPanel();
        cmbEvent = new javax.swing.JComboBox<Event>();
        pVenuePicker = new javax.swing.JPanel();
        cmbVenue = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        cmbMonth = new javax.swing.JComboBox<>();
        cmbDate = new javax.swing.JComboBox<>();
        cmbTime = new javax.swing.JComboBox<>();
        pConfirmArea = new javax.swing.JPanel();
        pInputs = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        pEventDetails1 = new javax.swing.JPanel();
        pHeader2 = new javax.swing.JPanel();
        lbSeatingDetails = new javax.swing.JLabel();
        pContent2 = new javax.swing.JPanel();
        pLabels2 = new javax.swing.JPanel();
        lbPriceBands = new javax.swing.JLabel();
        lbBookedSeats = new javax.swing.JLabel();
        pInputs2 = new javax.swing.JPanel();
        pPriceBandPicker = new javax.swing.JPanel();
        cmbPriceBands = new javax.swing.JComboBox<>();
        spnSeats = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Booking");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pForm.setBackground(new java.awt.Color(255, 255, 255));
        pForm.setForeground(new java.awt.Color(204, 204, 204));

        pEventDetails.setBackground(new java.awt.Color(255, 255, 255));

        pHeader1.setBackground(new java.awt.Color(255, 255, 255));

        lbBookingDetails.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbBookingDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/venue.png"))); // NOI18N
        lbBookingDetails.setText("Booking Details");
        lbBookingDetails.setToolTipText("");

        javax.swing.GroupLayout pHeader1Layout = new javax.swing.GroupLayout(pHeader1);
        pHeader1.setLayout(pHeader1Layout);
        pHeader1Layout.setHorizontalGroup(
            pHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbBookingDetails)
        );
        pHeader1Layout.setVerticalGroup(
            pHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbBookingDetails)
        );

        pContent1.setBackground(new java.awt.Color(255, 255, 255));
        pContent1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        pLabels1.setBackground(new java.awt.Color(255, 255, 255));
        pLabels1.setLayout(new java.awt.GridLayout(5, 1, 11, 11));

        lbUserEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbUserEmail.setForeground(new java.awt.Color(42, 42, 42));
        lbUserEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbUserEmail.setText("User Email*");
        pLabels1.add(lbUserEmail);

        lbEvent.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEvent.setForeground(new java.awt.Color(42, 42, 42));
        lbEvent.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbEvent.setText("Event*");
        pLabels1.add(lbEvent);

        lbVenue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbVenue.setForeground(new java.awt.Color(42, 42, 42));
        lbVenue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbVenue.setText("Venue*");
        pLabels1.add(lbVenue);

        lbStartDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbStartDate.setForeground(new java.awt.Color(42, 42, 42));
        lbStartDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbStartDate.setText("Start Date*");
        pLabels1.add(lbStartDate);

        lbStartTimes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbStartTimes.setForeground(new java.awt.Color(42, 42, 42));
        lbStartTimes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbStartTimes.setText("Start Times*");
        pLabels1.add(lbStartTimes);

        pInputs1.setBackground(new java.awt.Color(255, 255, 255));
        pInputs1.setLayout(new java.awt.GridLayout(5, 0, 0, 11));

        txtUserEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUserEmail.setName("User email"); // NOI18N
        txtUserEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserEmailFocusLost(evt);
            }
        });
        pInputs1.add(txtUserEmail);

        pEventPicker.setLayout(new javax.swing.BoxLayout(pEventPicker, javax.swing.BoxLayout.LINE_AXIS));

        cmbEvent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbEvent.setModel(eventModel);
        cmbEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEventActionPerformed(evt);
            }
        });
        pEventPicker.add(cmbEvent);

        pInputs1.add(pEventPicker);

        pVenuePicker.setLayout(new javax.swing.BoxLayout(pVenuePicker, javax.swing.BoxLayout.LINE_AXIS));

        cmbVenue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbVenue.setModel(venueModel);
        cmbVenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVenueActionPerformed(evt);
            }
        });
        pVenuePicker.add(cmbVenue);

        pInputs1.add(pVenuePicker);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 6, 0));

        cmbMonth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbMonth.setModel(monthModel);
        cmbMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMonthActionPerformed(evt);
            }
        });
        jPanel1.add(cmbMonth);

        cmbDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbDate.setModel(dateModel);
        cmbDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDateActionPerformed(evt);
            }
        });
        jPanel1.add(cmbDate);

        pInputs1.add(jPanel1);

        cmbTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbTime.setModel(timeModel);
        cmbTime.setAlignmentX(0.0F);
        cmbTime.setName("Rating"); // NOI18N
        pInputs1.add(cmbTime);

        javax.swing.GroupLayout pContent1Layout = new javax.swing.GroupLayout(pContent1);
        pContent1.setLayout(pContent1Layout);
        pContent1Layout.setHorizontalGroup(
            pContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContent1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pLabels1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pInputs1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pContent1Layout.setVerticalGroup(
            pContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContent1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pLabels1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pInputs1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pEventDetailsLayout = new javax.swing.GroupLayout(pEventDetails);
        pEventDetails.setLayout(pEventDetailsLayout);
        pEventDetailsLayout.setHorizontalGroup(
            pEventDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEventDetailsLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pEventDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pContent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pEventDetailsLayout.createSequentialGroup()
                        .addComponent(pHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(263, 263, 263))))
        );
        pEventDetailsLayout.setVerticalGroup(
            pEventDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEventDetailsLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pContent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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

        pEventDetails1.setBackground(new java.awt.Color(255, 255, 255));

        pHeader2.setBackground(new java.awt.Color(255, 255, 255));

        lbSeatingDetails.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbSeatingDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/seats.png"))); // NOI18N
        lbSeatingDetails.setText("Seating Details");
        lbSeatingDetails.setToolTipText("");

        javax.swing.GroupLayout pHeader2Layout = new javax.swing.GroupLayout(pHeader2);
        pHeader2.setLayout(pHeader2Layout);
        pHeader2Layout.setHorizontalGroup(
            pHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbSeatingDetails)
        );
        pHeader2Layout.setVerticalGroup(
            pHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbSeatingDetails)
        );

        pContent2.setBackground(new java.awt.Color(255, 255, 255));
        pContent2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        pLabels2.setBackground(new java.awt.Color(255, 255, 255));
        pLabels2.setLayout(new java.awt.GridLayout(2, 1, 11, 11));

        lbPriceBands.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPriceBands.setForeground(new java.awt.Color(42, 42, 42));
        lbPriceBands.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPriceBands.setText("Price Band*");
        pLabels2.add(lbPriceBands);

        lbBookedSeats.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbBookedSeats.setForeground(new java.awt.Color(42, 42, 42));
        lbBookedSeats.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbBookedSeats.setText("Booked Seats*");
        pLabels2.add(lbBookedSeats);

        pInputs2.setBackground(new java.awt.Color(255, 255, 255));
        pInputs2.setLayout(new java.awt.GridLayout(2, 0, 0, 11));

        pPriceBandPicker.setLayout(new javax.swing.BoxLayout(pPriceBandPicker, javax.swing.BoxLayout.LINE_AXIS));

        cmbPriceBands.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbPriceBands.setModel(venueModel);
        pPriceBandPicker.add(cmbPriceBands);

        pInputs2.add(pPriceBandPicker);

        spnSeats.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spnSeats.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        pInputs2.add(spnSeats);

        javax.swing.GroupLayout pContent2Layout = new javax.swing.GroupLayout(pContent2);
        pContent2.setLayout(pContent2Layout);
        pContent2Layout.setHorizontalGroup(
            pContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContent2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pLabels2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pInputs2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pContent2Layout.setVerticalGroup(
            pContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContent2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pLabels2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pInputs2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pEventDetails1Layout = new javax.swing.GroupLayout(pEventDetails1);
        pEventDetails1.setLayout(pEventDetails1Layout);
        pEventDetails1Layout.setHorizontalGroup(
            pEventDetails1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEventDetails1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pEventDetails1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pContent2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pEventDetails1Layout.createSequentialGroup()
                        .addComponent(pHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(263, 263, 263))))
        );
        pEventDetails1Layout.setVerticalGroup(
            pEventDetails1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEventDetails1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pContent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pFormLayout = new javax.swing.GroupLayout(pForm);
        pForm.setLayout(pFormLayout);
        pFormLayout.setHorizontalGroup(
            pFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pConfirmArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pEventDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pEventDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        pFormLayout.setVerticalGroup(
            pFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pEventDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pEventDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pConfirmArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        isDisposing = true;
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        addBooking();
        dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtUserEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserEmailFocusLost
        if (!isDisposing) {
            checkUserExists(txtUserEmail.getText());
        }
    }//GEN-LAST:event_txtUserEmailFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        isDisposing = true;
    }//GEN-LAST:event_formWindowClosing

    private void cmbEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEventActionPerformed
        Event e = (Event) cmbEvent.getSelectedItem();
        addVenues(e);
    }//GEN-LAST:event_cmbEventActionPerformed

    private void cmbVenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVenueActionPerformed
        addMonths();
    }//GEN-LAST:event_cmbVenueActionPerformed

    private void cmbMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMonthActionPerformed
        addDates();
    }//GEN-LAST:event_cmbMonthActionPerformed

    private void cmbDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDateActionPerformed
        addTimes();
    }//GEN-LAST:event_cmbDateActionPerformed

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
            java.util.logging.Logger.getLogger(FormAddBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAddBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAddBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAddBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FormAddBooking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<LocalDate> cmbDate;
    private javax.swing.JComboBox<Event> cmbEvent;
    private javax.swing.JComboBox<Month> cmbMonth;
    private javax.swing.JComboBox<Venue> cmbPriceBands;
    private javax.swing.JComboBox<LocalTime> cmbTime;
    private javax.swing.JComboBox<Venue> cmbVenue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbBookedSeats;
    private javax.swing.JLabel lbBookingDetails;
    private javax.swing.JLabel lbEvent;
    private javax.swing.JLabel lbPriceBands;
    private javax.swing.JLabel lbSeatingDetails;
    private javax.swing.JLabel lbStartDate;
    private javax.swing.JLabel lbStartTimes;
    private javax.swing.JLabel lbUserEmail;
    private javax.swing.JLabel lbVenue;
    private javax.swing.JPanel pConfirmArea;
    private javax.swing.JPanel pContent1;
    private javax.swing.JPanel pContent2;
    private javax.swing.JPanel pEventDetails;
    private javax.swing.JPanel pEventDetails1;
    private javax.swing.JPanel pEventPicker;
    private javax.swing.JPanel pForm;
    private javax.swing.JPanel pHeader1;
    private javax.swing.JPanel pHeader2;
    private javax.swing.JPanel pInputs;
    private javax.swing.JPanel pInputs1;
    private javax.swing.JPanel pInputs2;
    private javax.swing.JPanel pLabels1;
    private javax.swing.JPanel pLabels2;
    private javax.swing.JPanel pPriceBandPicker;
    private javax.swing.JPanel pVenuePicker;
    private javax.swing.JSpinner spnSeats;
    private javax.swing.JTextField txtUserEmail;
    // End of variables declaration//GEN-END:variables

}
