/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadocliente;

import client.Cliente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author j4v13
 */
public class AhorcadoCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            new Cliente();
        } catch (IOException ex) {
            Logger.getLogger(AhorcadoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AhorcadoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
