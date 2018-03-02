package android.example.com.sdpd_project;

import android.example.com.sdpd_project.model.DataItem;
import android.example.com.sdpd_project.sample.SampleDataProvider;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by saursaku on 3/1/2018.
 */

public class RecyclerViewDisplay extends AppCompatActivity {

    List<DataItem> dataItemList = SampleDataProvider.dataItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        Collections.sort(dataItemList, new Comparator<DataItem>() {
            @Override
            public int compare(DataItem o1, DataItem o2) {
                return o1.getItemName().compareTo(o2.getItemName());
            }
        });

        DataItemAdapterRecyclerView adapter = new DataItemAdapterRecyclerView(this, dataItemList);

        RecyclerView recyclerView =  findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
    }
}
