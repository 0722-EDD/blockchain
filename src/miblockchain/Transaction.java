/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miblockchain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author tosh
 */
public class Transaction {

    private final String    origen;
    private final String    destino;    
    private final String    valor;
    private final long      timestamp;
    
    public Transaction(String origen, String destino, String valor){
        this.origen     =   origen;
        this.destino    =   destino;
        this.valor      =   valor;
        this.timestamp  =   System.currentTimeMillis();
    }

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }
    
    /**
     * @return the timestamp
     */
    public String getTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
        Date date = new Date(this.timestamp);
        return sdf.format(date);
    }
    
}