/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokenpo.server;

import jokenpo.model.Partida;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import jokenpo.model.Conexao;

/**
 *
 * @author nathy
 */
public class JokenpoServer_Controller extends UnicastRemoteObject implements IJokenpoServer {

    ArrayList<Partida> partidas;
    
    public JokenpoServer_Controller() throws RemoteException {
        partidas = new ArrayList<Partida>();
    }
    
    public static void main(String[] arg) throws RemoteException, MalformedURLException {
        
        JokenpoServer_Controller server = new JokenpoServer_Controller();
        
        Registry registry = LocateRegistry.createRegistry(18000);
        registry.rebind("Jokenpo", server);
        
        System.err.println("Servidor pronto");
    }
    
    @Override
    public synchronized String Connect(IJokenpoServer player, String name) throws RemoteException {
        
        for (int i = 0; i < partidas.size(); i++)
        {
            if (partidas.get(i).IsEmpty())
            {
                partidas.get(i).Adicionar(player, name);
                return i + "-2";
            }
        }
        
        Partida partida = new Partida();
        partida.Adicionar(player, name);
        partidas.add(partida);
        return (partidas.size() - 1) + "-1";
    }

    @Override
    public synchronized String PlayOnline(int index, int jogador) throws RemoteException {
        Partida partida = partidas.get(index);
        if (partida.IsEmpty())
            return null;
        else
        {
            if (jogador == 1)
                return partida.getPlayer2().getName();
            else
                return partida.getPlayer1().getName();
        }
    }

    @Override
    public String Jogar(int index, int jogador, String jogada) throws RemoteException {
        Partida partida = partidas.get(index);
        if (jogador == 1)
        {
            System.out.println("Jogador 1 escolheu " + jogada);
            partida.getPlayer1().setJogada(jogada);
            return partida.getPlayer2().getJogada();
        }
        else
        {
            System.out.println("Jogador 2 escolheu " + jogada);
            partida.getPlayer2().setJogada(jogada);
            return partida.getPlayer1().getJogada();
        }
    }

    @Override
    public String getJogadaOponente(int index, int jogador) throws RemoteException {
        Partida partida = partidas.get(index);
        String jogada = null;
        if (jogador == 1)
        {
            System.out.println("Resposta para Jogador 1 é " + partida.getPlayer2().getJogada());
            jogada = partida.getPlayer2().getJogada();
        }
        else
        {
            System.out.println("Resposta para Jogador 2 é " + partida.getPlayer1().getJogada());
            jogada = partida.getPlayer1().getJogada();
        }
        
        LimparRodada(partida);
        return jogada;
    }
    
    private void LimparRodada(Partida partida)
    {
        if (partida.getPlayer1().getJogada() != null &&
            partida.getPlayer2().getJogada() != null)
        {
            partida.getPlayer1().setJogada(null);
            partida.getPlayer2().setJogada(null);
        }
    }
}
