/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokenpo.server;

import java.rmi.RemoteException;

/**
 *
 * @author nathy
 */
public class JokenpoServer_Controller implements IJokenpoServer {

    @Override
    public Boolean PlayWithCPU(String name) throws RemoteException {
        System.out.println(name + " escolheu jogar com CPU");
        return true;
    }

    @Override
    public Boolean PlayWithPlayer(String name) throws RemoteException {
        System.out.println(name + " escolheu jogar com outro jogador");
        return false;
    }
    
    @Override
    public void Sair() throws RemoteException {
        System.out.println("Jogador saiu.");
    }
}
