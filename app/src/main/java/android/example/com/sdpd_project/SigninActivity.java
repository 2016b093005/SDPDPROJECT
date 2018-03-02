package android.example.com.sdpd_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.sdpd_project.database.DataSources;
import android.example.com.sdpd_project.model.DataItem;
import android.example.com.sdpd_project.sample.SampleDataProvider;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * A login screen that offers login via email/password.
 */
public class SigninActivity extends AppCompatActivity  {

    public static final String EMAIL_KEY = "email_key";
    public static final String MY_GLOBAL_PREFS = "my_global_prefs";
    // UI references.
    private TextView mEmailView;
    private EditText mPasswordView;

    // Login Database Details
    DataSources mDataSource;
    List<DataItem> dataItemList = SampleDataProvider.dataItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mDataSource = new DataSources(this);
        mDataSource.open();
        mDataSource.seedDatabaseItem(dataItemList);



        Toast.makeText(this, "Database acquired!", Toast.LENGTH_SHORT).show();


        mEmailView = (TextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);


        // On Click Listener for Sign IN Button

        mEmailSignInButton.setOnClickListener(view -> attemptLogin());

        // Reading and updating Email Data from Shared Preference

        SharedPreferences prefs =
                getSharedPreferences(MY_GLOBAL_PREFS, MODE_PRIVATE);
        String email = prefs.getString(EMAIL_KEY, "");
        if (!TextUtils.isEmpty(email)) {
            mEmailView.setText(email);
            mPasswordView.setText("Enter Password ");
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
//        mDataSource.Close();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        mDataSource.Open();
    }

    private void attemptLogin() {



        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        //Writing Latest Email Id To Shared Preference

        if (email != null) {

            SharedPreferences.Editor editor =
                    getSharedPreferences(MY_GLOBAL_PREFS, MODE_PRIVATE).edit();
            editor.putString(EMAIL_KEY, email);
            editor.apply();

        }



        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

}

