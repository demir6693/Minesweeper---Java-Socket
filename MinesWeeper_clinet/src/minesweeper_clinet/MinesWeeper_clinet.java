/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper_clinet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author demir
 */
public class MinesWeeper_clinet implements ActionListener {

        JFrame frame = new JFrame("Minesweeper");
        JButton reset = new JButton("Reset");
        JButton[][] buttons = new JButton[9][9];
        public static int[][] counts = new int[9][9];
        Container grid = new Container();
        public static int port = 0;
        
        public MinesWeeper_clinet() {
            
            frame.setSize(400, 400);
            frame.setLayout(new BorderLayout());
            frame.add(reset, BorderLayout.NORTH);
            reset.addActionListener(this);
            grid.setLayout(new GridLayout(10, 10));
            
     
            for (int i = 0; i < buttons.length; i++) 
            {
                for (int j = 0; j < buttons.length; j++) 
                {   
                   
                    buttons[i][j] = new JButton();
                    buttons[i][j].addActionListener(this);
                    grid.add(buttons[i][j]);
                }
                
            }
            frame.add(grid, BorderLayout.CENTER);
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
        
        public void actionPerformed(ActionEvent event) {
            
            if(event.getSource().equals(reset))
        {   
            mnsw_alg t = new mnsw_alg();
            int[][] pom = new int[9][9];
            counts = t.matrix(pom);
            for (int i = 0; i < buttons.length; i++) 
            {   
                for (int j = 0; j < buttons.length; j++) 
                {
                 buttons[i][j].setEnabled(true);
                 buttons[i][j].setText("");
                }
            }    
        }  
        else
        {
            for (int i = 0; i < buttons.length; i++) 
            {   
                for (int j = 0; j < buttons.length; j++) 
                {
                 if(event.getSource().equals(buttons[i][j]))
                 {   
                     if(counts[i][j] == 7)
                     {   
                         buttons[i][j].setForeground(Color.red);
                         buttons[i][j].setText("X");
                         lostgame();
                     }
                     else if(counts[i][j] == 0)
                     {   
                         pored_nule();
                         brisi_nule();
                     }
                     else
                     {
                         buttons[i][j].setText(counts[i][j] + ""); 
                         buttons[i][j].setEnabled(false); 
                     }
                     
                     
                 }
                    
                }
                
                
            }
        }
        
        }
        public void brisi_nule()
    {
        for (int i = 0; i < buttons.length; i++) 
            {   
                for (int j = 0; j < buttons.length; j++) 
                {
                    if(counts[i][j] == 0)
                    {   
                        buttons[i][j].setText("");
                        buttons[i][j].setEnabled(false);
                    }
                    
                }
            }    
    }
        
        public void pored_nule()
    {
        for (int i = 0; i < buttons.length; i++) 
            {   
                for (int j = 0; j < buttons.length; j++) 
                {   
                    
                    if(counts[i][j] == 0 && i > 0 && j > 0 && i < 8 && j < 8)
                    {   
                        
                        if(counts[i+1][j] == 0)
                        {
                            buttons[i+1][j].setEnabled(false);
                        }
                        else
                        {
                            buttons[i+1][j].setEnabled(false);
                            buttons[i+1][j].setText(counts[i+1][j] + "");
                        }
                        
                        
                        if(counts[i-1][j] == 0)
                        {
                            buttons[i-1][j].setEnabled(false);
                        }
                        else
                        {
                            buttons[i-1][j].setEnabled(false);
                            buttons[i-1][j].setText(counts[i-1][j] + "");
                        }
                        
                        if(counts[i][j+1] == 0)
                        {
                            buttons[i][j+1].setEnabled(false);
                        }
                        else
                        {
                            buttons[i][j+1].setEnabled(false);
                            buttons[i][j+1].setText(counts[i][j+1] + "");
                        }
                        
                        if(counts[i][j-1] == 0)
                        {
                            buttons[i][j-1].setEnabled(false);
                        }
                        else
                        {
                             buttons[i][j-1].setEnabled(false);
                             buttons[i][j-1].setText(counts[i][j-1] + "");
                        }
                       
                        if(counts[i+1][j+1] == 0)
                        {
                            buttons[i+1][j+1].setEnabled(false);
                        }
                        else
                        {
                            buttons[i+1][j+1].setEnabled(false);
                            buttons[i+1][j+1].setText(counts[i+1][j+1] + "");
                        }
                        
                        if(counts[i-1][+1] == 0)
                        {
                            buttons[i-1][j+1].setEnabled(false);
                        }
                        else
                        {
                            buttons[i-1][j+1].setEnabled(false);
                            buttons[i-1][j+1].setText(counts[i-1][j+1] + "");
                        }
                        
                        if(counts[i-1][j-1] == 0)
                        {
                           buttons[i-1][j-1].setEnabled(false);
                        }
                        else
                        {
                           buttons[i-1][j-1].setEnabled(false);
                           buttons[i-1][j-1].setText(counts[i-1][j-1] + ""); 
                        }
                        
                        if(counts[i+1][j-1] == 0)
                        {
                            buttons[i+1][j-1].setEnabled(false);
                        }
                        else
                        {
                            buttons[i+1][j-1].setEnabled(false);
                            buttons[i+1][j-1].setText(counts[i+1][j-1] + "");
                        }
                        
                    }
                    
                    
                }
            } 
    }
        
         public void lostgame() 
    {
        for (int i = 0; i < buttons.length; i++) 
        {
            for (int j = 0; j < buttons.length; j++) 
            {
                if(buttons[i][j].isEnabled())
                {
                    if(counts[i][j] != 7)
                    {
                        buttons[i][j].setText(counts[i][j] + "");
                        buttons[i][j].setEnabled(false);
                    }
                    else
                    {
                        
                        buttons[i][j].setText("X");
                        buttons[i][j].setEnabled(false);
                    }
                }
            }
            
        }
    }
    public static void main(String[] args) {
        
        
        try
        {
            Socket s = new Socket("localhost", 8081);
            DataInputStream in = new DataInputStream(s.getInputStream());
            for (int i = 0; i < counts.length; i++) 
                {
                    for (int j = 0; j < counts.length; j++) 
                    {
                    counts[i][j] = in.readInt();
                    }
                }
                new MinesWeeper_clinet();
                port++;
        }   
        catch (IOException  e)
        {
             JOptionPane.showMessageDialog(null, "Server is not running!!");
        }
        
        for (int i = 0; i < counts.length; i++) 
                {
                    for (int j = 0; j < counts.length; j++) 
                    {
                    System.out.print(counts[i][j]);
                    }
                    System.out.println();
                }
        
        
       
    }    
    }     
                    
                
            
            
    
    
    
    
   
        
        
        
        
        
                 
    
