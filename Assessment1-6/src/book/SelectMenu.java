package book;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SelectMenu extends JPanel {
  private String[] items;

  private JRadioButton[] listItems;
  private ButtonGroup list;

  protected SelectMenu menuAffects;

  public SelectMenu(String[] items) {
    super(new GridLayout(items.length, 1));
    if (items.length == 0) return;
    this.items = items;
    initialiseComponents();
    initialiseListItems();
    addListItems();
  }

  private void initialiseComponents() {
    list = new ButtonGroup();
    listItems = new JRadioButton[items.length];
  }

  private void initialiseListItems() {
    for (int i = 0; i < items.length; i++) {
      String item = items[i];
      listItems[i] = new JRadioButton(item);
      list.add(listItems[i]);
    }
  }

  private void addListItems() {
    for(JRadioButton button : listItems) {
      add(button);
    }
  }

  public void setMenuAffects(SelectMenu menuAffects) {
    this.menuAffects = menuAffects;
  }

  public void setAffectsDisable(int[][] indexesToDisable) {
    for(int i = 0; i < indexesToDisable.length; i++) {
      int[] disable = indexesToDisable[i];
      listItems[i].addItemListener(e -> {
        JRadioButton[] affectsButtons = menuAffects.getButtons();
        for(JRadioButton button : affectsButtons) {
          button.setEnabled(true);
        }
        for(int index : disable) {
          for(int j = 0; j < affectsButtons.length; j++) {
            if(index == j) affectsButtons[j].setEnabled(false);
          }
        }
      });
    }
  }

  public void setAffectsDefault(int[] indexToSelect) {
    for(int i = 0; i < indexToSelect.length; i++) {
      int select = indexToSelect[i];
      listItems[i].addItemListener(e -> {
        JRadioButton[] affectsButtons = menuAffects.getButtons();
        for(JRadioButton button : affectsButtons) {
          button.setSelected(false);
        }
        affectsButtons[select].setSelected(true);
      });
    }
  }

  public JRadioButton[] getButtons() {
    return listItems;
  }
}
