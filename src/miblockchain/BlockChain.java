/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miblockchain;

import graphviz.Graficas;

/**
 *
 * @author tosh
 */
public class BlockChain {
    
    private Block   genesis;
    private Block   ultimo;
    private int     numeroDeBloques;
    
    public BlockChain() {
        this.genesis            =   null;
        this.numeroDeBloques    =   0;
    }
    
    public void agregarBloque(Transaction[] transacciones) { 
        if(genesis  !=  null){
            Block nuevoBloque = new Block(this.ultimo, this.ultimo.getHash(), numeroDeBloques++, transacciones);
            this.ultimo = nuevoBloque;
        }else{
            this.genesis = new Block(numeroDeBloques++, transacciones);
            this.ultimo =  this.genesis;
        }
    }

    /**
     * @return the numeroDeBloques
     */
    public int getNumeroDeBloques() {
        return numeroDeBloques;
    }
    
    public void obtenerBloque(int id){
        Graficas    graph   =   new Graficas(ultimo,id);
    }
    
    public void mostrar(){        
        Graficas    graph   =   new Graficas(ultimo);
    }

}