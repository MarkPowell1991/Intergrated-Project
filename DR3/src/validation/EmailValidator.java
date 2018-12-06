/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class EmailValidator extends StringValidator {

    public EmailValidator(JComponent inputField) {
        super((JFrame) inputField.getTopLevelAncestor(), inputField, 3, 255,
                "can only contain alphabetical characters");
        this.mustContinuous = false;
    }

    @Override
    public boolean validationCriteria(JComponent component) {
        this.input = ((JTextField) component).getText().toLowerCase();

        return matchRegex("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
                && input.length() >= minLenght
                && input.length() <= maxLenght;
    }
}