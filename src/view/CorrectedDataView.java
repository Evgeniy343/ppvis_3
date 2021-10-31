package view;

import javax.swing.*;
import java.nio.charset.StandardCharsets;

public class CorrectedDataView {
    public static boolean printBMessage(JTextField[] data) {
        for (int j = 0; j < data.length; j++) {
            String sData = data[j].getText();
            for (int i = 0; i < sData.length(); i++) {
                if (!isDigit(sData, i)) {
                    String message = "Incorrect params entered!";
                    JOptionPane.showMessageDialog(null, message, "Error!", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean printAMessage(JTextField data) {
        String sData = data.getText();
        for (int i = 0; i < sData.length(); i++) {
            if (!isDigit(sData, i)) {
                String message = "Incorrect params entered!";
                JOptionPane.showMessageDialog(null, message, "Error!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public static boolean isDigit(String sData, int i) {
        byte[] bytes = sData.getBytes(StandardCharsets.US_ASCII);
        return (bytes[i] > 48 && bytes[i] < 57) || bytes[i] == 45;
    }
}
