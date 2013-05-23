/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SubcalcData;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author g96930
 */
public class CalcData {
    
    //Subnet Mask Variables

    public int mOct1, mOct2, mOct3, mOct4;
    //IP Address Variables
    public int ipOct1, ipOct2, ipOct3, ipOct4;
    public int hostBits, ipAddress;
    ArrayList<Integer> ipRange = new ArrayList<>();

    public boolean maskVerify() {
        if ((mOct1 == 0 || mOct1 == 128 || mOct1 == 192 || mOct1 == 224 || mOct1 == 240 || mOct1 == 248 || mOct1 == 252 || mOct1 == 254 || mOct1 == 255)
                && (mOct2 == 0 || mOct2 == 128 || mOct2 == 192 || mOct2 == 224 || mOct2 == 240 || mOct2 == 248 || mOct2 == 252 || mOct2 == 254 || mOct2 == 255)
                && (mOct3 == 0 || mOct3 == 128 || mOct3 == 192 || mOct3 == 224 || mOct3 == 240 || mOct3 == 248 || mOct3 == 252 || mOct3 == 254 || mOct3 == 255)
                && (mOct4 == 0 || mOct4 == 128 || mOct4 == 192 || mOct4 == 224 || mOct4 == 240 || mOct4 == 248 || mOct4 == 252 || mOct4 == 254 || mOct4 == 255)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a proper Mask address");
            System.out.println("mask verify");
            return false;
        }
    }

    public int maskCalculate(int mask) {
        System.out.println("mask calculate");
        if (mask == 0) {
            return 8;
        } else if (mask == 128) {
            return 7;
        } else if (mask == 192) {
            return 6;
        } else if (mask == 224) {
            return 5;
        } else if (mask == 240) {
            return 4;
        } else if (mask == 248) {
            return 3;
        } else if (mask == 252) {
            return 2;
        } else if (mask == 254) {
            return 1;
        } else {
            return 0;
        }
    }

    public int ipCalc(int mask) {
        System.out.println("ip calc");
        if (mask == 0) {
            return 1;
        } else if (mask == 128) {
            return 2;
        } else if (mask == 192) {
            return 4;
        } else if (mask == 224) {
            return 8;
        } else if (mask == 240) {
            return 16;
        } else if (mask == 248) {
            return 32;
        } else if (mask == 252) {
            return 64;
        }
        return 0;
    }

    public void broadcastCalc(int mask) {

        if (mask != 0) {
            System.out.println("ipCalc " + ipCalc(mask));
            ipAddress = ipCalc(mask);
            for (int i = 0; i < ipAddress; i++) {   
                int result = ipAddress * i;
                ipRange.add(result);
                System.out.println("if result" + result);
            }
        } else {
            ipRange.add(0);
            ipRange.add(255);
            System.out.println("else");
        }
        
    }
}
