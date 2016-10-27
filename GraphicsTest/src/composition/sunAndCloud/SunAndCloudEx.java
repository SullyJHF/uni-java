package composition.sunAndCloud;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SunAndCloudEx extends JFrame {
  public SunAndCloudEx() {
    initUI();
  }

  private void initUI() {
    add(new Surface());

    setTitle("Sun and Cloud");
    setSize(300, 210);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        SunAndCloudEx ex = new SunAndCloudEx();
        ex.setVisible(true);
      }
    });
  }
}
