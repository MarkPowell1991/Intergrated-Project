/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 * An interface to make a class a "subject which can be observed"
 * @author rtucker
 */
public interface ISubject {
    
    Boolean registerObserver(IObserver o);
    Boolean removeObserver(IObserver o);
    void notifyObservers();
    
}
