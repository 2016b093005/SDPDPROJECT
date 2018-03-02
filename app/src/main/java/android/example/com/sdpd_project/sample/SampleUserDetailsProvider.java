package android.example.com.sdpd_project.sample;

import android.example.com.sdpd_project.model.UserData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saursaku on 3/2/2018.
 */

public class SampleUserDetailsProvider {

    public static List<UserData> userDataList;

    static {
        userDataList = new ArrayList<>();

        addUserDetails(new UserData("1", "ksaurav3@gmail.com", "saurav@1", "open" ));
        addUserDetails(new UserData("2", "ksaurav30@gmail.com", "saurav@1", "open" ));
        addUserDetails(new UserData("3", "ksaurav304@gmail.com", "saurav@1", "open" ));
        addUserDetails(new UserData("4", "ksaurav3045@gmail.com", "saurav@1", "open" ));
        addUserDetails(new UserData("5", "ksaurav30456@gmail.com", "saurav@1", "open" ));
        addUserDetails(new UserData("6", "ksaurav30457@gmail.com", "saurav@1", "open" ));



    }

        private static void addUserDetails(UserData data) {
        userDataList.add(data);

        }

    }