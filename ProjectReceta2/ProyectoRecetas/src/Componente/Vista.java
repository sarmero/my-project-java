/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componente;

import java.util.Observable;
import java.util.Observer;
import view.VentanaPrincipal;

/**
 *
 * @author USER
 */
public class Vista extends Observable {

    private boolean ban;

    public Vista() {
        ban = false;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
        this.setChanged();
        this.notifyObservers(ban);
        this.clearChanged();
    }

}
