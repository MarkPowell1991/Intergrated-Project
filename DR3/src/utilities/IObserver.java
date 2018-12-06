/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 * An interface that allows a class to "observe a subject" and update as the 
 * subject changes state automatically
 * @author rtucker
 */
public interface IObserver {
    
    void update();
    
}
