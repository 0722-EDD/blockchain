/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphviz;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import miblockchain.Block;

/**
 *
 * @author tosh
 */
public class Graficas {
    
    private String codigo;
    private int cont = 0;
    private Block ultimo;
    
    String archivoDot   =   "C:\\Users\\tosh\\Desktop\\img.txt";
    String comandoDot   =   "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot -Tpng C:\\Users\\tosh\\Desktop\\img.txt -o C:\\Users\\tosh\\Desktop\\img.png";

    
    public Graficas(Block ultimo) {
        this.ultimo = ultimo;
        
        codigo = "digraph G{\n"
                +"rankdir=\"LR\";\n"
                +"edge[style=invis, fontsize=12];\n";
    
        String relaciones = "";
        String previo = "";

        Block pivote = ultimo;
        
        while(pivote != null){
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
            Date timestamp = new Date(pivote.getTimestamp());
            System.out.println("Id: " + pivote.getId() + "   Hash: " + pivote.getHash()
                                + "  Hash Previo: " + pivote.getHashPrevio()
                                + "   TimeStamp: " + sdf.format(timestamp));  
            
            codigo  +=  "subgraph cluster_"+pivote.getId()+"{\n";                    
            
            if(cont == 0){
                
                codigo  +=   "node [style=filled,color=white];\n"
                        +   "style=filled;\n"
                        +   "color=lightgrey;\n";
                cont++;
            }else{
                codigo  +=   "node [style=filled];\n";
                cont--;
            }
            codigo  +=  "label = \"Bloque "+pivote.getId()+"\";\n"
                    +   "hashprevio_"   +   pivote.getId()  +   "[shape=\"rectangle\", label=\"Hash Previo: " +   pivote.getHashPrevio()    +   "\"]\n"
                    +   "hash_"         +   pivote.getId()  +   "[shape=\"rectangle\", label=\"Hash: " +   pivote.getHash() +   "\"]\n"
                    +   "merkleroot_"   +   pivote.getId()  +   "[shape=\"rectangle\", label=\"Merkle Tree Root: " +   pivote.getMerkleTreeRoot()   +   "\"]\n"
                    +   "timestamp_"    +   pivote.getId()  +   "[shape=\"rectangle\", label=\"Timestamp: " +   sdf.format(timestamp)   +   "\"]\n"
                    +   "}\n"
                    ;
         
            if("".equals(previo)){
                previo = "hashprevio_" + pivote.getId();
            }else{
                relaciones += previo + "->" + "hashprevio_" + pivote.getId() + ";\n";
                relaciones += previo + "->" + "hash_" + pivote.getId() + "[style=solid];\n";
                previo = "hashprevio_" + pivote.getId();
            }
            
            pivote = pivote.getPrevio();
        }               
        codigo += relaciones;
        codigo += "\n}";
        
        System.out.println(codigo);
        try {
            crearArchivoDot(codigo);
            generarImagen(comandoDot);
        } catch (IOException ex) {
            Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    public Graficas(Block ultimo, int id) {
        
        codigo = "digraph G{\n"
                +   "rankdir=\"TB\";\n"
                +   "subgraph cluster_0 {\n"
                +   "node [style=filled,color=white];\n"
                +   "style=filled;\n"
                +   "color=lightgrey;\n";
        
        Block pivote = ultimo;
        while(pivote != null){
            
            if( pivote.getId()  ==  id ){
                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
                Date timestamp = new Date(pivote.getTimestamp());                                               

                String  hash_tx1    =   pivote.generarHash(pivote.getTransacciones()[0].getDestino() + pivote.getTransacciones()[0].getOrigen() + pivote.getTransacciones()[0].getValor() + pivote.getTransacciones()[0].getTimestamp());
                String  hash_tx2    =   pivote.generarHash(pivote.getTransacciones()[1].getDestino() + pivote.getTransacciones()[1].getOrigen() + pivote.getTransacciones()[1].getValor() + pivote.getTransacciones()[1].getTimestamp());
                String  hash_tx3    =   pivote.generarHash(pivote.getTransacciones()[2].getDestino() + pivote.getTransacciones()[2].getOrigen() + pivote.getTransacciones()[2].getValor() + pivote.getTransacciones()[2].getTimestamp());
                String  hash_tx4    =   pivote.generarHash(pivote.getTransacciones()[3].getDestino() + pivote.getTransacciones()[3].getOrigen() + pivote.getTransacciones()[3].getValor() + pivote.getTransacciones()[3].getTimestamp());

                String  hash_tx1_tx2    =   pivote.generarHash( hash_tx1 + hash_tx2 );
                String  hash_tx3_tx4    =   pivote.generarHash( hash_tx3 + hash_tx4 );               
                
                codigo  +=  "label = \"Bloque "+pivote.getId()+"\";\n"
                    +   "hashprevio[shape=\"rectangle\", label=\"Hash Previo: " +   pivote.getHashPrevio()    +   "\"]\n"
                    +   "hash[shape=\"rectangle\", label=\"Hash: "              +   pivote.getHash()          +   "\"]\n"
                    +   "merkle[shape=\"rectangle\", label=\"Merkle Tree Root: "+   pivote.getMerkleTreeRoot()+   "\"]\n"
                    +   "timestamp[shape=\"rectangle\", label=\"Timestamp: "    +   sdf.format(timestamp)     +   "\"]\n"
                    +   "}\n\n"
                    +   "subgraph cluster_1 {\n"
                    +   "t0_[shape=\"rectangle\", label=\"Transaccion 1\\n"
                                                                                    +   "Origen   : "   +   pivote.getTransacciones()[0].getDestino()   +   "\\n"
                                                                                    +   "Destino  : "   +   pivote.getTransacciones()[0].getDestino()   +   "\\n"
                                                                                    +   "Valor    : "   +   pivote.getTransacciones()[0].getValor()     +   "\\n"
                                                                                    +   "Timestamp: "   +   pivote.getTransacciones()[0].getTimestamp() +   "\"]\n"
                    +   "t1_[shape=\"rectangle\", label=\"Transaccion 2\\n"
                                                                                    +   "Origen: "      +   pivote.getTransacciones()[1].getDestino()   +   "\\n"
                                                                                    +   "Destino: "     +   pivote.getTransacciones()[1].getDestino()   +   "\\n"
                                                                                    +   "Valor: "       +   pivote.getTransacciones()[1].getValor()     +   "\\n"
                                                                                    +   "Timestamp: "   +   pivote.getTransacciones()[1].getTimestamp() +   "\"]\n"
                    +   "t2_[shape=\"rectangle\", label=\"Transaccion 3\\n"
                                                                                    +   "Origen: "      +   pivote.getTransacciones()[2].getDestino()   +   "\\n"
                                                                                    +   "Destino: "     +   pivote.getTransacciones()[2].getDestino()   +   "\\n"
                                                                                    +   "Valor: "       +   pivote.getTransacciones()[2].getValor()     +   "\\n"
                                                                                    +   "Timestamp: "   +   pivote.getTransacciones()[2].getTimestamp() +   "\"]\n"
                    +   "t3_[shape=\"rectangle\", label=\"Transaccion 4\\n"
                                                                                    +   "Origen: "      +   pivote.getTransacciones()[3].getDestino()   +   "\\n"
                                                                                    +   "Destino: "     +   pivote.getTransacciones()[3].getDestino()   +   "\\n"
                                                                                    +   "Valor: "       +   pivote.getTransacciones()[3].getValor()     +   "\\n "
                                                                                    +   "Timestamp: "   +   pivote.getTransacciones()[3].getTimestamp() +   "\"]\n"
                    + "t0[label=\"tx_1 \\n" +hash_tx1+"\"]\n "
                    + "t1[label=\"tx_2 \\n" +hash_tx2+"\"]\n "
                    + "t2[label=\"tx_3 \\n" +hash_tx3+"\"]\n "
                    + "t3[label=\"tx_4 \\n" +hash_tx4+"\"]\n "
                    + "t0_t1[label=\"tx_1_2 \\n" +hash_tx1_tx2+"\"]\n "
                    + "t3_t4[label=\"tx_3_4 \\n" +hash_tx3_tx4+"\"]\n "
                    + "t0_t4[label=\"tx_1_2_3_4 \\n" +pivote.getMerkleTreeRoot()+"\"]\n "
                    + "t0->t0_\n "
                    + "t1->t1_\n "
                    + "t2->t2_\n "
                    + "t3->t3_\n "
                    + "t0_t1->t0\n "
                    + "t0_t1->t1\n "
                    + "t3_t4->t2\n "
                    + "t3_t4->t3\n "
                    + "t0_t4->t0_t1\n "
                    + "t0_t4->t3_t4\n "
                    +   "}\n\n"
                    +   "merkle->t0_t4 "
                    +   "}\n"
                    ;
            }
            
            pivote = pivote.getPrevio();
        }

        codigo  +=  "}";
        System.out.println(codigo);
        
        try {
            crearArchivoDot(codigo);
            generarImagen(comandoDot);
        } catch (IOException ex) {
            Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }           
    
    public void crearArchivoDot(String codigo) throws IOException {        
        FileWriter fw = new FileWriter(archivoDot);
        PrintWriter pw = new PrintWriter(fw);
        pw.print(codigo);
        pw.close();
    }
    
    public void generarImagen(String cmd) throws IOException{        
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
    }
    
}
