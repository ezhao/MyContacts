package com.herokuapp.ezhao.mycontacts;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class ContactActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<ContactInfo> contacts = new ArrayList<>();
        contacts.add(new ContactInfo("Name of Person", "email@gmail.com"));
        contacts.add(new ContactInfo("Name of Person", "email@gmail.com"));
        contacts.add(new ContactInfo("Name of Person", "email@gmail.com"));
        contacts.add(new ContactInfo("Name of Person", "email@gmail.com"));
        contacts.add(new ContactInfo("Name of Person", "email@gmail.com"));
        contacts.add(new ContactInfo("Name of Person", "email@gmail.com"));
        contacts.add(new ContactInfo("Name of Person", "email@gmail.com"));
        contacts.add(new ContactInfo("Name of Person", "email@gmail.com"));
        contacts.add(new ContactInfo("Name of Person", "email@gmail.com"));

        ContactRecyclerAdapter adapter = new ContactRecyclerAdapter(contacts);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
