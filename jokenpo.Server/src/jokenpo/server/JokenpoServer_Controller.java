/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokenpo.server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 *
 * @author nathy
 */
public class JokenpoServer_Controller implements IJokenpoServer {

    ArrayList<Partida> partidas;
    
    public JokenpoServer_Controller() throws RemoteException {
        partidas = new ArrayList<Partida>();
    }
    
    public static void main(String[] arg) throws RemoteException, MalformedURLException {
        
        JokenpoServer_Controller server = new JokenpoServer_Controller();
        
        Registry registry = LocateRegistry.createRegistry(18000);
        registry.rebind("Jokenpo", server);

    }
    
    @Override
    public int Connect(IJokenpoServer player, String name) throws RemoteException {
        for (int i = 0; i < partidas.size(); i++)
        {
            if (partidas.get(i).IsEmpty())
            {
                partidas.get(i).Adicionar(player, name);
                return i;
            }
        }
        
        Partida partida = new Partida();
        partida.Adicionar(player, name);
        partidas.add(partida);
        return partidas.size() - 1;
    }

    @Override
    public String PlayOnline(IJokenpoServer player, int index) throws RemoteException {
        Partida partida = partidas.get(index);
        if (partida.getPlayer1() == player)
            return partida.getPlayer2().getName();
        else
            return partida.getPlayer1().getName();
    }
    
}
