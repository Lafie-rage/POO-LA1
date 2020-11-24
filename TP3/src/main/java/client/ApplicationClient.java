package client;

import model.Message;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.security.MessageDigest;

public class ApplicationClient extends JDialog {
    private JPanel contentPane;
    private JButton buttonSend;
    private JButton buttonExit;
    private JTextArea textArea;
    private JTextField messageField;
    private JTextField nameField;
    private ObjectInputStream reader;
    private ObjectOutputStream writer;
    private final Ecouteur listener;

    private Socket client;

    public ApplicationClient() {
        try {
            setUpConnexion();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonSend);

        buttonSend.addActionListener(e -> onSend());

        buttonExit.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        listener = new Ecouteur(reader, textArea);
        listener.start();
    }

    public static void main(String[] args) {
        ApplicationClient dialog = new ApplicationClient();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void onSend() {
        String name = nameField.getText();
        String textMessage = messageField.getText();
        Message message = new Message(name, textMessage);
        try {
            writer.writeObject(message);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        messageField.setText("");
        nameField.setEditable(false);
    }

    private void onCancel() {
        dispose();
    }

    private void setUpConnexion() throws IOException {
        client = new Socket("127.0.0.1", 60000);
        // write
        writer = new ObjectOutputStream(this.client.getOutputStream());
        // read
        reader = new ObjectInputStream(this.client.getInputStream());
    }



    @Override
    public void dispose() {
        try {
            writer.writeObject(null);
            writer.flush();
            client.close();
            listener.interrupt();
        } catch (IOException e) {
            System.out.println("Client already closed");
        }
        super.dispose();
    }
}
