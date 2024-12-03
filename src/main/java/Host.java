/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author User
 */
package host;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class Host extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static BufferedReader in;
    private static PrintWriter out;
    
    
    public Host() {
        initComponents();
    }
    
        private static void startServer() {
        try {
            // create socket
            serverSocket = new ServerSocket(12345); // Server listens on port 12345
            System.out.println("Server started. Waiting for clients...");
           

            // accept client
            clientSocket = serverSocket.accept();
            System.out.println("Client connected.");
           

            // input output stream
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            // thread listen client message
            new Thread(() -> listenForClientMessages()).start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
        
        private static void listenForClientMessages() {
        
        String in1;
        StyledDocument doc = jTextPane2.getStyledDocument();
        
        try {
            while ((in1 = in.readLine()) != null) {
                
                in1+="\n";
                
        SimpleAttributeSet keyWord = new SimpleAttributeSet();// styling object
         //style
        StyleConstants.setForeground(keyWord, Color.WHITE);
        StyleConstants.setBackground(keyWord, Color.BLUE);
        StyleConstants.setFontSize(keyWord ,16);
        StyleConstants.setBold(keyWord, true);

        //  alignment
        SimpleAttributeSet alignment = new SimpleAttributeSet();
        StyleConstants.setAlignment(alignment, StyleConstants.ALIGN_LEFT);

        try {
            // insert the text into jtextpane
            doc.insertString(doc.getLength(), in1, keyWord);

            // set alighnment left side for recieved message
            doc.setParagraphAttributes(doc.getLength()- in1.length(), in1.length(), alignment, false);
            
        } catch (Exception e) {
            System.out.println(e);
        }
                
            }
            
        } catch (IOException e) {
            System.out.println(e);
            
        }  finally {
        try {
            clientSocket.close();
            out.close();
            in.close();
            System.out.println("Socket closed");
        } catch (IOException e) {
            System.err.println("Error closing socket: " + e.getMessage());
        }
    }
            
    }