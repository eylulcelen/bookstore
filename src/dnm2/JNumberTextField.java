package dnm2;

import javax.swing.*;
import java.awt.event.KeyEvent;

//This extension is used for text fields that exclusively number input
//It prevents the user from typing non-number characters to the text field

public class JNumberTextField extends JTextField {
    private static final long serialVersionUID = 1L;

    @Override
    public void processKeyEvent(KeyEvent ev) {
        char keyPressed = ev.getKeyChar();
        if (Character.isDigit(keyPressed) || keyPressed == KeyEvent.VK_BACK_SPACE) {
            super.processKeyEvent(ev);
        }
        ev.consume();
    }


    public Double getNumber() {
        Double result = null;
        String text = getText();
        if (text != null && !text.isEmpty()) {
            result = Double.valueOf(text);
        }
        return result;
    }
}