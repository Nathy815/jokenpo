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
public class Jogador {
    
    private IJokenpoServer jogador;
    private String name;
    
    public void setJogador(IJokenpoServer jogador)
    {
        this.jogador = jogador;
    }
    
    public IJokenpoServer getJogador()
    {
        return this.jogador;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return this.name;
    }
}
