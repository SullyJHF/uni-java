package floatApplet;

import java.applet.Applet;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class FloatingPointApplet extends Applet {
  private float num1, num2, sum, product, difference, division;

  @Override
  public void init() {
    super.init();
    String[] reply = JOptionPane.showInputDialog("Enter two numbers separated with a space").split("\\s+");
    num1 = Float.valueOf(reply[0]);
    num2 = Float.valueOf(reply[1]);
    sum = num1 + num2;
    product = num1 * num2;
    difference = num1 - num2;
    division = num1 / num2;
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    String output = String.valueOf(num1) + " + " + String.valueOf(num2) + " = " + String.valueOf(sum);
    g.drawString(output, 0, 15);
    output = String.valueOf(num1) + " - " + String.valueOf(num2) + " = " + String.valueOf(difference);
    g.drawString(output, 0, 30);
    output = String.valueOf(num1) + " * " + String.valueOf(num2) + " = " + String.valueOf(product);
    g.drawString(output, 0, 45);
    output = String.valueOf(num1) + " / " + String.valueOf(num2) + " = " + String.valueOf(division);
    g.drawString(output, 0, 60);
  }

}
