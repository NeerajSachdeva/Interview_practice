package scenario;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Entry point for the Banking System application.
 * Demonstrates creation of accounts, deposits, withdrawals,
 * transfers, transaction history and top-K accounts.
 */
public class BankingSystem {

    public static void main(String[] args) {

        Bank bank = new Bank();

        bank.createAccount("A1");
        bank.createAccount("A2");
        bank.createAccount("A3");

        bank.deposit("A1", 1000);
        bank.deposit("A2", 500);
        bank.deposit("A3", 2000);

        bank.transfer("A3", "A1", 300);
        bank.withdraw("A1", 200);

        System.out.println("Balance A1: " + bank.getBalance("A1"));
        System.out.println("Balance A2: " + bank.getBalance("A2"));
        System.out.println("Balance A3: " + bank.getBalance("A3"));

        System.out.println("\nTop 2 Accounts:");
        bank.getTopKAccounts(2).forEach(System.out::println);

        System.out.println("\nTransaction History A1:");
        bank.getTransactions("A1").forEach(System.out::println);
    }
}

/**
 * Represents the central banking service that manages accounts
 * and performs operations such as deposit, withdrawal, transfer
 * and querying account data.
 */
class Bank {

    /** Stores all accounts mapped by account id. */
    private Map<String, Account> accountsMap = new ConcurrentHashMap<>();

    /**
     * Creates a new bank account.
     *
     * @param id unique account identifier
     */
    public void createAccount(String id) {
        accountsMap.putIfAbsent(id, new Account(id));
    }

    public void deposit(String id, int amount) {
        Account acc = getAccount(id);
        synchronized (acc) {
            acc.addTransaction(new Transaction("DEPOSIT", amount));
        }
    }

    /**
     * Withdraws money from an account if sufficient balance exists.
     *
     * @param id account identifier
     * @param amount amount to withdraw
     * @return true if withdrawal succeeded, false otherwise
     */
    public boolean withdraw(String id, int amount) {
        Account acc = getAccount(id);

        synchronized (acc) {
            if (acc.getBalance() < amount)
                return false;

            acc.addTransaction(new Transaction("WITHDRAW", -amount));
            return true;
        }
    }

    /**
     * Transfers money from one account to another.
     *
     * @param from source account id
     * @param to destination account id
     * @param amount amount to transfer
     * @return true if transfer succeeded, false otherwise
     */
    public boolean transfer(String from, String to, int amount) {

        Account acc1 = getAccount(from);
        Account acc2 = getAccount(to);

        synchronized (acc1) {
            synchronized (acc2) {

                if (acc1.getBalance() < amount)
                    return false;

                acc1.addTransaction(new Transaction("TRANSFER_OUT", -amount));
                acc2.addTransaction(new Transaction("TRANSFER_IN", amount));

                return true;
            }
        }
    }

    /**
     * Returns the current balance of an account.
     *
     * @param id account identifier
     * @return account balance
     */
    public int getBalance(String id) {
        return getAccount(id).getBalance();
    }

    /**
     * Retrieves the transaction history for an account.
     *
     * @param id account identifier
     * @return list of transactions
     */
    public List<Transaction> getTransactions(String id) {
        return getAccount(id).getTransactions();
    }

    /**
     * Returns the top K accounts with the highest balances.
     *
     * @param k number of accounts to return
     * @return list of top K accounts sorted by balance descending
     */
    public List<Account> getTopKAccounts(int k) {
        PriorityQueue<Account> pq =
                new PriorityQueue<>(Comparator.comparingInt(Account::getBalance));

        for (Account acc : accountsMap.values()) {

            pq.offer(acc);

            if (pq.size() > k)
                pq.poll();
        }

        List<Account> result = new ArrayList<>(pq);
        result.sort((a, b) -> b.getBalance() - a.getBalance());

        return result;
    }

    /**
     * Retrieves an account object for a given id.
     *
     * @param id account identifier
     * @return account object
     * @throws RuntimeException if account does not exist
     */
    private Account getAccount(String id) {

        if (!accountsMap.containsKey(id))
            throw new RuntimeException("Account not found");

        return accountsMap.get(id);
    }
}

/**
 * Represents a bank account.
 * Stores transaction ledger and computes balance
 * based on transaction history.
 */
class Account {

    /** Unique identifier of the account. */
    private String id;

    /** Ledger storing all transactions associated with this account. */
    private List<Transaction> ledger = new ArrayList<>();

    /**
     * Creates a new account.
     *
     * @param id account identifier
     */
    public Account(String id) {
        this.id = id;
    }

    /**
     * Adds a transaction entry to the account ledger.
     *
     * @param t transaction to record
     */
    public void addTransaction(Transaction t) {
        ledger.add(t);
    }

    /**
     * Computes the account balance by summing all transactions.
     *
     * @return calculated account balance
     */
    public int getBalance() {

        int balance = 0;

        for (Transaction t : ledger)
            balance += t.amount;

        return balance;
    }

    /**
     * Returns the full transaction history.
     *
     * @return list of transactions
     */
    public List<Transaction> getTransactions() {
        return ledger;
    }


    public String toString() {
        return "Account{id='" + id + "', balance=" + getBalance() + "}";
    }
}

/**
 * Represents a financial transaction such as deposit,
 * withdrawal or transfer.
 */
class Transaction {

    /** Type of transaction (DEPOSIT, WITHDRAW, TRANSFER_IN, TRANSFER_OUT). */
    String type;

    /** Amount involved in the transaction. */
    int amount;

    /** Timestamp when the transaction occurred. */
    long timestamp;

    public Transaction(String type, int amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = System.currentTimeMillis();
    }

    public String toString() {
        return type + " : " + amount + " @ " + timestamp;
    }
}