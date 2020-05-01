/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokenpo.server;

/**
 *
 * @author nathy
 */
public class Partida {
    
    private Jogador player1;
    
    private Jogador player2;
    
    public Partida()
    {
        player1 = new Jogador();
        player2 = new Jogador();
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
        if (player1.getJogador() == null)
        {
            player1.setJogador(jokenpo);
            player1.setName(name);
        }
        else
        {
            player2.setJogador(jokenpo);
            player2.setName(name);
        }
    }
    
    public boolean IsEmpty()
    {
        if (player1.getJogador() == null && player2.getJogador() == null)
            return true;
        return false;
    }
}
