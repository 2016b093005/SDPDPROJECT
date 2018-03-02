package android.example.com.sdpd_project;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import android.example.com.sdpd_project.model.DataItem;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Locale;

@SuppressWarnings("FieldCanBeLocal")
public class DetailsActivity extends AppCompatActivity {

    private TextView tvName, tvDescription, tvPrice;
    private ImageView itemImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DataItem item = getIntent().getExtras().getParcelable(DataItemAdapterRecyclerView.ITEM_KEY);
        if (item == null) {
            String item2 = getIntent().getStringExtra(ListViewDisplay.ITEM_KEY_LIST_VIEW);
            throw new AssertionError("Null data item received!");
        }



        tvName = findViewById(R.id.tvItemName);
        tvPrice =  findViewById(R.id.tvPrice);
        tvDescription =  findViewById(R.id.tvDescription);
        itemImage =  findViewById(R.id.itemImage);

        tvName.setText(item.getItemName());
        tvDescription.setText(item.getDescription());

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
        tvPrice.setText(nf.format(item.getPrice()));

        InputStream inputStream = null;
        try {
            String imageFile = item.getImage();
            inputStream = getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            itemImage.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}