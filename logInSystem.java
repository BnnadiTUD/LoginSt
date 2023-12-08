import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class logInSystem extends JFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        ArrayList<User> list = new ArrayList<>();
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(Color.cyan);
        frame.setTitle("Bryans Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        JTabbedPane tab = new JTabbedPane();

        JPanel Login = new JPanel(new BorderLayout());
        JLabel welcomeMessage = new JLabel("Welcome ");
        welcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeMessage.setFont(new Font("Arial", Font.BOLD, 24));

        JButton logIn = new JButton("Log In");
        logIn.setPreferredSize(new Dimension(100, 40));

        Login.add(logIn, BorderLayout.NORTH);
        Login.add(welcomeMessage, BorderLayout.CENTER);
        tab.addTab("Log In", Login);

        JPanel users = new JPanel(new BorderLayout()); // Using BorderLayout for better component layout
        JTextArea userTxtArea = new JTextArea();
        JLabel usersLabel = new JLabel("The following users have logged into our application");
        users.add(usersLabel, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(userTxtArea); // Adding the JTextArea to a scroll pane
        scrollPane.setPreferredSize(new Dimension(300, 300)); // Setting preferred size for the scroll pane
        users.add(scrollPane, BorderLayout.CENTER);
        tab.addTab("User List", users);

        frame.getContentPane().add(tab);

        logIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField usernameField = new JTextField();
                JPasswordField passwordField = new JPasswordField();
                Object[] message = { "Username:", usernameField, "Password:", passwordField };
                int option = JOptionPane.showConfirmDialog(null, message, "Log in", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String username = usernameField.getText();
                    welcomeMessage.setText("Welcome, " + username);
                }
                
                String userName = usernameField.getText();
		        String password = passwordField.getText();

		        // Create a new Student object
		        User u = new User(userName, password);

		        // Add the Student object to the list
		        list.add(u);

		        // Clear the student list text area
		        userTxtArea.setText("");

		        // Update the text area with the updated student list
		        for (User s : list) {
		            userTxtArea.append(s.toString());
		        }
		    }
        });
        frame.setVisible(true);
    }
}

