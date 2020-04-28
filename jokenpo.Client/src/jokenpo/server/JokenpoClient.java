/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokenpo.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import jokenpo.client.Jogo;

/**
 *
 * @author nathy
 */
public class JokenpoClient {

    public Boolean Server_PlayWithCPU(String name) 
    {
        try 
        {
            Registry registry = LocateRegistry.getRegistry("localhost", 18000);
            IJokenpoServer stub = (IJokenpoServer) registry.lookup("Jokenpo");
            return stub.PlayWithCPU(name);
        } 
        catch (Exception e) 
        {
            System.err.println("Exceção do Cliente: " + e.toString());
            //e.printStackTrace();
            return null;
        }
    }
 
    public Boolean Server_PlayWithPlayer(String name)
    {
        try 
        {
            Registry registry = LocateRegistry.getRegistry("localhost", 18000);
            IJokenpoServer stub = (IJokenpoServer) registry.lookup("Jokenpo");
            return stub.PlayWithPlayer(name);
            
        } 
        catch (Exception e) {
            System.err.println("Exceção do Cliente: " + e.toString());
            //e.printStackTrace();
            return null;
        }
    }
    
    public void Sair()
    {
        try 
        {
            Registry registry = LocateRegistry.getRegistry("localhost", 18000);
            IJokenpoServer stub = (IJokenpoServer) registry.lookup("Jokenpo");
            stub.Sair();
        } 
        catch (Exception e) {
            System.err.println("Exceção do Cliente: " + e.toString());
            //e.printStackTrace();
        }
    }
}
