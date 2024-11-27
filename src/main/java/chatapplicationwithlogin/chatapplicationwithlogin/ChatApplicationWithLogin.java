/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package chatapplicationwithlogin.chatapplicationwithlogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatApplicationWithLogin {
    // Main method to start the application
    public static void main(String[] args) {
        // Show the login screen
        new LoginScreen();
    }
}

// Login screen class
class LoginScreen {
    JFrame loginFrame;

    public LoginScreen() {
        // Create login frame
        loginFrame = new JFrame("Login");
        loginFrame.setSize(300, 200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(new GridLayout(3, 2, 10, 10));

        // Add username and password labels and fields
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        // Add components to the frame
        loginFrame.add(userLabel);
        loginFrame.add(userField);
        loginFrame.add(passLabel);
        loginFrame.add(passField);
        loginFrame.add(new JLabel()); // Empty cell for alignment
        loginFrame.add(loginButton);

        // Action listener for login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                // Validate credentials (simple hardcoded example)
                if (username.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(loginFrame, "Login successful!");
                    loginFrame.dispose(); // Close login window
                    new ChatUI(username); // Open the chat UI
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Invalid credentials. Try again.");
                }
            }
        });

        // Show the login frame
        loginFrame.setVisible(true);
    }
}

// Chat UI class
class ChatUI {
    public ChatUI(String username) {
        // Create the main frame
        JFrame chatFrame = new JFrame("Chat Application - User: " + username);
        chatFrame.setSize(400, 600);
        chatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chatFrame.setLayout(new BorderLayout());

        // Create a text area for displaying chat messages
        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        chatFrame.add(chatScrollPane, BorderLayout.CENTER);

        // Create a panel for input and send button
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        // Input text field
        JTextField inputField = new JTextField();
        inputPanel.add(inputField, BorderLayout.CENTER);

        // Send button
        JButton sendButton = new JButton("Send");
        inputPanel.add(sendButton, BorderLayout.EAST);

        // Add the input panel to the bottom of the frame
        chatFrame.add(inputPanel, BorderLayout.SOUTH);

        // Action listener for the send button
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = inputField.getText().trim();
                if (!message.isEmpty()) {
                    chatArea.append(username + ": " + message + "\n");
                    inputField.setText(""); // Clear input field
                }
            }
        });

        // Allow pressing Enter to send messages
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendButton.doClick(); // Simulate button click
            }
        });

        // Show the frame
        chatFrame.setVisible(true);
    }
}
