package com.samkantor.borderdelays;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.samkantor.borderdelays.model.Port;
import com.samkantor.borderdelays.model.RealmHandler;

import java.util.ArrayList;

public class ActivityMain extends AppCompatActivity {

    private RealmHandler mRealmHandler;
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mRealmHandler = new RealmHandler(this);

        refreshUI();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Developer) {
            //Snackbar.make(this.findViewById(android.R.id.content),
            //        "Port Test added!", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            mRealmHandler.insertPort("Test" + String.valueOf(mRealmHandler.getPortList().size()));
            refreshUI();
        }

        return super.onOptionsItemSelected(item);
    }

    public void refreshUI() {
        mListView = (ListView) findViewById(R.id.port_list);
        ArrayList<Port> portList = mRealmHandler.getPortList();
        String [] arr = new String[portList.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = portList.get(i).getName();
        }
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        mListView.setAdapter(mAdapter);

    }

    public void getPortList() {
        ArrayList<Port> portList = mRealmHandler.getPortList();
        for (Port port : portList) {
            Toast.makeText(this, port.getName(), Toast.LENGTH_SHORT ).show();
        }
    }
}
