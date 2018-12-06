/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author mpowell1
 */
public class ReEntryValidator extends StringValidator {
    
    JComponent otherField;

    public ReEntryValidator(JComponent inputField, int minLenght, int maxLenght, JComponent otherField, String msg) {
        super((JFrame)inputField.getTopLevelAncestor(), inputField, minLenght, maxLenght, msg);
        this.otherField = otherField;
    }

    @Override
    protected boolean validationCriteria(JComponent component) {
        this.input = ((JTextField) component).getText(); 
        String matchAgainst = ((JTextField) otherField).getText();
        return input.equals(matchAgainst);
    }    
}
