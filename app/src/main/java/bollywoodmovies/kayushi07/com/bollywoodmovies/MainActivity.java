package bollywoodmovies.kayushi07.com.bollywoodmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    GridView simpleGrid;
    int logos[] = {R.drawable.f_2017, R.drawable.f_2011, R.drawable.f_2006, R.drawable.f_2001, R.drawable.f_1996, R.drawable.f_1990};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        simpleGrid = (GridView) findViewById(R.id.main_grid); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        CustomGridAdapter customAdapter = new CustomGridAdapter(getApplicationContext(), logos);
        simpleGrid.setAdapter(customAdapter);
        // implement setOnItemClickListener event on GridView
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                Intent intent = new Intent(MainActivity.this, MovieListActivity.class);
                intent.putExtra("id", position);
                startActivity(intent);
                }
        });
    }
}
