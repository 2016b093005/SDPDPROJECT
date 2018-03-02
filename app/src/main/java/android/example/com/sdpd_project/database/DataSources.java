package android.example.com.sdpd_project.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.example.com.sdpd_project.model.DataItem;
import android.example.com.sdpd_project.model.UserData;

import java.util.List;

public class DataSources {

    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;

    public DataSources(Context context) {
        this.mContext = context;
        mDbHelper = new DBHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void open() {
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close() {
        mDbHelper.close();
    }

    public UserData createUser(UserData user) {
        ContentValues values = user.toValues();
        mDatabase.insert(UserDetails.USER_DETAILS, null, values);
        return user;
    }

    public DataItem createItem(DataItem item) {
        ContentValues values = item.toValues();
        mDatabase.insert(ItemsTable.TABLE_ITEMS, null, values);
        return item;
    }

    public long getUserDataItemsCount() {
        return DatabaseUtils.queryNumEntries(mDatabase, UserDetails.USER_DETAILS);
    }
    public long getItemDataItemsCount() {
        return DatabaseUtils.queryNumEntries(mDatabase, ItemsTable.TABLE_ITEMS);
    }

    public void seedDatabaseItem(List<DataItem> dataItemList) {
        long numItems = getItemDataItemsCount();
        if (numItems == 0) {
            for (DataItem item :
                    dataItemList) {
                try {
                    createItem(item);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void seedDatabaseUser(List<UserData> userLoginList) {
        long numItems = getUserDataItemsCount();
        if (numItems == 0) {
            for (UserData user :
                    userLoginList) {
                try {
                    createUser(user);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}