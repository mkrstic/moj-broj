/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package program;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author mladen
 */
public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new WindowsLookAndFeel());
                } catch (Exception ex1) {
                    try {
                        UIManager.setLookAndFeel(new NimbusLookAndFeel());
                    } catch (Exception ex2) {}
                }
                MyNumberForm myNumberForm = new MyNumberForm();
                java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
                java.awt.Rectangle abounds = myNumberForm.getBounds();
                myNumberForm.setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
                myNumberForm.setVisible(true);
            }
        });
    }
}
