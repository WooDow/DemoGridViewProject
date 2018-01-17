package tw.leonchen.demogridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class DemoGridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_grid_view);

        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

        final String[] treasures = {"gold", "silver", "copper", "diamond", "ruby"};
        final int[] image = {R.drawable.icon01,R.drawable.icon02,R.drawable.icon03,R.drawable.icon04,R.drawable.icon05};

        for(int i=0;i<image.length;i++) {
            HashMap<String, Object> record = new HashMap<String, Object>();
            record.put("image", image[i]);
            record.put("text", treasures[i]);
            list.add(record);
        }

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(DemoGridViewActivity.this, android.R.layout.simple_list_item_1, treasures);

        SimpleAdapter adapter = new SimpleAdapter(DemoGridViewActivity.this, list,
                                                   R.layout.customlayout,
                                                   new String[]{"image", "text"},
                                                   new int[]{R.id.image, R.id.text});

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setNumColumns(3);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(DemoGridViewActivity.this, treasures[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
