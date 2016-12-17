package aoc_2016.aoc_04;

public class Main {
  public static void main(String[] args) {
    FileHandler fh = new FileHandler("input.txt");
    String[] roomsStr = fh.getInputsAsArray();
    Room[] rooms = new Room[roomsStr.length];
    int validCount = 0;
    for(int i = 0; i < roomsStr.length; i++) {
      rooms[i] = new Room(roomsStr[i]);
      if(rooms[i].isValid()) validCount += rooms[i].id;
    }
    System.out.println(validCount);
  }
}
