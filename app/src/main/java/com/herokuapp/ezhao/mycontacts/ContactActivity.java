package com.herokuapp.ezhao.mycontacts;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;


public class ContactActivity extends Activity {
    public static final int CONTACT_LOADER_ID = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);

        final ContactRecyclerAdapter adapter = new ContactRecyclerAdapter();
        recyclerView.setAdapter(adapter);

        LoaderManager.LoaderCallbacks<Cursor> contactsLoader =
                new LoaderManager.LoaderCallbacks<Cursor>() {
                    @Override
                    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
                        String[] fields = new String[] {
                                ContactsContract.Contacts.DISPLAY_NAME,
                                ContactsContract.CommonDataKinds.Email.ADDRESS
                        };
                        return new CursorLoader(ContactActivity.this,
                                ContactsContract.CommonDataKinds.Email.CONTENT_URI,
                                fields,
                                ContactsContract.Contacts.HAS_PHONE_NUMBER + " = 1",
                                null,
                                null);
                    }

                    @Override
                    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
                        adapter.setCursor(cursor);
                    }

                    @Override
                    public void onLoaderReset(Loader<Cursor> loader) {
                        adapter.setCursor(null);
                    }
                };
        getLoaderManager().initLoader(CONTACT_LOADER_ID, new Bundle(), contactsLoader);
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
