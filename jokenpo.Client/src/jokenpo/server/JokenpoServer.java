/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokenpo.server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author nathy
 */
public class JokenpoServer extends UnicastRemoteObject implements Runnable {

    IJokenpoServer stub;
    String name = "";
    int partida = -1;
    int jogador = -1;
    
    public JokenpoServer(String name) throws RemoteException, NotBoundException
    {
        System.out.println("Entrou");
        this.name = name;
        Registry registry = LocateRegistry.getRegistry("localhost", 18000);
        stub = (IJokenpoServer)registry.lookup("Jokenpo");
        formatReturn(stub.Connect(stub, name));
    }

    @Override
    public void run() {
        if (partida >= 0 && jogador >= 0)
            System.err.println("Cliente pronto");
        else
            System.err.println("Erro ao conectar-se com o servidor");
    }
    
    private void formatReturn(String result)
    {
        if (result != null)
        {
            String[] valor = result.split("-");
            partida = Integer.parseInt(valor[0]);
            jogador = Integer.parseInt(valor[1]);
        }
    }
    
    public String PlayOnline()
    {
        try
        {
            return stub.PlayOnline(partida, jogador);
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    
    public String Jogar(String jogada)
    {
        try
        {
            return stub.Jogar(partida, jogador, jogada);
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    
    public String Oponente()
    {
        try
        {
            return stub.getJogadaOponente(partida, jogador);
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    
    public boolean Sair()
    {
        try
        {
            boolean response = stub.Sair(partida);
            partida = -1;
            jogador = -1;
            return response;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
}
