/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokenpo.model;

import jokenpo.server.IJokenpoServer;

/**
 *
 * @author nathy
 */
public class Jogador {
    
    private int id;
    private IJokenpoServer jogador;
    private String name;
    private String jogada;
    
    public Jogador(int id, IJokenpoServer jogador, String name)
    {
        this.id = id;
        this.jogador = jogador;
        this.name = name;
        this.jogada = null;
    }
    
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
    
    public void setJogada(String jogada)
    {
        this.jogada = jogada;
    }
    
    public String getJogada()
    {
        return this.jogada;
    }
}
