package client;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class ApplicationClient extends JDialog {
    private JPanel contentPane;
    private JButton buttonSend;
    private JButton buttonExit;
    private JTextArea textArea;
    private JTextField messageField;
    private JTextField nameField;
    private BufferedReader reader;
    private PrintWriter writer;
    private Ecouteur listener;

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
        String message = messageField.getText();
        writer.println(name + " : " + message);
        writer.flush();
        messageField.setText("");
    }

    private void onCancel() {
        dispose();
    }

    private void setUpConnexion() throws IOException {
        client = new Socket("127.0.0.1", 60000);
        // read
        InputStreamReader input = new InputStreamReader(this.client.getInputStream());
        reader = new BufferedReader(input);
        // write
        OutputStreamWriter output = new OutputStreamWriter(this.client.getOutputStream());
        writer = new PrintWriter(output);
    }



    @Override
    public void dispose() {
        try {
            writer.println("CONNEXION_CLOSED");
            writer.flush();
            client.close();
            listener.interrupt();
        } catch (IOException e) {
            System.out.println("Client already closed");
        }
        super.dispose();
    }
}
