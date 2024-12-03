import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Rifat
 */
public class HostClient extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    
    private static Socket socket;
    private static BufferedReader in;
    private static PrintWriter out;
   
    public HostClient() {
        initComponents();
        startCLient();
    }
    
    public static void startCLient(){
        
        try{
            
            //connect
            socket = new Socket("127.0.0.1", 12345);
            System.out.println("Connected to the server.");

            // Sset up input output
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // thread for recieving message
            new Thread(() -> listenForHostMessages()).start();
            
         
            
        }catch(Exception E){
            System.out.println(E);
            
        }
       

       
    }
        
    
    
      private static void listenForHostMessages() {
     
        String in1;  // input string variable
        StyledDocument doc = jTextPane2.getStyledDocument();
        try {
            while ((in1 = in.readLine()) != null) {
                
                in1+="\n";
                
        SimpleAttributeSet keyWord = new SimpleAttributeSet();

        StyleConstants.setForeground(keyWord, Color.WHITE);
        StyleConstants.setBackground(keyWord, Color.BLUE);
        StyleConstants.setFontSize(keyWord ,16);
        StyleConstants.setBold(keyWord, true);

        //alignment
        SimpleAttributeSet alignment = new SimpleAttributeSet();
        StyleConstants.setAlignment(alignment, StyleConstants.ALIGN_LEFT);
            

        try {
            // insert to jtextpane
            doc.insertString(doc.getLength(), in1, keyWord);

            // Apply the alignment to the paragraph containing th(), e new text
            doc.setParagraphAttributes(doc.getLength()- in1.length(), in1.length(), alignment, false);
        } catch (Exception e) {
            System.out.println(e);
        }
        
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally {
        try {
            
            //error handle if closed
            socket.close();
            out.close();
            in.close();
            System.out.println("Socket closed");
        } catch (IOException e) {
            System.err.println("Error closing socket: " + e.getMessage());
        }
    }
    }