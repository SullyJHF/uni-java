package lecturecises;

public class Main {
  public static void main(String[] args) {
    String s0 = "fish";
    System.out.println(s0);

    String s1 = new String("chocolate");
    String s2 = new String();
    s2 = "ice cream";
    String s3 = new String(s1);

    char charArray[] = { 'H', 'e', 'l', 'l', 'o', '!', '!' };
    String s4 = new String(charArray);
    System.out.println(s4);
    
    int length = s1.length();
    System.out.println(length);
    System.out.println(s1.charAt(6));
    
    char[] tempCharArray = new char[4];
    s1.getChars(5, 9, tempCharArray, 0);
    for(char c : tempCharArray) {
      System.out.print(c);
    }
    System.out.println();
    
    String i = "ice";
    String c = "cream";
    String ic = i.concat(c);
    System.out.println(ic);
    
    System.out.println(i + " " + c);
    
    String surname = "Weir";
    System.out.println("The Head of BLE is Prof " + surname);
    
    String person = "Fred";
    person += " ";
    person += surname;
    
    System.out.println(person);
    
    // string equality
    s1 = new String("chocolate");
    s4 = "Chocolate";
    String s5 = "chocolate ";
    System.out.println(s1.equals(s5));
    System.out.println(s1.equals("chocolate"));
    
    System.out.println(s1 == "chocolate");
    System.out.println(s4 == "Chocolate");
    String s6 = "Choco";
    s6 += "late";
    System.out.println(s4 == s6);
    int a = 2;
    s2 = "2";
    System.out.println(s2.equals(a));
    System.out.println(s2.startsWith("choc"));
    
    System.out.println(ic.substring(3, 8));
    
    System.out.println(s1.indexOf('o'));
    System.out.println(s1.indexOf("ola"));
    System.out.println(s1.lastIndexOf('o'));
    
    System.out.println(ic.replaceAll("ice", "custard"));
    
    
    StringBuilder sb = new StringBuilder();
    sb.append("appending number ");
    sb.append(10);
    System.out.println(sb.toString());
    
    sb.delete(0, 9);
    System.out.println(sb.toString());
    
    sb.insert(7, " sweet");
    System.out.println(sb.toString());
    
    sb.replace(4, 8, "urge");
    System.out.println(sb.toString());
    
    sb.reverse();
    System.out.println(sb.toString());
  }
}
