/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokenpo.model;

import jokenpo.model.Jogador;
import jokenpo.server.IJokenpoServer;

/**
 *
 * @author nathy
 */
public class Partida {
    
    private Jogador player1;
    
    private Jogador player2;
    
    public Partida()
    {
        player1 = null;
        player2 = null;
    }
            
    public Jogador getPlayer1()
    {
        return this.player1;
    }
    
    public Jogador getPlayer2()
    {
        return this.player2;
    }
    
    public void Adicionar(IJokenpoServer jokenpo, String name)
    {
        if (player1 == null)
            player1 = new Jogador(1, jokenpo, name);
        else
            player2 = new Jogador(2, jokenpo, name);
    }
    
    public boolean IsEmpty()
    {
        if (player1 == null || player2 == null)
            return true;
        return false;
    }
}
