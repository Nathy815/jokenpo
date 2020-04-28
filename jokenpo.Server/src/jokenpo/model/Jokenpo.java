/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokenpo.model;

/**
 *
 * @author nathy
 */
public class Jokenpo {
    
    private Client client1;
    private Client client2;
    private int rodadas;
    
    public Jokenpo()
    {
        client1 = new Client();
        client2 = new Client();
        rodadas = 0;
    }
    
    public void setClient1(Client client1)
    {
        this.client1 = client1;
    }
    
    public Client getClient1()
    {
        return client1;
    }
    
    public void setClient2(Client client2)
    {
        this.client2 = client2;
    }
    
    public Client getClient2()
    {
        return client2;
    }
    
    public void setRodadas()
    {
        rodadas += 1;
    }
    
    public int getRodadas()
    {
        return rodadas;
    }
}
