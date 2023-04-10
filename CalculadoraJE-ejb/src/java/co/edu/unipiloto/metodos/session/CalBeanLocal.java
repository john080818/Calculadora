/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.metodos.session;

import javax.ejb.Local;

/**
 *
 * @author jhon1
 */
@Local
public interface CalBeanLocal {

    Integer suma(int val1, int val2);
    
}
