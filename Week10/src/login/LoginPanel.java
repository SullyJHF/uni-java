package login;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
  private final int WIDTH = 300;
  private final int HEIGHT = 200;

  private GridBagConstraints gbc;

  private JLabel userLabel, passLabel;
  private JTextField userField;
  private JPasswordField passField;

  public LoginPanel() {
    super(new GridBagLayout());
    gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.BOTH;
    gbc.anchor = GridBagConstraints.FIRST_LINE_START;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;

    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    initialiseComponents();

    gbc.gridx = 0;
    gbc.gridy = 0;
    add(userLabel);
    gbc.gridx = 0;
    gbc.gridy = 1;
    add(userField);

    gbc.gridx = 1;
    gbc.gridy = 0;
    add(passLabel);
    gbc.gridx = 1;
    gbc.gridy = 1;
    add(passField);
  }

  private void initialiseComponents() {
    userLabel = new JLabel("Username: ");
    passLabel = new JLabel("Password: ");

    userField = new JTextField();
    passField = new JPasswordField();

    userLabel.setLabelFor(userField);
    passLabel.setLabelFor(passField);
  }
}
