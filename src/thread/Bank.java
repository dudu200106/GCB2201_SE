package thread;

public class Bank {
    private int account;

    public Bank(int account) {
        this.account = account;
    }

    public boolean getMoney(int money){
        int account = getAccount();
        if (account>=money){
            account-=money;
            saveAccount(account);
            return true;
        }
        return false;
    }

    private void saveAccount(int account) {
        this.account=account;
    }

    public int getAccount() {
        return account;
    }
}
