package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the URL for the website you wish to use: ");
    String urlString = input.nextLine();
    input.close();
    StringBuilder page = new StringBuilder();

    try {
      URL url = new URL(urlString);
      URLConnection con = url.openConnection();
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      while(in.ready()) {
        page.append(in.readLine());
      }
      extractURLs(page.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void extractURLs(String html) {
    String pattern = "\"(https?:\\/\\/.*?)\"";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(html);
    while(m.find()) {
      System.out.println(m.group(1));
    }
  }
}
