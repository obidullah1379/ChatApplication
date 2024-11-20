import javax.bluetooth.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.io.*;

public class BluetoothChatMidlet extends MIDlet implements CommandListener {
    private Display display;
    private Form form;
    private TextField messageField;
    private StringConnection connection;

    public void startApp() {
        display = Display.getDisplay(this);
        form = new Form("Bluetooth Chat");
        messageField = new TextField("Message:", "", 100, TextField.ANY);
        
        Command sendCommand = new Command("Send", Command.OK, 1);
        form.addCommand(sendCommand);
        form.setCommandListener(this);
        form.append(messageField);
        
        display.setCurrent(form);
        
        // Initialize Bluetooth connection
        initializeBluetoothConnection();
    }

    private void initializeBluetoothConnection() {
        // Implement device discovery and connection setup here
        // This is a placeholder for actual Bluetooth logic
    }

    public void commandAction(Command c, Displayable d) {
        if (c.getLabel().equals("Send")) {
            String message = messageField.getString();
            sendMessage(message);
            messageField.setString(""); // Clear the field after sending
        }
    }

    private void sendMessage(String message) {
        // Implement message sending logic over Bluetooth connection
        // This is a placeholder for actual message sending logic
    }

    public void pauseApp() {}

    public void destroyApp(boolean unconditional) {}
}
