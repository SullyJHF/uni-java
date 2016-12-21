package single;

import java.util.ArrayList;

public class Accounts extends ArrayList<Account> {
  private static Accounts accounts = null;

  private Accounts() {}

  public static Accounts getInstance() {
    if (accounts == null) {
      accounts = new Accounts();
    }
    return accounts;
  }

  public Account getAccount(String name, String surname) {
    for(Account a : this) {
      if(a.getName().equals(name) && a.getSurname().equals(surname)) {
        return a;
      }
    }
    return null;
  }
}
