package validation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class handles most of the details of validating a component, including all display elements
 * such as popup help boxes and color changes.
 */
public abstract class Validator extends InputVerifier implements KeyListener {

    private Object parent;
    private JDialog popup;
    private Color popupBackground;    
    private JLabel icon;
    private JLabel message;       

    private Validator(JComponent component, String msg) {
        component.addKeyListener(this);
        popupBackground = new Color(242,242,242);
        icon = new JLabel(new ImageIcon(getClass().getResource("/graphics/validationFail.png")));

        message = new JLabel("<html>" + msg.replaceAll("\n", " <br>") + " ");    
        
        message.setForeground(new Color(180,0,0));
    }

    /**
     * @param frame A JFrame that implements the ValidationCapable interface.
     * @param component The JComponent to be validated.
     * @param msg A message to be displayed in the popup help tip if validation fails.
     */
    public Validator(JFrame frame, JComponent component, String msg) {
        this(component, msg);
        this.parent = frame;
        popup = new JDialog(frame);
        
        initComponents();
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

            if (parent instanceof IValidationStatus) {
                ((IValidationStatus) parent).validateFailed();
            }

            component.setBackground(new Color(255, 238, 238));

            popup.setSize(0, 0);
            popup.setLocationRelativeTo(component);
            Point point = popup.getLocation();

            popup.setLocation(point.x + (int) component.getSize().getWidth() / 2,
                    point.y - (int) component.getSize().getHeight() / 2 - 1);

            popup.pack();
            popup.setVisible(true);

            return false;
        } else {

            if (parent instanceof IValidationStatus) {
                ((IValidationStatus) parent).validatePassed();
            }            
            component.setBackground(new Color(224, 255, 224));
            popup.dispose();

            return true;
        }

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

    private void initComponents() {
        popup.getContentPane().setLayout(new FlowLayout());
        popup.setUndecorated(true);
        popup.getContentPane().setBackground(popupBackground);
        popup.getContentPane().add(icon);
        popup.getContentPane().add(message);
        popup.setFocusableWindowState(false);
        popup.setAlwaysOnTop(true);        
        
    }
}
