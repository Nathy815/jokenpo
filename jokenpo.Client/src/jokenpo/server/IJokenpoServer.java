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
    String Connect(IJokenpoServer player, String name) throws RemoteException;
    String PlayOnline(int index, int jogador) throws RemoteException;
    String Jogar(int index, int jogador, String jogada) throws RemoteException;
    String getJogadaOponente(int index, int jogador) throws RemoteException;
    boolean Sair(int index) throws RemoteException;
}
