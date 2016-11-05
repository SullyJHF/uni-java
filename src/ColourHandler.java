import java.awt.Color;

class ColourHandler {
  private int[] cInts = { -16777216, -14865581, -8510125, -16742575, -5549514, -10528945, -4013113, -3608, -65459,
      -23808, -5081, -16718794, -14045697, -8161636, -34904, -13142 };
  private String[] cStrings = { "BLACK", "DARK_BLUE", "DARK_PURPLE", "DARK_GREEN", "BROWN", "DARK_GRAY", "LIGHT_GRAY",
      "WHITE", "RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "INDIGO", "PINK", "PEACH" };

  public ColourHandler() {
  }

  public int getColourByName(String name) {
    name = name.toUpperCase();
    for (int i = 0; i < cStrings.length; i++) {
      if (cStrings[i].equals(name)) return cInts[i];
    }
    return -1;
  }

  public String getColourByInt(int colour) {
    for (int i = 0; i < cInts.length; i++) {
      if (cInts[i] == colour) return cStrings[i];
    }
    return null;
  }

  public Color getColourFromMap(int mapTile) {
    if (mapTile == 0) return null;
    mapTile--;
    return new Color(cInts[mapTile]);
  }

  final Color BLACK = new Color(cInts[0]);
  final Color DARK_BLUE = new Color(cInts[0]);
  final Color DARK_PURPLE = new Color(cInts[0]);
  final Color DARK_GREEN = new Color(cInts[0]);
  final Color BROWN = new Color(cInts[0]);
  final Color DARK_GRAY = new Color(cInts[0]);
  final Color LIGHT_GRAY = new Color(cInts[0]);
  final Color WHITE = new Color(cInts[0]);
  final Color RED = new Color(cInts[0]);
  final Color ORANGE = new Color(cInts[0]);
  final Color YELLOW = new Color(cInts[0]);
  final Color GREEN = new Color(cInts[0]);
  final Color BLUE = new Color(cInts[0]);
  final Color INDIGO = new Color(cInts[0]);
  final Color PINK = new Color(cInts[0]);
  final Color PEACH = new Color(cInts[0]);
}
