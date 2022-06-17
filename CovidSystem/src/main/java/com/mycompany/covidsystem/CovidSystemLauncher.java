 package com.mycompany.covidsystem;

/**
 * This class acts as a client and is responsible for launching the system
 * Uses the singleton ControlPanel object to navigate pages
 * The singleton ControlPanel object acts as a facade
 */
public class CovidSystemLauncher {

    // Launch the system
    public static void main(String[] args) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                // Create the singleton ControlPanel object
                ControlPanel.getControlPanel();
                
                // Launch the system
                ControlPanel.getControlPanel().launchSystem();
            }
        });
    }
}