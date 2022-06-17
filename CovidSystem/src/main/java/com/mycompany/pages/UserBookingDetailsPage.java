package com.mycompany.pages;

// Import(s)
import com.mycompany.api.APIFactory;
import com.mycompany.api.FactoryCreator;
import com.mycompany.api.Get;
import com.mycompany.api.Patch;
import com.mycompany.covidsystem.ControlPanel;
import com.mycompany.entity.Booking;
import com.mycompany.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * This class represents the user's booking details page
 */
public class UserBookingDetailsPage extends javax.swing.JPanel {
    
    // Manually included variable(s)
    private static final ControlPanel controlPanel = ControlPanel.getControlPanel();
    private static final APIFactory<Booking> bookingFactory = FactoryCreator.getBookingFactory();
    private List<Booking> bookings = new ArrayList<>();
    private Booking currentBooking;
    public static final String CANCELLED = "CANCELLED";

    /**
     * Creates new form UserBookingDetailsPage
     */
    public UserBookingDetailsPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bookingDetailsLabel = new javax.swing.JLabel();
        bookingIdLabel = new javax.swing.JLabel();
        customerLabel = new javax.swing.JLabel();
        testingSiteLabel = new javax.swing.JLabel();
        createdAtLabel = new javax.swing.JLabel();
        updatedAtLabel = new javax.swing.JLabel();
        startTimeLabel = new javax.swing.JLabel();
        smsPinLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        notesLabel = new javax.swing.JLabel();
        bookingIdTextField = new javax.swing.JTextField();
        customerNameTextField = new javax.swing.JTextField();
        testingSiteNameTextField = new javax.swing.JTextField();
        createdAtTextField = new javax.swing.JTextField();
        updatedAtTextField = new javax.swing.JTextField();
        startTimeTextField = new javax.swing.JTextField();
        smsPinTextField = new javax.swing.JTextField();
        statusTextField = new javax.swing.JTextField();
        notesTextField = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        modifyBookingBtn = new javax.swing.JButton();
        cancelBookingBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        bookingDetailsLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        bookingDetailsLabel.setText("Booking Details");

        bookingIdLabel.setText("Booking ID:");

        customerLabel.setText("Customer:");

        testingSiteLabel.setText("Testing Site:");

        createdAtLabel.setText("Created At:");

        updatedAtLabel.setText("Updated At:");

        startTimeLabel.setText("Start Time:");

        smsPinLabel.setText("SMS PIN:");

        statusLabel.setText("Status:");

        notesLabel.setText("Notes:");

        bookingIdTextField.setEditable(false);

        customerNameTextField.setEditable(false);

        testingSiteNameTextField.setEditable(false);

        createdAtTextField.setEditable(false);

        updatedAtTextField.setEditable(false);

        startTimeTextField.setEditable(false);

        smsPinTextField.setEditable(false);

        statusTextField.setEditable(false);

        notesTextField.setEditable(false);

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        modifyBookingBtn.setText("Modify Booking");
        modifyBookingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBookingBtnActionPerformed(evt);
            }
        });

        cancelBookingBtn.setText("Cancel Booking");
        cancelBookingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBookingBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(cancelBookingBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modifyBookingBtn)
                .addGap(124, 124, 124))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(smsPinLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(smsPinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bookingDetailsLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startTimeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(startTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(updatedAtLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updatedAtTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookingIdLabel)
                            .addComponent(customerLabel)
                            .addComponent(testingSiteLabel)
                            .addComponent(createdAtLabel))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bookingIdTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(customerNameTextField)
                                    .addComponent(testingSiteNameTextField)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createdAtTextField))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statusLabel)
                            .addComponent(notesLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statusTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notesTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addGap(58, 58, 58))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bookingIdTextField, createdAtTextField, customerNameTextField, notesTextField, smsPinTextField, startTimeTextField, statusTextField, testingSiteNameTextField, updatedAtTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookingDetailsLabel)
                    .addComponent(backBtn))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookingIdLabel)
                    .addComponent(bookingIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerLabel)
                    .addComponent(customerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(testingSiteLabel)
                    .addComponent(testingSiteNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createdAtLabel)
                    .addComponent(createdAtTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updatedAtLabel)
                    .addComponent(updatedAtTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startTimeLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(smsPinLabel)
                    .addComponent(smsPinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel)
                    .addComponent(statusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notesLabel)
                    .addComponent(notesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBookingBtn)
                    .addComponent(modifyBookingBtn))
                .addGap(56, 56, 56))
        );
    }// </editor-fold>//GEN-END:initComponents

    // This method allows the user to navigate to different pages
    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        controlPanel.showCustomerPage();
    }//GEN-LAST:event_backBtnActionPerformed

    // This method patches the status of a booking
    private void cancelBookingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBookingBtnActionPerformed
        // Set the status of booking to "CANCELLED"
        // This ensures that the booking cannot be modified in the future
        try
        {
            Patch bookingPatch = bookingFactory.createPatch();
            bookingPatch.createPatchRequest(CANCELLED, currentBooking.getId());
            JOptionPane.showMessageDialog(null, "Booking has been cancelled successfully", "Successful Cancellation", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        // After cancelling a booking, call web service again to get the updated list of bookings
        try
        {
            Get<Booking> bookingGet = bookingFactory.createGet();
            bookings = bookingGet.createGetRequest();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cancelBookingBtnActionPerformed

    // This method leads to the ModifyBookingPage
    private void modifyBookingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyBookingBtnActionPerformed
        controlPanel.showModifyBookingPage(currentBooking);
    }//GEN-LAST:event_modifyBookingBtnActionPerformed

    // This method shows the details of the selected active booking
    public void showBookingDetailsInformation(Booking booking, User user){
        currentBooking = booking;
        bookingIdTextField.setText(booking.getId());
        customerNameTextField.setText(user.getFamilyName() + " " + user.getGivenName());
        testingSiteNameTextField.setText(booking.getTestingSite().getName());
        createdAtTextField.setText(booking.getCreatedAt());
        updatedAtTextField.setText(booking.getUpdatedAt());
        startTimeTextField.setText(booking.getStartTime());
        smsPinTextField.setText(booking.getSmsPin());
        statusTextField.setText(booking.getStatus());
        notesTextField.setText(booking.getNotes());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel bookingDetailsLabel;
    private javax.swing.JLabel bookingIdLabel;
    private javax.swing.JTextField bookingIdTextField;
    private javax.swing.JButton cancelBookingBtn;
    private javax.swing.JLabel createdAtLabel;
    private javax.swing.JTextField createdAtTextField;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JTextField customerNameTextField;
    private javax.swing.JButton modifyBookingBtn;
    private javax.swing.JLabel notesLabel;
    private javax.swing.JTextField notesTextField;
    private javax.swing.JLabel smsPinLabel;
    private javax.swing.JTextField smsPinTextField;
    private javax.swing.JLabel startTimeLabel;
    private javax.swing.JTextField startTimeTextField;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField statusTextField;
    private javax.swing.JLabel testingSiteLabel;
    private javax.swing.JTextField testingSiteNameTextField;
    private javax.swing.JLabel updatedAtLabel;
    private javax.swing.JTextField updatedAtTextField;
    // End of variables declaration//GEN-END:variables
}
