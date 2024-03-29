/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MyNumberGame.java
 *
 * Created on Apr 7, 2011, 11:34:59 AM
 */
package program;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import game.MyNumberGame;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/**
 *
 * @author mladen
 */
public class MyNumberForm extends javax.swing.JFrame {

    private BackgroundWorker worker;
    private final Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/favicon.png"));
    private Date startTime;
    private MyNumberGame game;

    /** Creates new form MyNumberGame */
    public MyNumberForm() {
        initComponents();
        this.setIconImage(image);
        statusPanel.setVisible(false);
        cancelButton.setVisible(false);
        startTime = new Date();
        game = new MyNumberGame();
        operandsTextField.requestFocus();
    }

   
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        operandsTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        targetValueTextField = new javax.swing.JTextField();
        playButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        statusPanel = new javax.swing.JPanel();
        progressBar = new javax.swing.JProgressBar();
        statusLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newGameMenuItem = new javax.swing.JMenuItem();
        newRandomGameMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        rulesMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Moj broj");
        setResizable(false);

        operandsTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                operandsTextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                operandsTextFieldKeyTyped(evt);
            }
        });

        jLabel2.setText("Operandi (razdvojeni zarezom):");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setText("Moj broj");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel3.setText("Igra pogađanja izraza. ");

        jLabel4.setText("Rezultujuća vrednost:");

        targetValueTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                targetValueTextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                targetValueTextFieldKeyTyped(evt);
            }
        });

        playButton.setMnemonic('p');
        playButton.setText("Pronađi izraz");
        playButton.setPreferredSize(new java.awt.Dimension(93, 27));
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        clearButton.setMnemonic('o');
        clearButton.setText("Poništi");
        clearButton.setPreferredSize(new java.awt.Dimension(73, 27));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        progressBar.setIndeterminate(true);

        statusLabel.setText("Tražim...");

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/exit.png"))); // NOI18N
        cancelButton.setToolTipText("Prekini operaciju");
        cancelButton.setBorder(null);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(cancelButton)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton)
                    .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(statusLabel)))
                .addContainerGap())
        );

        fileMenu.setMnemonic('i');
        fileMenu.setText("Igra");

        newGameMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newGameMenuItem.setMnemonic('n');
        newGameMenuItem.setText("Nova");
        newGameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newGameMenuItem);

        newRandomGameMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        newRandomGameMenuItem.setMnemonic('o');
        newRandomGameMenuItem.setText("Nova, sa slučajnim vrednostima");
        newRandomGameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRandomGameMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newRandomGameMenuItem);
        fileMenu.add(jSeparator2);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setMnemonic('i');
        exitMenuItem.setText("Izađi");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setMnemonic('p');
        helpMenu.setText("Pomoć");

        rulesMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        rulesMenuItem.setMnemonic('p');
        rulesMenuItem.setText("Pravila");
        rulesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rulesMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(rulesMenuItem);

        aboutMenuItem.setMnemonic('o');
        aboutMenuItem.setText("O programu");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playButton, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(targetValueTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(operandsTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(operandsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addComponent(targetValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        operandsTextField.setText("");
        targetValueTextField.setText("");
        operandsTextField.requestFocus();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void newGameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameMenuItemActionPerformed
        clearButtonActionPerformed(evt);
    }//GEN-LAST:event_newGameMenuItemActionPerformed

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        if (worker != null && !worker.isDone()) {
            cancelButtonActionPerformed(evt);
        }
        Integer[] operands = null;
        Integer targetValue = null;
        try {
            String[] strOperands = operandsTextField.getText().trim().split(",");
            if (strOperands.length < 2 || strOperands.length > 6) {
                throw new IllegalArgumentException("There is more than six operands");
            }
            operands = new Integer[strOperands.length];
            for (int i = 0; i < strOperands.length; i++) {
                operands[i] = Integer.valueOf(strOperands[i].trim());
                if (operands[i] <= 0) {
                    throw new IllegalArgumentException("Operand is not natural number");
                }
            }
            targetValue = Integer.valueOf(targetValueTextField.getText().trim());
        } catch (IllegalArgumentException iae) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Neispravan unos. Molimo, pročitajte pravila igre.", "Upozorenje", JOptionPane.ERROR_MESSAGE);
            return;
        }
        startTime.setTime(System.currentTimeMillis());
        game.setOperands(operands);
        game.setTargetValue(targetValue);
        worker = new BackgroundWorker(game, this);
        worker.execute();
        statusPanel.setVisible(true);
        cancelButton.setVisible(true);
    }//GEN-LAST:event_playButtonActionPerformed

    private void newRandomGameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRandomGameMenuItemActionPerformed
        clearButtonActionPerformed(evt);
        Random rand = new Random();
        int numOperands = rand.nextInt(4) + 3; // pseudo-random in (3,6) interval
        Integer[] operands = new Integer[numOperands];
        for (int i = 0; i < numOperands; i++) {
            operands[i] = rand.nextInt(10) + 1; // pseudo-random in (1,150) interval
        }
        int operandsSum = operands[0];
        for (int i = 1; i < operands.length; i++) {
            operandsSum += operands[i];
        }
        Integer targetValue = rand.nextInt(operandsSum + 20) + (operandsSum/3);
        StringBuilder strOperands = new StringBuilder("");
        for (int i = 0; i < numOperands; i++) {
            strOperands.append(operands[i]);
            if (i < numOperands - 1) {
                strOperands.append(", ");
            }
        }
        String strTargetValue = String.valueOf(targetValue);
        operandsTextField.setText(strOperands.toString());
        targetValueTextField.setText(strTargetValue);
    }//GEN-LAST:event_newRandomGameMenuItemActionPerformed

    private void rulesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rulesMenuItemActionPerformed
        RulesDialog rulesDlg = new RulesDialog(this, true);
        rulesDlg.setVisible(true);
    }//GEN-LAST:event_rulesMenuItemActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if (worker != null) {
            if (!worker.isDone()) {
                worker.cancel(true);
            }
            statusPanel.setVisible(false);
            cancelButton.setVisible(false);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void targetValueTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_targetValueTextFieldKeyReleased
        Character c = evt.getKeyChar();
        boolean isValid = Character.isDigit(c) || !Character.isSpaceChar(c) || Character.isWhitespace(c) || evt.isControlDown() || evt.isShiftDown() || evt.isAltDown() || evt.isMetaDown();
        if (!isValid) {
            targetValueTextField.setText(targetValueTextField.getText().replaceAll(String.valueOf(c), ""));
        }
    }//GEN-LAST:event_targetValueTextFieldKeyReleased

    private void operandsTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_operandsTextFieldKeyReleased
        Character c = evt.getKeyChar();
        boolean isValid = Character.isDigit(c) || c == ',' || Character.isSpaceChar(c) || Character.isWhitespace(c) || evt.isControlDown() || evt.isShiftDown() || evt.isAltDown() || evt.isMetaDown();
        if (!isValid) {
            operandsTextField.setText(operandsTextField.getText().replaceAll(String.valueOf(c), ""));
        }
    }//GEN-LAST:event_operandsTextFieldKeyReleased

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                AboutDialog aboutDlg = new AboutDialog(null, false);
                aboutDlg.setVisible(true);
            }
        });


    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void targetValueTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_targetValueTextFieldKeyTyped
        Character c = evt.getKeyChar();
        if (c == '\n') { // pressed ENTER
            playButtonActionPerformed(null);
        } 
    }//GEN-LAST:event_targetValueTextFieldKeyTyped

    private void operandsTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_operandsTextFieldKeyTyped
        targetValueTextFieldKeyTyped(evt);
    }//GEN-LAST:event_operandsTextFieldKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    javax.swing.UIManager.setLookAndFeel(new WindowsLookAndFeel());
                    /*java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
                    java.awt.Rectangle abounds = this.getBounds();
                    this.setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);*/
                } catch (Exception ex) {
                }
                new MyNumberForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newGameMenuItem;
    private javax.swing.JMenuItem newRandomGameMenuItem;
    private javax.swing.JTextField operandsTextField;
    private javax.swing.JButton playButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JMenuItem rulesMenuItem;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JTextField targetValueTextField;
    // End of variables declaration//GEN-END:variables

    public void notifyGameOver(String result) {
        Date endTime = new Date();
        long timeDiff = endTime.getTime()-startTime.getTime();
        statusPanel.setVisible(false);
        cancelButton.setVisible(false);
        if (result == null) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Ne postoji izraz za zadate operande.", "Izraz nije pronađen", JOptionPane.INFORMATION_MESSAGE);
        } else if (result.equals("error")) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Neispravan unos. Molimo, pročitajte pravila igre.", "Upozorenje", JOptionPane.ERROR_MESSAGE);
        } else {
            ResultDialog resultDlg = new ResultDialog(this, true);
            resultDlg.setResult(result);
            resultDlg.setTimeSpan(timeDiff);
            resultDlg.setVisible(true);

        }
    }
}

class BackgroundWorker extends SwingWorker<String, Object> {

    private final MyNumberForm form;
    private final MyNumberGame game;

    public BackgroundWorker(MyNumberGame game, MyNumberForm form) {
        this.game = game;

        this.form = form;
    }

    @Override
    protected String doInBackground() throws Exception {
        try {
            game.play();
            return game.getWinningExp();
        } catch (Exception ex) {
            //this.cancel(true);
            return "error";
        }
    }

    @Override
    protected void done() {
        try {
            if (!this.isCancelled()) {
                form.notifyGameOver(get());
            }
        } catch (InterruptedException ex) {
        } catch (ExecutionException ex) {
        }
    }
}
