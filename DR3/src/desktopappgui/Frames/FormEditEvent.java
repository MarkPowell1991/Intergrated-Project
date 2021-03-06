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
import javax.swing.DefaultComboBoxModel;

public class FormEditEvent extends javax.swing.JFrame {

    DataContainer admin = DataContainer.getInstance();
    Event toUpdate;
    DefaultComboBoxModel<Genre> genreComboModel;
    DefaultComboBoxModel<EventType> typeComboModel;

    public FormEditEvent() {
        Genre[] genres = {Genre.Classical, Genre.Comedy, Genre.Drama, Genre.Pop, Genre.Rock, Genre.Romantic};
        genreComboModel = new DefaultComboBoxModel(genres);
        EventType[] types = {EventType.Concert, EventType.Movie, EventType.Musical, EventType.Sport, EventType.Theatre};
        typeComboModel = new DefaultComboBoxModel(types);
        initComponents();

        // Set custom visuals
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/graphics/addForm.png")));
        this.setLocationRelativeTo(null); // Centre window

        // <editor-fold defaultstate="collapsed" desc="Input Validation">
        txtEventName.setInputVerifier(new AlphaNumericalValidator(txtEventName, 1, 35, false));
        txtDescription.setInputVerifier(new TextAreaAlphaNumericalValidator(txtDescription, 1, 35, false));
        // </editor-fold>
    }

    private void updateEvent() {
        toUpdate.setName(txtEventName.getText());
        toUpdate.setBasePrice(Double.parseDouble(txtBasePrice.getText()));
        toUpdate.setDescription(txtDescription.getText());
        toUpdate.setduration(Integer.parseInt(spnDuration.getValue().toString()));
        toUpdate.setGenre((Genre) cmbGenre.getSelectedItem());
        toUpdate.setType((EventType) cmbType.getSelectedItem());
        toUpdate.setAgeRequirement((String) cmbRating.getSelectedItem());
        toUpdate.setRefundable(ckbRefundable.isSelected());
        admin.updateEvent(toUpdate);
    }

