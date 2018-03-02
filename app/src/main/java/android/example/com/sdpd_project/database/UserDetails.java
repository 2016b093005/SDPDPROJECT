package android.example.com.sdpd_project.database;

/**
 * Created by saursaku on 3/1/2018.
 */

public class UserDetails {

    public static final String USER_DETAILS = "User details" ;
    public static final String USER_ID = "UniqueID";
    public static final String LOGIN_ID = "Email id";
    public static final String USER_PASSWORD = "password";
    public static final String ACCOUNT_STATUS = "itemName";


    public static final String SQL_CREATE =
            "CREATE TABLE " + USER_DETAILS + "(" +
                    USER_ID + " TEXT PRIMARY KEY," +
                    LOGIN_ID + "TEXT," +
                    USER_PASSWORD + " TEXT," +
                    ACCOUNT_STATUS + " TEXT," + ");";
    public static final String SQL_DELETE =
            "DROP TABLE " + USER_DETAILS;

}
