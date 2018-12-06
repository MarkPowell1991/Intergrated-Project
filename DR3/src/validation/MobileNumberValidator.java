package validation;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MobileNumberValidator extends StringValidator {

    public MobileNumberValidator(JComponent inputField) {
        super((JFrame) inputField.getTopLevelAncestor(), inputField, 0, 11,
                "can only contain numbers");
        this.mustContinuous = true;
    }

    @Override
    public boolean validationCriteria(JComponent component) {
        this.input = ((JTextField) component).getText().toLowerCase();

        if (input.isEmpty()) {
            return true;
        } else {
            return matchRegex("[(!\\s+)0-9]{11}");
        }
    }
}