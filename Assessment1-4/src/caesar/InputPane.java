package caesar;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
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
  private final int OFFSET_MAX = 25;
  private final int OFFSET_INIT = 0;

  private final Font MONO_FONT = new Font("monospaced", Font.PLAIN, 12);

  private CaesarCipher cc;

  // === Components === //
  private JLabel inputLabel;
  private JLabel outputLabel;
  private JTextArea inputTextArea;
  private JTextArea outputTextArea;
  private JScrollPane inputTextScroll;
  private JScrollPane outputTextScroll;

  private JButton decryptButton;

  private JSlider offsetSlider;
  private JLabel offsetLabel;
  private JLabel offsetNumLabel;

  public InputPane() {
    super(new GridBagLayout());

    initialiseComponents();
    setPreferredSize();

    this.gbc = new GridBagConstraints();
    this.gbc.fill = GridBagConstraints.BOTH;
    this.gbc.anchor = GridBagConstraints.FIRST_LINE_START;
    this.gbc.weightx = 0.5;

    // === LEFT COLUMN === //
    this.gbc.gridx = 0;
    this.gbc.gridy = 0;
    this.gbc.weighty = 0.0;
    this.gbc.insets = new Insets(5, 5, 10, GAP_BETWEEN);
    addComponent(inputLabel);

    this.gbc.gridx = 0;
    this.gbc.gridy = 1;
    this.gbc.weighty = 0.1;
    this.gbc.insets = new Insets(5, 5, 5, GAP_BETWEEN);
    addComponent(inputTextScroll);
    this.gbc.weighty = 0.0;

    this.gbc.gridx = 0;
    this.gbc.gridy = 2;
    this.gbc.insets = new Insets(5, 5, 5, GAP_BETWEEN);
    addComponent(decryptButton);
    this.gbc.insets = DEFAULT_INSETS;

    // === RIGHT COLUMN === //
    this.gbc.gridwidth = 3;
    this.gbc.gridx = 1;
    this.gbc.gridy = 0;
    addComponent(outputLabel);

    this.gbc.gridx = 1;
    this.gbc.gridy = 1;
    this.gbc.weighty = 0.1;
    addComponent(outputTextScroll);
    this.gbc.weighty = 0.0;

    this.gbc.gridwidth = 1;
    this.gbc.weightx = 0.0;
    this.gbc.gridx = 1;
    this.gbc.gridy = 2;
    addComponent(offsetLabel);

    this.gbc.gridx = 2;
    this.gbc.gridy = 2;
    addComponent(offsetNumLabel);

    this.gbc.weightx = 0.45;
    this.gbc.gridx = 3;
    this.gbc.gridy = 2;
    addComponent(offsetSlider);

  }

  private void setPreferredSize() {
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
  }

  private void initialiseComponents() {
    cc = new CaesarCipher();

    inputLabel = new JLabel("Input");
    inputLabel.setFont(MONO_FONT);

    inputTextArea = new JTextArea();
    inputTextArea.setLineWrap(true);
    inputTextArea.setWrapStyleWord(true);

    inputTextScroll = new JScrollPane(inputTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    outputLabel = new JLabel("Output");
    outputLabel.setFont(MONO_FONT);

    outputTextArea = new JTextArea();
    outputTextArea.setLineWrap(true);
    outputTextArea.setWrapStyleWord(true);
    outputTextArea.setEditable(false);

    outputTextScroll = new JScrollPane(outputTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    decryptButton = new JButton("Decrypt");
    decryptButton.setFont(MONO_FONT);
    decryptButton.addActionListener(e -> decryptInput());

    offsetSlider = new JSlider(JSlider.HORIZONTAL, OFFSET_MIN, OFFSET_MAX, OFFSET_INIT);
    offsetSlider.setMinorTickSpacing(1);
    offsetSlider.setPaintTicks(true);
    offsetSlider.setPaintLabels(true);
    offsetSlider.addChangeListener(e -> {
      updateOffsetLabel(offsetSlider.getValue());
      decryptInput();
    });

    offsetLabel = new JLabel("Offset:");
    offsetLabel.setFont(MONO_FONT);

    offsetNumLabel = new JLabel();
    offsetNumLabel.setFont(MONO_FONT);
    updateOffsetLabel(offsetSlider.getValue());
  }

  private void updateOffsetLabel(int value) {
    String labelStr = "";
    if (value < 10) labelStr += value + " ";
    else labelStr += value;
    offsetNumLabel.setText(labelStr);
  }

  private void decryptInput() {
    int offset = offsetSlider.getValue();
    String str = inputTextArea.getText();
    cc.setOffset(offset);
    String decryptedStr = cc.decryptString(str);
    outputTextArea.setText(decryptedStr);
  }

  private void addComponent(Component c) {
    this.add(c, this.gbc);
  }
}
