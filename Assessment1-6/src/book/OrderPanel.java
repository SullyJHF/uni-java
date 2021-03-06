package book;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class OrderPanel extends JPanel {
  private final int WIDTH = 400;
  private final int HEIGHT = 250;
  private final Insets DEFAULT_INSETS = new Insets(5, 5, 5, 5);

  private JLabel copiesLabel;

  private SpinnerModel copiesModel;
  private JSpinner copiesSpinner;

  private String[] formats = {"Ebook", "Softcover", "Hardcover"};
  // this menu disables option 1 and 2 of
  private int[][] formatDisables = {{1, 2}, {0}, {0}};
  private int[] formatDefaults = {0, 1, 1};
  private SelectMenu formatMenu;

  private String[] deliveryMethods = {"Download", "Royal Mail", "Courier"};
  private SelectMenu deliveryMenu;

  private JTextArea outputArea;

  private JButton submitButton;
  private JButton resetButton;

  private GridBagConstraints gbc;

  public OrderPanel() {
    super(new GridBagLayout());
    setPreferredSize();
    initComponents();

    gbc.insets = DEFAULT_INSETS;
    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.EAST;
    gbc.weightx = 0.25;
    gbc.weighty = 0.0;

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.EAST;
    add(copiesLabel, gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.gridx = 1;
    add(copiesSpinner, gbc);
    gbc.gridx = 2;
    add(formatMenu, gbc);
    gbc.gridx = 3;
    add(deliveryMenu, gbc);


    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.FIRST_LINE_START;
    gbc.gridwidth = 2;
    gbc.gridx = 0;
    gbc.gridy = 1;
    add(submitButton, gbc);
    gbc.anchor = GridBagConstraints.FIRST_LINE_END;
    gbc.gridx = 2;
    add(resetButton, gbc);


    gbc.anchor = GridBagConstraints.FIRST_LINE_START;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.weighty = 1.0;
    gbc.gridwidth = 4;
    gbc.gridx = 0;
    gbc.gridy = 2;
    add(outputArea, gbc);
  }

  private void initComponents() {
    gbc = new GridBagConstraints();
    copiesModel = new SpinnerNumberModel(1, 1, 100, 1);

    copiesLabel = new JLabel("Copies:");

    copiesSpinner = new JSpinner(copiesModel);

    copiesLabel.setLabelFor(copiesSpinner);

    formatMenu = new SelectMenu(formats);

    deliveryMenu = new SelectMenu(deliveryMethods);
    deliveryMenu.disableAll();

    formatMenu.setMenuAffects(deliveryMenu);
    formatMenu.setAffectsDisable(formatDisables);
    formatMenu.setAffectsDefault(formatDefaults);

    submitButton = new JButton("Submit");
    submitButton.setPreferredSize(new Dimension(150, 22));
    submitButton.addActionListener(e -> submitOptions());

    resetButton = new JButton("Reset");
    resetButton.setPreferredSize(new Dimension(150, 22));
    resetButton.addActionListener(e -> resetInputs());

    outputArea = new JTextArea();
    outputArea.setEditable(false);
    outputArea.setLineWrap(true);
    outputArea.setWrapStyleWord(true);
    outputArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
  }

  private void setPreferredSize() {
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
  }

  public void resetInputs() {
    copiesSpinner.setValue(1);
    formatMenu.resetValues();
    deliveryMenu.disableAll();
    outputArea.setText("");
  }

  public void submitOptions() {
    String output = "";
    output += "Copies: " + copiesSpinner.getValue() + "\n";
    // the copies can never be < 1 so will never be invalid input

    JRadioButton formatSelected = formatMenu.getSelectedButton();
    JRadioButton deliverySelected = deliveryMenu.getSelectedButton();

    if(formatSelected == null) {
      JOptionPane.showMessageDialog(this, "Please select a format", "Warning", JOptionPane.WARNING_MESSAGE);
      return;
    }
    output += "Format: " + formatSelected.getText() + "\n";

    // this will never ever get run unless the user can find out a way to deselect a radio button
    if(deliverySelected == null) {
      JOptionPane.showMessageDialog(this, "Please select a delivery method", "Warning", JOptionPane.WARNING_MESSAGE);
      return;
    }
    output += "Delivery Method: " + deliverySelected.getText() + "\n";

    outputArea.setText(output);
  }
}