    public void setToUpdate(Event e) {
        toUpdate = e;
        txtEventName.setText(e.getName());
        txtBasePrice.setText("" + e.getBasePrice());
        txtDescription.setText(e.getDescription());
        spnDuration.setValue(e.getDuration());
        cmbGenre.setSelectedItem(e.getGenre());
        cmbType.setSelectedItem(e.getType());
        cmbRating.setSelectedItem(e.getAgeRequirement());
        //ckbRefundable.setSelected(e.isRefundable());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pForm = new javax.swing.JPanel();
        pEventDetails = new javax.swing.JPanel();
        pHeader1 = new javax.swing.JPanel();
        lbEventDetails = new javax.swing.JLabel();
        pContent1 = new javax.swing.JPanel();
        pLabels1 = new javax.swing.JPanel();
        lbEventName = new javax.swing.JLabel();
        lbDuration = new javax.swing.JLabel();
        lbStartTime1 = new javax.swing.JLabel();
        pInputs1 = new javax.swing.JPanel();
        txtEventName = new javax.swing.JTextField();
        spnDuration = new javax.swing.JSpinner();
        txtBasePrice = new javax.swing.JFormattedTextField();
        pLabels1a = new javax.swing.JPanel();
        lbDescription = new javax.swing.JLabel();
        pInputs1a = new javax.swing.JPanel();
        spDescription = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        pClassification = new javax.swing.JPanel();
        pHeader2 = new javax.swing.JPanel();
        lbClassification = new javax.swing.JLabel();
        pContent2 = new javax.swing.JPanel();
        pLabels2 = new javax.swing.JPanel();
        lbType = new javax.swing.JLabel();
        lbGenre = new javax.swing.JLabel();
        lbAgeRating = new javax.swing.JLabel();
        pInputs2 = new javax.swing.JPanel();
        cmbType = new javax.swing.JComboBox<>();
        cmbGenre = new javax.swing.JComboBox<Genre>();
        cmbRating = new javax.swing.JComboBox<>();
        pLabels2a = new javax.swing.JPanel();
        lbRefundable = new javax.swing.JLabel();
        pInputs2a = new javax.swing.JPanel();
        ckbRefundable = new javax.swing.JCheckBox();
        pConfirmArea = new javax.swing.JPanel();
        pInputs = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Event");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        pForm.setBackground(new java.awt.Color(255, 255, 255));
        pForm.setForeground(new java.awt.Color(204, 204, 204));

        pEventDetails.setBackground(new java.awt.Color(255, 255, 255));

        pHeader1.setBackground(new java.awt.Color(255, 255, 255));

        lbEventDetails.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbEventDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/event.png"))); // NOI18N
        lbEventDetails.setText("Event Details");
        lbEventDetails.setToolTipText("");

        javax.swing.GroupLayout pHeader1Layout = new javax.swing.GroupLayout(pHeader1);
        pHeader1.setLayout(pHeader1Layout);
        pHeader1Layout.setHorizontalGroup(
            pHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbEventDetails)
        );
        pHeader1Layout.setVerticalGroup(
            pHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbEventDetails)
        );

        pContent1.setBackground(new java.awt.Color(255, 255, 255));
        pContent1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        pLabels1.setBackground(new java.awt.Color(255, 255, 255));
        pLabels1.setLayout(new java.awt.GridLayout(3, 1, 11, 11));

        lbEventName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEventName.setForeground(new java.awt.Color(42, 42, 42));
        lbEventName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbEventName.setText("Event Name*");
        pLabels1.add(lbEventName);

        lbDuration.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbDuration.setForeground(new java.awt.Color(42, 42, 42));
        lbDuration.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDuration.setText("Duration (mins)*");
        pLabels1.add(lbDuration);

        lbStartTime1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbStartTime1.setForeground(new java.awt.Color(42, 42, 42));
        lbStartTime1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbStartTime1.setText("£ Base Price*");
        pLabels1.add(lbStartTime1);

        pInputs1.setBackground(new java.awt.Color(255, 255, 255));
        pInputs1.setLayout(new java.awt.GridLayout(3, 0, 0, 11));

        txtEventName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEventName.setName("Event Name"); // NOI18N
        pInputs1.add(txtEventName);

        spnDuration.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spnDuration.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9999, 1));
        pInputs1.add(spnDuration);

        txtBasePrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00"))));
        txtBasePrice.setText("0.00");
        txtBasePrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pInputs1.add(txtBasePrice);

        pLabels1a.setBackground(new java.awt.Color(255, 255, 255));
        pLabels1a.setLayout(new java.awt.GridLayout(1, 0));

        lbDescription.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbDescription.setForeground(new java.awt.Color(42, 42, 42));
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

        pClassification.setBackground(new java.awt.Color(255, 255, 255));

        pHeader2.setBackground(new java.awt.Color(255, 255, 255));

        lbClassification.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbClassification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/classification.png"))); // NOI18N
        lbClassification.setText("Classification");
        lbClassification.setToolTipText("");

        javax.swing.GroupLayout pHeader2Layout = new javax.swing.GroupLayout(pHeader2);
        pHeader2.setLayout(pHeader2Layout);
        pHeader2Layout.setHorizontalGroup(
            pHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbClassification, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pHeader2Layout.setVerticalGroup(
            pHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbClassification)
        );

        pContent2.setBackground(new java.awt.Color(255, 255, 255));
        pContent2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        pLabels2.setBackground(new java.awt.Color(255, 255, 255));
        pLabels2.setLayout(new java.awt.GridLayout(3, 1, 11, 11));

        lbType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbType.setForeground(new java.awt.Color(42, 42, 42));
        lbType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbType.setText("Type*");
        pLabels2.add(lbType);

        lbGenre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbGenre.setForeground(new java.awt.Color(42, 42, 42));
        lbGenre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbGenre.setText("Genre*");
        pLabels2.add(lbGenre);

        lbAgeRating.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbAgeRating.setForeground(new java.awt.Color(42, 42, 42));
        lbAgeRating.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbAgeRating.setText("Age Rating*");
        pLabels2.add(lbAgeRating);

        pInputs2.setBackground(new java.awt.Color(255, 255, 255));
        pInputs2.setLayout(new java.awt.GridLayout(3, 1, 5, 11));

        cmbType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbType.setModel(typeComboModel);
        cmbType.setAlignmentX(0.0F);
        cmbType.setName("Type"); // NOI18N
        pInputs2.add(cmbType);

        cmbGenre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbGenre.setModel(genreComboModel);
        cmbGenre.setAlignmentX(0.0F);
        cmbGenre.setName("Genre"); // NOI18N
        pInputs2.add(cmbGenre);

        cmbRating.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbRating.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rating", "U", "PG", "12", "15", "18" }));
        cmbRating.setAlignmentX(0.0F);
        cmbRating.setName("Rating"); // NOI18N
        pInputs2.add(cmbRating);

        pLabels2a.setBackground(new java.awt.Color(255, 255, 255));
        pLabels2a.setLayout(new java.awt.GridLayout(1, 1, 11, 11));

        lbRefundable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbRefundable.setForeground(new java.awt.Color(42, 42, 42));
        lbRefundable.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbRefundable.setText("Refundable*");
        pLabels2a.add(lbRefundable);

        pInputs2a.setBackground(new java.awt.Color(255, 255, 255));
        pInputs2a.setLayout(new java.awt.GridLayout(1, 2, 5, 11));

        ckbRefundable.setBackground(new java.awt.Color(255, 255, 255));
        ckbRefundable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ckbRefundable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ckbRefundable.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ckbRefundable.setIconTextGap(0);
        ckbRefundable.setMargin(new java.awt.Insets(2, 0, 2, 2));
        ckbRefundable.setName("Refundable"); // NOI18N
        pInputs2a.add(ckbRefundable);

        javax.swing.GroupLayout pContent2Layout = new javax.swing.GroupLayout(pContent2);
        pContent2.setLayout(pContent2Layout);
        pContent2Layout.setHorizontalGroup(
            pContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContent2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pContent2Layout.createSequentialGroup()
                        .addComponent(pLabels2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pInputs2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pContent2Layout.createSequentialGroup()
                        .addComponent(pLabels2a, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pInputs2a, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pContent2Layout.setVerticalGroup(
            pContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContent2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pInputs2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pLabels2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(pContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pInputs2a, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pLabels2a, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pClassificationLayout = new javax.swing.GroupLayout(pClassification);
        pClassification.setLayout(pClassificationLayout);
        pClassificationLayout.setHorizontalGroup(
            pClassificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pClassificationLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pClassificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pContent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        pClassificationLayout.setVerticalGroup(
            pClassificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pClassificationLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pContent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pConfirmArea.setBackground(new java.awt.Color(242, 242, 242));
        pConfirmArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        pInputs.setBackground(new java.awt.Color(242, 242, 242));
        pInputs.setLayout(new java.awt.GridLayout(1, 1, 6, 4));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/tick.png"))); // NOI18N
        btnSave.setText("Save");
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
                .addGroup(pFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pEventDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pClassification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );
        pFormLayout.setVerticalGroup(
            pFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pEventDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pClassification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        updateEvent();
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
            java.util.logging.Logger.getLogger(FormEditEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormEditEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormEditEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormEditEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FormEditEvent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox ckbRefundable;
    private javax.swing.JComboBox<Genre> cmbGenre;
    private javax.swing.JComboBox<String> cmbRating;
    private javax.swing.JComboBox<EventType> cmbType;
    private javax.swing.JLabel lbAgeRating;
    private javax.swing.JLabel lbClassification;
    private javax.swing.JLabel lbDescription;
    private javax.swing.JLabel lbDuration;
    private javax.swing.JLabel lbEventDetails;
    private javax.swing.JLabel lbEventName;
    private javax.swing.JLabel lbGenre;
    private javax.swing.JLabel lbRefundable;
    private javax.swing.JLabel lbStartTime1;
    private javax.swing.JLabel lbType;
    private javax.swing.JPanel pClassification;
    private javax.swing.JPanel pConfirmArea;
    private javax.swing.JPanel pContent1;
    private javax.swing.JPanel pContent2;
    private javax.swing.JPanel pEventDetails;
    private javax.swing.JPanel pForm;
    private javax.swing.JPanel pHeader1;
    private javax.swing.JPanel pHeader2;
    private javax.swing.JPanel pInputs;
    private javax.swing.JPanel pInputs1;
    private javax.swing.JPanel pInputs1a;
    private javax.swing.JPanel pInputs2;
    private javax.swing.JPanel pInputs2a;
    private javax.swing.JPanel pLabels1;
    private javax.swing.JPanel pLabels1a;
    private javax.swing.JPanel pLabels2;
    private javax.swing.JPanel pLabels2a;
    private javax.swing.JScrollPane spDescription;
    private javax.swing.JSpinner spnDuration;
    private javax.swing.JFormattedTextField txtBasePrice;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtEventName;
    // End of variables declaration//GEN-END:variables

}
