import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class graded2 extends JFrame implements ActionListener {
    private JTextField usernameField, emailField;
    private JPasswordField passwordField;
    private JFormattedTextField dobField;
    private JButton submitButton;
    private JTextArea messageArea;
    private JComboBox<String> genderComboBox;

    public graded2() {
        setTitle("User Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(7, 2, 10, 10));

        mainPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        mainPanel.add(usernameField);

        mainPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        mainPanel.add(passwordField);

        mainPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        mainPanel.add(emailField);

        mainPanel.add(new JLabel("Date of Birth:"));
        dobField = new JFormattedTextField(java.util.Calendar.getInstance().getTime());
        mainPanel.add(dobField);

        mainPanel.add(new JLabel("Gender:"));
        String[] genders = { "Male", "Female", "Other" };
        genderComboBox = new JComboBox<>(genders);
        mainPanel.add(genderComboBox);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        mainPanel.add(submitButton);

        messageArea = new JTextArea();
        messageArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageArea);
        mainPanel.add(scrollPane);

        add(mainPanel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();
            String email = emailField.getText();
            String dob = dobField.getText();
            String gender = (String) genderComboBox.getSelectedItem();

            messageArea.setText("Successfully sent:\n" +
                    "Username: " + username + "\n" +
                    "Email: " + email + "\n" +
                    "Date of Birth: " + dob + "\n" +
                    "Gender: " + gender);
        }
    }

    public static void main(String[] args) {
        new graded2();
    }
}
