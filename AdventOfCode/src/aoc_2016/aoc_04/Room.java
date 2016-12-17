package aoc_2016.aoc_04;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Room {
  private String[] encName;
  private String conEncName;
  private String checksum;
  private String sum;
  int id;
  private HashMap<Character, Integer> freqs;
  private HashMap<Character, Integer> fiveFreqs;

  public Room(String roomStr) {
    Pattern p = Pattern.compile("(\\d{3})\\[(\\w{5})\\]");
    sum = "";
    String[] temp = roomStr.split("-");
    Matcher m = p.matcher(temp[temp.length - 1]);
    if(m.find()) {
      id = Integer.valueOf(m.group(1));
      checksum = m.group(2);
    }
//    id = Integer.valueOf(m.group(1));
//    checksum = m.group(1);
    encName = new String[temp.length - 1];
    conEncName = "";
    for (int i = 0; i < temp.length - 1; i++) {
      encName[i] = temp[i];
      conEncName += temp[i];
    }
    freqs = new HashMap<Character, Integer>();
    for (char c : conEncName.toCharArray()) {
      freqs.merge(c, 1, Integer::sum);
    }

    freqs = (HashMap<Character, Integer>) MapUtil.sortByValue(freqs);
    int count = 0;
    for(char c : freqs.keySet()) {
      sum += c;
      count++;
      if(count > 4) break;
    }
    System.out.println(sum + " " + checksum);
  }

  private void printEncName() {
    for (String a : encName) {
      System.out.print(a + " ");
    }
    System.out.println();
  }

  private void printConEncName() {
    System.out.println(conEncName);
  }

  public boolean isValid() {
    return checksum.equals(sum);
  }
}
