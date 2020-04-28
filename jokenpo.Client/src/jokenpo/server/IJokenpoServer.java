/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokenpo.server;

import java.rmi.Remote;

/**
 *
 * @author nathy
 */
public interface IJokenpoServer extends Remote {
    Boolean PlayWithCPU(String name);
    Boolean PlayWithPlayer(String name);
    void Sair();
}
