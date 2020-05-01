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
public class Conexao {
    
    public int partida;
    public int jogador;
    
    public Conexao(int partida, int jogador)
    {
        this.partida = partida;
        this.jogador = jogador;
    }
}
