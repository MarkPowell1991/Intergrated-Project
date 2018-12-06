package validation;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CustomValidator extends StringValidator {

    private final String regex;
    private boolean followsRegex;
    private boolean actualText = false; 
    
    public CustomValidator(JComponent inputField, int minLenght, int maxLenght, String regex, boolean followsRegex, String msg) {
        super((JFrame)inputField.getTopLevelAncestor(), inputField, minLenght, maxLenght, msg);
        this.regex = regex;
    }
    
    @Override
    public boolean validationCriteria(JComponent component) {
        this.input = ((JTextField) component).getText().toLowerCase();
        if(matchRegex(regex) && followsRegex) {
            return input.length() >= minLenght
                && input.length() <= maxLenght;
        }
        else if(!matchRegex(regex) && !followsRegex) {
            return input.length() >= minLenght
                && input.length() <= maxLenght;
        }
        else return false;                          
    }   
}
