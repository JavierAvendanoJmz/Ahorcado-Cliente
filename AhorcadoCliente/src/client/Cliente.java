/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import model.Juego;

/**
 *
 * @author j4v13
 */
public class Cliente {

    public Cliente() throws IOException, ClassNotFoundException {
        Socket cliente = new Socket("127.0.0.1",3000);
        
        OutputStream output = cliente.getOutputStream();
        ObjectOutputStream writer = new ObjectOutputStream(output);
        
        InputStream input = cliente.getInputStream();
        ObjectInputStream reader = new ObjectInputStream(input);
        
        Scanner sc = new Scanner(System.in);
        Juego juego = new Juego();

        String palabra = (String)reader.readObject();
        String mensaje = (String)reader.readObject();
        int intentos = (int)reader.readObject();

        juego.setPalabra(palabra);
        juego.setMensaje(mensaje);
        juego.setIntentos(intentos);
        
        do {
            
            System.out.println("Intentos: "+juego.getIntentos());
            System.out.println(juego.getPalabra());
            writer.writeObject(sc.nextLine());      
            
            palabra = (String)reader.readObject();
            mensaje = (String)reader.readObject();
            intentos = (int)reader.readObject();
            
            juego.setPalabra(palabra);
            juego.setMensaje(mensaje);
            juego.setIntentos(intentos);
            
        }while(juego.getIntentos()!=0 && !juego.getMensaje().equals("Logrado"));
        
        System.out.println(juego.getPalabra());
        System.out.println(juego.getMensaje());
        
        writer.close();
        output.close();
        
        reader.close();
        input.close();
        
        cliente.close();
    }
    
}
