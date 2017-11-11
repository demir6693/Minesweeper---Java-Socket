/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper_server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author demir
 */
public class Minesweeper_server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        minesweeper_algoritam t = new minesweeper_algoritam();
        int[][] pom = new int[9][9];
        int[][] mnsw = new int[9][9];
        
        
        try {
            ServerSocket socket = new ServerSocket(8081);
            Socket s = socket.accept();
            System.out.println("Server is runing...");
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            mnsw = t.matrix(pom);
                for (int i = 0; i < mnsw.length; i++) 
                {
                    for (int j = 0; j < mnsw.length; j++) 
                    {
                    out.writeInt(mnsw[i][j]);
                    }
                }
                
            }
            catch(Exception e)
            {
            
            }
            
        
        
            
            
        
        
       
        
    }
    
}
