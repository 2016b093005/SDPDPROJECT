package android.example.com.sdpd_project;

import android.content.Intent;
import android.example.com.sdpd_project.model.DataItem;
import android.example.com.sdpd_project.sample.SampleDataProvider;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            }

    @Override
    protected void onPause() {
        super.onPause();
            }

    @Override
    protected void onResume() {
        super.onResume();
            }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case  R.id.action_signout:
                Intent intent = new Intent(this, SigninActivity.class);
                startActivity(intent);
                return true;
            case  R.id.settings_action:
                Intent settingIntent = new Intent(this, PrefsActivity.class);
                startActivity(settingIntent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }



    // Code To Display Data in Recycler View
    public void RecycleViewDisplay(View view) {

        Intent intent = new Intent(this, RecyclerViewDisplay.class);
        startActivity(intent);

    }

// Code to Display Data in List View

    public void ListViewDisplay(View view) {
        Intent intent = new Intent(this, ListViewDisplay.class);
        startActivity(intent);

    }

}
