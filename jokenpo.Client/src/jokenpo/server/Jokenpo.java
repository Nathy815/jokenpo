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
public class Jokenpo 
{
    private int rodada;
    private int vitorias;
    private int derrotas;
    private String oponente;
    
    public Jokenpo()
    {
        rodada = 0;
        vitorias = 0;
        derrotas = 0;
        oponente = "CPU";
    }
    
    public void setRodada()
    {
        rodada += 1;
    }
    
    public int getRodada()
    {
        return rodada;
    }
    
    public void setVitoria()
    {
        vitorias += 1;
    }
    
    public int getVitoria()
    {
        return vitorias;
    }
    
    public void setDerrota()
    {
        derrotas += 1;
    }
    
    public int getDerrota()
    {
        return derrotas;
    }
    
    public void setOponente(String nome)
    {
        oponente = nome;
    }
    
    public String getOponente()
    {
        return oponente;
    }
}
