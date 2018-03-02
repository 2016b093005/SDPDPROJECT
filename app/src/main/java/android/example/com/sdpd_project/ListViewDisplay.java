package android.example.com.sdpd_project;

import android.example.com.sdpd_project.model.DataItem;
import android.example.com.sdpd_project.sample.SampleDataProvider;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by saursaku on 3/1/2018.
 */

public class ListViewDisplay extends AppCompatActivity {
    public static final String ITEM_KEY_LIST_VIEW = "Item key list view";
    List<DataItem> dataItemList = SampleDataProvider.dataItemList;
    List<String> itemNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        for (DataItem item : dataItemList) {
            itemNames.add(item.getItemName());
        }
        Collections.sort(itemNames);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, itemNames);

        ListView listView = (ListView) findViewById(R.id.list_view_display);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = ((TextView)view).getText().toString();
                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();
            }
        });
    }
}
