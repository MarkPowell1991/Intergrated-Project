package validation;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.*;

/**
 * This class handles most of the details of validating a component, including all display elements
 * such as popup help boxes and color changes.
 */
public abstract class StringValidator extends InputVerifier implements KeyListener {

    private Object parent;
    private JDialog popup;
    private ImageIcon icon;
    private String message;
        
    protected String input;    
    protected Color foreground;
    protected Color isValidColor;
    protected Color isInvalidColor;    
    protected boolean mustContinuous;    
    protected final String componentName;         
    protected final int minLenght;
    protected final int maxLenght;

    private StringValidator(JComponent inputField, int minLenght, int maxLenght, String msg) {
        this.componentName = inputField.getName();                    
        this.minLenght = minLenght;
        this.maxLenght = maxLenght;
        this.isValidColor = new Color(224, 255, 224);
        this.isInvalidColor = new Color(255, 238, 238);
        this.foreground = new Color(180, 10, 0);
        this.icon = new ImageIcon(getClass().getResource("/graphics/validationFail.png"));
        this.message = setMessage(inputField.getName(), msg);
        inputField.addKeyListener(this);                
    }

    /**
     * @param frame A JFrame that implements the ValidationCapable interface.
     * @param inputField The JComponent to be validated.
     * @param minLenght
     * @param maxLenght
     * @param msg A message to be displayed in the popup help tip if validation fails.
     */
    public StringValidator(JFrame frame, JComponent inputField, int minLenght, int maxLenght, String msg) {
        this(inputField, minLenght, maxLenght, msg);
        this.parent = frame;
        popup = new dgPopup(frame, icon, message, foreground);
    }
    
    public StringValidator(JFrame frame, JComponent inputField, int minLenght, int maxLenght, String msg, boolean yieldFocus) {
        this(inputField, minLenght, maxLenght, msg);
        this.parent = frame;
        popup = new dgPopup(frame, icon, message, foreground);
    }

    protected boolean matchRegex(String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    
    private String setMessage(String fieldName, String msg){
        String outMessage;
       
        if(minLenght == 0) {
            if(maxLenght == 0) outMessage = fieldName + " " + msg;
            else outMessage = fieldName + " " + msg + " and must be a maximum of " + maxLenght + " characters long.";
        }
        else if(minLenght == maxLenght) {
            outMessage = fieldName + " " + msg + " and must be exactly " + minLenght + " characters long.";
        }
        else {
            outMessage = fieldName + " " + msg + " and must be between " + minLenght + "-"
                + maxLenght + " characters long.";
        }                
        return formatMessage(outMessage, 80);
    }
    
    private String formatMessage(String msg, int maxLineLenght) {        
        String[] words = msg.split("\\s+|\n+");
        String lineBuffer = "";
        String output = "<html>";    

        for (String word : words) {
            if("\n".equals(word)) {
                lineBuffer = "";    // Clear buffer
                output += "<br>";
            }
            else {
                if(lineBuffer.length() + word.length() + 1 > maxLineLenght) {
                    output += lineBuffer + " <br>";
                    lineBuffer = "";
                    lineBuffer += word;
                }
                else if(lineBuffer.length() + word.length() + 1 <= maxLineLenght) {
                    lineBuffer += " " + word;
                }
            }            
        }
        return output += lineBuffer + " ";
    }

    /**
     * Implement the actual validation logic in this method. The method should return false if data
     * is invalid and true if it is valid. It is also possible to set the popup message text with
     * setMessage() before returning, and thus customize the message text for different types of
     * validation problems.
     *
     * @param component The JComponent to be validated.
     * @return false if data is invalid. true if it is valid.
     */
    protected abstract boolean validationCriteria(JComponent component);

    /**
     * This method is called by Java when a component needs to be validated. It should not be called
     * directly. Do not override this method unless you really want to change validation behavior.
     * Implement validationCriteria() instead.
     *
     * @param component
     * @return
     */
    @Override
    public boolean verify(JComponent component) {
        if (!validationCriteria(component)) {
            if (parent instanceof IValidatable) {
                ((IValidatable) parent).validateFailed();
            }
            component.setBackground(isInvalidColor);
            showPopup(component);

            return false;
        } else {
            if (parent instanceof IValidatable) {
                ((IValidatable) parent).validatePassed();
            }
            component.setBackground(isValidColor);
            popup.dispose();

            return true;
        }
    }

    private void showPopup(JComponent component) {
        popup.setSize(0, 0);
        popup.setLocationRelativeTo(component);
        Point location = popup.getLocation();
        Dimension dimension = component.getSize();
        popup.setLocation(location.x - (int) dimension.getWidth() / 2,
                location.y + (int) dimension.getHeight() / 2 + 1);
        popup.pack();
        popup.setVisible(true);

        Dialog p = new dgPopup((JFrame) parent, icon, message, foreground);
    }

    // <editor-fold defaultstate="collapsed" desc="Key Events">
    /**
     * @param e
     * @see KeyListener
     */
    @Override
    public void keyPressed(KeyEvent e) {
        popup.setVisible(false);
    }

    /**
     * @param e
     * @see KeyListener
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * @param e
     * @see KeyListener
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }
    // </editor-fold>
}
