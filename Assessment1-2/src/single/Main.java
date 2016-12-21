package single;

import java.util.Date;

public class Main {
  public static void main(String[] args) {
    // Accounts accounts = new Accounts();
    // This can't work because the constructor of Accounts is private

    Accounts accounts = Accounts.getInstance();
    accounts.add(new Account("Sullivan", "Ford", new Date(1996, 8, 2)));
    accounts.add(new Account("Jim", "Bob", new Date(1989, 7, 17)));
    accounts.add(new Account("Sally", "Greene", new Date(2000, 5, 9)));
    accounts.add(new Account("Gregg", "Hitchcock", new Date(1976, 11, 27)));

    for (Account a : accounts) {
      System.out.println(a.getName() + " " + a.getSurname());
    }
    System.out.println();

    // Accounts newAccounts = new Accounts();
    // Again this can't work as the constructor is private
    // this is so that a new instance cannot be created
    Accounts newAccounts = Accounts.getInstance();

    for (Account a : newAccounts) {
      System.out.println(a.getName() + " " + a.getSurname());
    }
    System.out.println();

    accounts = null;
    newAccounts = null;

    Accounts superNewAccounts = Accounts.getInstance();

    for (Account a : superNewAccounts) {
      System.out.println(a.getName() + " " + a.getSurname());
    }
    // here, even though the previous two references to the accounts instance
    // are destroyed, the superNewAccounts variable still contains the same
    // account information that was in the previous two, as it is a static
    // variable within Accounts
  }
}
