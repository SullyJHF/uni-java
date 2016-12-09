package login;

import javax.swing.JFrame;

public class LoginFrame extends JFrame {
  public LoginFrame() {
    super("Login Form");
    setResizable(false);
    LoginPanel loginPanel = new LoginPanel();
    add(loginPanel);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
  }
}
