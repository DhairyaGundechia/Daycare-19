package edu.neu.csye6200.daycare;

import edu.neu.csye6200.daycare.cronservice.EmailReminder;
import edu.neu.csye6200.daycare.view.LandingPageLayout;

public class Driver {
    public static void main(String[] args) {
     java.awt.EventQueue.invokeLater(() -> new LandingPageLayout().setVisible(true));

//        EmailReminder emailReminder = new EmailReminder();
//        emailReminder.emailSender();
    }
}
