/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokenpo.view;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import jokenpo.server.IJokenpoServer;
import jokenpo.server.JokenpoServer_Controller;

/**
 *
 * @author nathy
 */
public class JokenpoServer {
    
    private static final JokenpoServer_Controller controller = new JokenpoServer_Controller();
    
    public static void main(String args[]) {
        try 
        {
            IJokenpoServer stub = (IJokenpoServer) UnicastRemoteObject.exportObject(controller, 0);
            // Binding o objeto remoto (stub) no registro
            Registry registry = LocateRegistry.createRegistry(18000);
            registry.rebind("Jokenpo", stub);

            System.err.println("Servidor Pronto");
        } 
        catch (Exception e) {
            System.err.println("Exceção do Servidor: " + e.toString());
            e.printStackTrace();
        }
    }
    
}
