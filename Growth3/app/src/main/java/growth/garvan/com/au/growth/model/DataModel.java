package growth.garvan.com.au.growth.model;

/**
 * Created by Mohamad on 16/10/2016.
 */

public class DataModel {
    private static DataModel model = new DataModel();

    private Account account;

    private DataModel(){}

    public static DataModel getInstance(){
        return model;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
