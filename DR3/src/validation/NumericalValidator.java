package validation;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class NumericalValidator extends StringValidator {

    public NumericalValidator(JComponent inputField, int minLenght, int maxLenght, boolean mustContinuous) {
        super((JFrame)inputField.getTopLevelAncestor(), inputField, minLenght, maxLenght,
                "can only contain numbers");
        this.mustContinuous = mustContinuous;
    }

    @Override
    public boolean validationCriteria(JComponent component) {
        this.input = ((JTextField) component).getText().toLowerCase(); 
        
        if(mustContinuous) {
            return matchRegex("[(!\\s+)0-9]*")
                && input.length() >= minLenght
                && input.length() <= maxLenght;   
        }
        else {
            return matchRegex("[0-9]*")
                && input.length() >= minLenght
                && input.length() <= maxLenght; 
        }                                   
    }
}
