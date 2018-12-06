/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class AlphabeticalValidator extends StringValidator {

    public AlphabeticalValidator(JComponent inputField, int minLenght, int maxLenght, boolean mustContinuous) {
        super((JFrame)inputField.getTopLevelAncestor(), inputField, minLenght, maxLenght,
                "can only contain alphabetical characters");
        this.mustContinuous = mustContinuous;
    }
    
    @Override
    public boolean validationCriteria(JComponent component) {                       
        this.input = ((JTextField) component).getText().toLowerCase(); 
        
        if(mustContinuous) {
            return !matchRegex("^[a-z]*[\\s+0-9!£$&-_*:;'`¬¦|()~#@*+%{}<>\\[\\]|\"\\_^]+[a-z]*$")                
                && input.length() >= minLenght
                && input.length() <= maxLenght; 
        }
        else {
            return !matchRegex("^[a-z]*[0-9!£$&-_*:;'`¬¦|()~#@*+%{}<>\\[\\]|\"\\_^]+[a-z]*$")                
                && input.length() >= minLenght
                && input.length() <= maxLenght; 
        }                               
    }
}
