/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miblockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tosh
 */
public class Block {
    
    private final int           id;
    private final Block         previo;
    
    private final Transaction   transacciones[];
    
    private String              merkleTreeRoot;
    private final long          timestamp;
    private final String        hashPrevio;
    private final String        hash;
    
    public Block(Block previo, String hashPrevio, int id, Transaction[] transacciones) {
        
        this.id             =   id;
        this.previo         =   previo;
        
        this.transacciones  =   transacciones;
        
        this.merkleTreeRoot =   crearMerkleRoot();
        this.timestamp      =   System.currentTimeMillis();
        this.hashPrevio     =   hashPrevio;        
        this.hash           =   obtenerHash();

    }
    
    public Block(int id, Transaction[] transacciones) {
        
        this.id             =   id;
        this.previo         =   null;
                
        this.transacciones  =   transacciones;
        
        this.merkleTreeRoot =   crearMerkleRoot();
        this.timestamp      =   System.currentTimeMillis();
        this.hashPrevio     =   "";
        this.hash           =   obtenerHash();
        
    }    
    
    private String obtenerHash(){        
        return generarHash(getTimestamp() + getHashPrevio() + this.getMerkleTreeRoot());        
    }
    
    private String crearMerkleRoot(){
        String transaccion1 =   transacciones[0].getDestino() + transacciones[0].getOrigen() + transacciones[0].getValor() + transacciones[0].getTimestamp();
        String transaccion2 =   transacciones[1].getDestino() + transacciones[1].getOrigen() + transacciones[1].getValor() + transacciones[1].getTimestamp();
        String transaccion3 =   transacciones[2].getDestino() + transacciones[2].getOrigen() + transacciones[2].getValor() + transacciones[2].getTimestamp();
        String transaccion4 =   transacciones[3].getDestino() + transacciones[3].getOrigen() + transacciones[3].getValor() + transacciones[3].getTimestamp();
        
        String  hash_tx1    =   generarHash(transaccion1);
        String  hash_tx2    =   generarHash(transaccion2);
        String  hash_tx3    =   generarHash(transaccion3);
        String  hash_tx4    =   generarHash(transaccion4);
        
        String  hash_tx1_tx2    =   generarHash( hash_tx1 + hash_tx2 );
        String  hash_tx3_tx4    =   generarHash( hash_tx3 + hash_tx4 );
        
        return generarHash( hash_tx1_tx2 + hash_tx3_tx4 );
    }
    
    public String generarHash(String str) {        
        
        try {
            
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            
            return hexString.toString();
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Block.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the previo
     */
    public Block getPrevio() {
        return previo;
    }

    /**
     * @return the transacciones
     */
    public Transaction[] getTransacciones() {
        return transacciones;
    }

    /**
     * @return the hashPrevio
     */
    public String getHashPrevio() {
        return hashPrevio;
    }

    /**
     * @return the hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * @return the timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * @return the merkleTreeRoot
     */
    public String getMerkleTreeRoot() {
        return merkleTreeRoot;
    }
    
}