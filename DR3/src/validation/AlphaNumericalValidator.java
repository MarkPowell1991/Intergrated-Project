package validation;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class AlphaNumericalValidator extends StringValidator {

    public AlphaNumericalValidator(JComponent inputField, int minLenght, int maxLenght, boolean mustContinuous ) {
        super((JFrame)inputField.getTopLevelAncestor(), inputField, minLenght, maxLenght,
                "cannot contain any special characters");
        this.mustContinuous = mustContinuous;
    }

    @Override
    public boolean validationCriteria(JComponent component) {
        this.input = ((JTextField) component).getText().toLowerCase(); 
        
        if(mustContinuous) {
            return matchRegex("[0-9a-z]*")
                && input.length() >= minLenght
                && input.length() <= maxLenght;  
        }
        else {
            return matchRegex("[\\s+0-9a-z]*")
                && input.length() >= minLenght
                && input.length() <= maxLenght;  
        }                          
    }
}
