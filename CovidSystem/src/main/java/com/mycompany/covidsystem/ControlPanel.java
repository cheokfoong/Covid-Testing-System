package com.mycompany.covidsystem;

// Import(s)
import com.mycompany.api.*;
import com.mycompany.entity.*;
import com.mycompany.pages.*;
import java.awt.CardLayout;
import java.sql.Timestamp;
import java.time.Instant;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * This is a class that represents a control panel, which manages the navigation of pages
 * Acts as a facade for the system
 */
public class ControlPanel {
    
    private static final JFrame frame = new JFrame("Covid System");
    private static final CardLayout cl = new CardLayout();
    private static final JPanel panelCont = new JPanel();
    
    private static User currentUser;
    private static final APIFactory<Booking> bookingFactory = FactoryCreator.getBookingFactory();
    private static Get<Booking> getBooking;

    private static final LoginPage loginPage = new LoginPage();
    private static final OnsiteBookingPage onSiteBookingPage = new OnsiteBookingPage();
    private static final OnlineBookingPage onlineBookingPage = new OnlineBookingPage();
    private static final CheckUserStatusPage checkUserStatusPage = new CheckUserStatusPage();
    private static final HomeBookingPage homeBookingPage = new HomeBookingPage();
    private static final SearchTestingSitePage searchTestingSitePage = new SearchTestingSitePage();
    private static final TestSuggestionFormPage testSuggestionFormPage = new TestSuggestionFormPage();
    private static final UserProfilePage userProfilePage = new UserProfilePage();
    private static final UserBookingDetailsPage userModifyBookingPage = new UserBookingDetailsPage();
    private static final SearchBookingPage searchBookingPage = new SearchBookingPage();
    private static final ModifyBookingPage modifyBookingPage = new ModifyBookingPage();
    private static final AdminPanelPage adminPanelPage = new AdminPanelPage();
    private static final AdminModifyBookingPage  adminModifyBookingPage = new AdminModifyBookingPage();
    
    // Singleton
    // Lazy initialization
    private static ControlPanel controlPanel;
    
    // Private constructor to prevent instantiation
    private ControlPanel()
    {

    }
    
    // Get the only instance available
    public static ControlPanel getControlPanel()
    {
        if (controlPanel == null)
        {
            controlPanel = new ControlPanel();
        }
        return controlPanel;
    }
        
