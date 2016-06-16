package soberstories.app.jsmtech.fruitlist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    protected ArrayList<String> fruitList;
    private RecyclerView recList;
    private ProgressBar progressBar;
    private FruitAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recList = (RecyclerView) findViewById(R.id.fruit_list);
        progressBar = (ProgressBar) findViewById(R.id.fruit_progress_bar);


        final LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);

        llm.setOrientation(
                LinearLayoutManager.VERTICAL
        );
        recList.setLayoutManager(llm);
        recList.setHasFixedSize(true);




        generateFruitList();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as we specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void generateFruitList(){
        fruitList = new ArrayList<String>();

        fruitList.add("Apple");

        String[] otherList = new String[] {"Apple", "Orange", "Banana", "Guava", "Litchi", "Strawberry"};
        fruitList.addAll(Arrays.asList(otherList));

        //fruitList.addAll(Arrays.asList("a", "b", "c", "d"));


        mAdapter = new FruitAdapter(MainActivity.this, fruitList);
        recList.setAdapter(mAdapter);


    }
}
