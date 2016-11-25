package caesar;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;

public class InputPane extends JPanel {
  private final int WIDTH = 800;
  private final int HEIGHT = 400;
  private GridBagConstraints gbc;
  private final Insets DEFAULT_INSETS = new Insets(5, 5, 5, 5);
  // pixels between major components
  private final int GAP_BETWEEN = 20;

  private final int OFFSET_MIN = 0;
  private final int OFFSET_MAX = 26;
  private final int OFFSET_INIT = 0;

  // === Components === //
  private JLabel inputLabel;
  private JLabel outputLabel;
  private JTextArea inputTextArea;
  private JTextArea outputTextArea;
  private JScrollPane inputTextScroll;
  private JScrollPane outputTextScroll;

  private JButton decryptButton;

  private JSlider offsetSlider;

  public InputPane() {
    super(new GridBagLayout());

    initialiseComponents();
    setPreferredSize();

    this.gbc = new GridBagConstraints();
    this.gbc.fill = GridBagConstraints.BOTH;
//    this.gbc.anchor = GridBagConstraints.FIRST_LINE_START;
    this.gbc.weightx = 1.0;
    //    this.gbc.weighty = 1.0;

    // === LEFT COLUMN === //
    //    setGridBagContstraints(0, 0, 0, 0, 1, 1, 0, 0);
    this.gbc.gridx = 0;
    this.gbc.gridy = 0;
    this.gbc.weighty = 0.0;
    this.gbc.insets = new Insets(5, 5, 10, GAP_BETWEEN);
    addComponent(inputLabel);
    //    setGridBagContstraints(0, 0, 0, 1, 1, 1, 0, 100);
    this.gbc.gridx = 0;
    this.gbc.gridy = 1;
    this.gbc.weighty = 0.1;
    //    this.gbc.ipady = TEXT_AREA_HEIGHT;
    this.gbc.insets = new Insets(5, 5, 5, GAP_BETWEEN);
    addComponent(inputTextScroll);
    this.gbc.weighty = 0.0;

    this.gbc.gridx = 0;
    this.gbc.gridy = 2;
    this.gbc.insets = new Insets(5, 5, 5, GAP_BETWEEN);
    addComponent(decryptButton);
    this.gbc.insets = DEFAULT_INSETS;
    //    setGridBagContstraints(0, 0, 2, 0, 1, 1, 0, 0);

    // === RIGHT COLUMN === //
//    this.gbc.weightx = 0.5;
    this.gbc.gridx = 1;
    this.gbc.gridy = 0;
    addComponent(outputLabel);

    this.gbc.gridx = 1;
    this.gbc.gridy = 1;
    this.gbc.weighty = 0.1;
    //    this.gbc.ipady = TEXT_AREA_HEIGHT;
    addComponent(outputTextScroll);
    this.gbc.weighty = 0.0;

    this.gbc.gridx = 1;
    this.gbc.gridy = 2;
    addComponent(offsetSlider);

  }

  private void setPreferredSize() {
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
  }

  private void initialiseComponents() {
    inputLabel = new JLabel("Input");

    inputTextArea = new JTextArea();
    inputTextArea.setLineWrap(true);
    inputTextArea.setWrapStyleWord(true);

    inputTextScroll = new JScrollPane(inputTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    outputLabel = new JLabel("Output");

    outputTextArea = new JTextArea();
    outputTextArea.setLineWrap(true);
    outputTextArea.setWrapStyleWord(true);
    outputTextArea.setEditable(false);

    outputTextScroll = new JScrollPane(outputTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    decryptButton = new JButton("Decrypt");

    offsetSlider = new JSlider(JSlider.HORIZONTAL, OFFSET_MIN, OFFSET_MAX, OFFSET_INIT);
    offsetSlider.setMinorTickSpacing(1);
    offsetSlider.setPaintTicks(true);
    offsetSlider.setPaintLabels(true);
  }

  private void addComponent(Component c) {
    this.add(c, this.gbc);
  }

  private void setGridBagContstraints(double weightx, double weighty, int gridx, int gridy, int gridwidth, int gridheight, int ipadx, int ipady) {
    this.gbc.weightx = weightx;
    this.gbc.weighty = weighty;
    this.gbc.gridx = gridx;
    this.gbc.gridy = gridy;
    this.gbc.gridwidth = gridwidth;
    this.gbc.gridheight = gridheight;
    this.gbc.ipadx = ipadx;
    this.gbc.ipady = ipady;
  }
}
