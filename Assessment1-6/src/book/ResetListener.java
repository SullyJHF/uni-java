package book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetListener implements ActionListener {
  private OrderPanel orderPanel;

  public ResetListener(OrderPanel orderPanel) {
    this.orderPanel = orderPanel;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    orderPanel.resetInputs();
  }

}
