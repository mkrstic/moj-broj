/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author mladen
 */
public class TestGame {

    public static void main(String[] args) {
        while (true) {
        MyNumberGame game = new MyNumberGame();
        Scanner in = new Scanner(System.in);
        System.out.print("\nKoliko operanada? ");
        int n = in.nextInt();
        Integer[] operands = new Integer[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i+1) + ". operand: ");
            operands[i] = in.nextInt();
        }
        System.out.print("Trazeni rezultat: ");
        int targetValue = in.nextInt();
        game.setOperands(operands);
        game.setTargetValue(targetValue);
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = new Date();
            game.play();
            endTime = new Date();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return;
        }
        long timeDiff = endTime.getTime()-startTime.getTime();
        if (game.isFoundExp())
            System.out.println("*** Pronadjen izraz: " + game.getWinningExp());
        else
            System.out.println("*** Nije pronadjen izraz.");
        System.out.println("*** Proslo vremena: " + timeDiff + " ms");
    }
    }
}