    // Method to launch the system
    public void launchSystem()
    {
        frame.setResizable(false);
        panelCont.setLayout(cl);

        // LoginPage
        panelCont.add(loginPage, "1");
        cl.show(panelCont, "1");
        
        // SearchTestingSitePage
        panelCont.add(searchTestingSitePage, "2");

        // TestSuggestionFormPage
        panelCont.add(testSuggestionFormPage, "3");

        // OnsiteBookingPage
        panelCont.add(onSiteBookingPage,"4");
        
        // OnlineBookingPage
        panelCont.add(onlineBookingPage, "5");

        // CheckUserStatusPage
        panelCont.add(checkUserStatusPage, "6");
        
        // HomeBookingPage
        panelCont.add(homeBookingPage, "7");
        
        // UserProfilePage
        panelCont.add(userProfilePage, "8");

        // UserBookingDetailsPage
        panelCont.add(userModifyBookingPage, "9");
        
        // SearchBookingPage
        panelCont.add(searchBookingPage, "10");
        
        // ModifyBookingPage
        panelCont.add(modifyBookingPage, "11");
        
        //AdminPanelPage
        panelCont.add(adminPanelPage, "12");
        
        //AdminModifyBookingPage
        panelCont.add(adminModifyBookingPage, "13");
    
        frame.add(panelCont);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    // Method to set currentUser
    public void setCurrentUser(User user)   {currentUser = user;}
    
    // Method to get currentUser
    public User getCurrentUser()            {return currentUser;}
    
    // Method to display online booking page user interface 
    public void showOnlineBookingPage(TestingSite selectedTestingSite)
    {
        onlineBookingPage.setSelectedTestingSite(selectedTestingSite);
        onlineBookingPage.showSelectedTestingSite();
        onlineBookingPage.setCustomerId(currentUser.getId());
        onlineBookingPage.getDates();
        cl.show(panelCont, "5");
    }
    
    // Method to display home booking page user interface
    public void showHomeBookingPage(TestingSite selectedTestingSite)
    {
        homeBookingPage.setSelectedTestingSite(selectedTestingSite);
        homeBookingPage.showSelectedTestingSite();
        homeBookingPage.setCustomerId(currentUser.getId());
        homeBookingPage.getDates();
        cl.show(panelCont, "7");
    }
    
    // Method to display user profile page user interface
    public void showUserProfilePage(User user)
    {
        userProfilePage.setUserProfileInfo(user);
        userProfilePage.showUserProfileInfo();
        userProfilePage.showUserActiveBookings();
        cl.show(panelCont, "8");
    }

    // Method to display modify booking page user interface
    public void showUserModifyBookingPage(Booking booking, User user)
    {
        userModifyBookingPage.showBookingDetailsInformation(booking, user);
        cl.show(panelCont, "9");
    }
    
    // Method to display search booking page user interface
    public void showSearchBookingPage()
    {       
        searchBookingPage.getBookings();
        cl.show(panelCont, "10");
    }
    
    // Method to display modify booking page user interface for receptionists
    public void showModifyBookingPage(Booking booking)
    {
        modifyBookingPage.setBooking(booking);
        modifyBookingPage.getTestingSites();
        modifyBookingPage.getTimes();
        modifyBookingPage.getPreviousBookings();
        cl.show(panelCont, "11");
    }
    
    // Method to display admin panel page for admins
    public void showAdminPanelPage(com.mycompany.entity.User user){
        adminPanelPage.setAdminUser(user);
        adminPanelPage.getTestingSiteBookings();
        cl.show(panelCont,"12");
    }
    
    // Method for admin to see the modify page for all bookings
    public void showAdminModifyBookingPage(com.mycompany.entity.User user){
        adminModifyBookingPage.setAdminUser(user);
        adminModifyBookingPage.getTestingSiteBookings();
        adminModifyBookingPage.showTestingSiteBookings();
        cl.show(panelCont, "13");
    }
    
    // Method to display testSuggestionFormPage for administerer
    public void showAdministererPage(){
        cl.show(panelCont, "3");
    }
    
    // Method to display loginPage
    public void logOut() {
        cl.show(panelCont,"1");
    }

    // Method to check whether the booking ID is valid
    // If it is valid then check whether it is an active booking
    public void checkBookingIdStatus(String bookingId){
        List<Booking> bookings = new ArrayList();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Instant instantNow = timestamp.toInstant();
               
        try{
            getBooking = bookingFactory.createGet();
            bookings = getBooking.createGetRequest();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        for (Booking booking: bookings){
            if (booking.getId().equals(bookingId)){
 
                if (booking.getCustomer().getId().equals(currentUser.getId())){
                    String startTime = booking.getStartTime();
                    Instant instantBooking = Instant.parse(startTime);
                    int value = instantNow.compareTo(instantBooking); //compare which time is bigger
                                        
                    //If booking date is still valid
                    if(value < 0){
                        if (booking.getStatus().equals("INITIATED") == false)
                        {
                            JOptionPane.showMessageDialog(null, "Booking status is not INITIATED, it can no longer be modified", "Booking Status", JOptionPane.ERROR_MESSAGE);
                        }
                        else
                        {
                            showUserModifyBookingPage(booking, booking.getCustomer());
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Booking date has lapsed and can't be modified" , "Booking Verification", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter a booking Id that is yours" , "Booking Verification", JOptionPane.INFORMATION_MESSAGE);
                }
            }             
        }
    }
    
    // Method that compares the QR code in each booking with the given QR code
    // If they are the same, verify the user and return true
    // If there are no matches, it is invalid, return false
    private boolean verifyUserForRatKit(String qrCode)
    {
        List<Booking> bookings = new ArrayList<>();
        try
        {
            Get<Booking> bookingGet = bookingFactory.createGet();
            bookings = bookingGet.createGetRequest();
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        for (Booking booking: bookings)
        {
            
            // Null checking is done because some bookings do not have QR code
            // Filter the bookings that have QR code
            if (booking.getAdditionalInfo().getQrCode() != null)
            {
                if (booking.getAdditionalInfo().getQrCode().equals(qrCode))
                {
                    try
                    {
                        // Patch the booking
                        // With the information stating that the customer has received a RAT test kit from the testing site
                        Patch bookingPatch = bookingFactory.createPatch();
                        bookingPatch.createPatchRequest(booking.getAdditionalInfo().getQrCode(), booking.getAdditionalInfo().getUrl(), "Received from testing site", booking.getId());
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                        return false;
                    }    
                }
            }
        }
        return false;
    }
    
    // Method to display an option panel for receptionist to select a page for (onsiteBookingPage,checkUserStatusPage)
    public void showReceptionistPage(){
            //Dialog box to choose page
            JPanel panel = new JPanel();
            Object[] options ={"Onsite Booking", "Check User Status", "Verify User For RAT Kit", "Search Booking", "Modify All Bookings" , "Admin Panel"};
            panel.add(new JLabel("Choose a page"));
            int result = JOptionPane.showOptionDialog(null, "Choose a page to proceed", "Receptionist's page", 0, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            switch (result)
            {
                case 0 -> {
                    cl.show(panelCont, "4");
                    return;
            }
                case 1 -> {
                    cl.show(panelCont, "6");
                    return;
            }
                 case 2 -> {
                    String qrCode = JOptionPane.showInputDialog(null, "Scan QR Code:", "User Verification", JOptionPane.INFORMATION_MESSAGE);
                    if (qrCode.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Please show your QR Code", "User Verification", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    boolean verification = verifyUserForRatKit(qrCode);
                    if (verification == true)
                    {
                        JOptionPane.showMessageDialog(null, "User has been verified to receive RAT kit", "User Verification", JOptionPane.INFORMATION_MESSAGE);  
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "User does not exist", "User Verification", JOptionPane.ERROR_MESSAGE);
                    }
                    return;
            }
                 case 3 -> {
                     showSearchBookingPage();
                     return;
            }   
                 case 4 -> {
                     showAdminModifyBookingPage(currentUser);
                     return;
            }
                 case 5 -> {
                     showAdminPanelPage(currentUser);
                     return;
            }
            }
        }
    
    // Method to display an option panel for customer to select a page for (searchTestingSitePage, checkUserStatusPage)
    public void showCustomerPage(){
        
        //Dialog box to choose page
        JPanel panel = new JPanel();

        Object[] options ={"Search Testing Site", "Check User Status", "Profile","Modify Booking"};
        panel.add(new JLabel("Choose a page"));
        int result = JOptionPane.showOptionDialog(null, "Choose a page to proceed", "Customer's page", 0, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        switch (result)
        {
            case 0 -> {
                cl.show(panelCont, "2");
                return;
        }
            case 1 -> {
                cl.show(panelCont, "6");
                return;
        }
            case 2 -> {
                showUserProfilePage(getCurrentUser());
                return;
        }
            case 3 -> {
                String bookingId = JOptionPane.showInputDialog(null, "Check booking Id:", "Booking Verification", JOptionPane.INFORMATION_MESSAGE);
                if (bookingId.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Please enter a booking Id", "Booking Verification", JOptionPane.ERROR_MESSAGE);
                    }
                checkBookingIdStatus(bookingId);
                return;
        }
        }
    }
}
