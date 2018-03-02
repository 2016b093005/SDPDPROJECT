package android.example.com.sdpd_project.model;

import android.content.ContentValues;
import android.example.com.sdpd_project.database.UserDetails;

import java.util.UUID;

/**
 * Created by saursaku on 3/2/2018.
 */

public class UserData {

    private String userId;
    private String loginID;
    private String password;
    private String accountStatus;

    public UserData(String userId, String loginID, String password, String accountStatus) {

        if (userId == null) {
            userId = UUID.randomUUID().toString();
        }
        this.userId = userId;
        this.loginID = loginID;
        this.password = password;
        this.accountStatus = accountStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public ContentValues toValues(){
        ContentValues values = new ContentValues(4);
        values.put(UserDetails.USER_ID, userId);
        values.put(UserDetails.LOGIN_ID, loginID);
        values.put(UserDetails.USER_PASSWORD, password);
        values.put(UserDetails.ACCOUNT_STATUS, accountStatus);
        return values;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userId='" + userId + '\'' +
                ", loginID='" + loginID + '\'' +
                ", password='" + password + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                '}';
    }
}
