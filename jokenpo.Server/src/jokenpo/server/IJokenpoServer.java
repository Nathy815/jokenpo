/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokenpo.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author nathy
 */
public interface IJokenpoServer extends Remote {
    Boolean PlayWithCPU(String name) throws RemoteException;
    Boolean PlayWithPlayer(String name) throws RemoteException;
    void Sair() throws RemoteException;
}
