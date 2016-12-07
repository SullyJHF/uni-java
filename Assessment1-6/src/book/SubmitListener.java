package book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitListener implements ActionListener {
  private OrderPanel orderPanel;

  public SubmitListener(OrderPanel orderPanel) {
    this.orderPanel = orderPanel;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    orderPanel.submitOptions();
  }
}
