package com.github.offby1.spinnerspike;

import android.app.Activity;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class ActivityWithActionBar extends Activity implements ActionBar.OnNavigationListener {

    ActivityWithActionBar mMainActivity;

    public ActivityWithActionBar() {
        super();
        mMainActivity = this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent = null;
        int position = item.getItemId();

        switch (position) {
        case R.id.first:
        case R.id.bean:
        case R.id.sprout:
        case R.id.carrot:
            intent = new Intent(mMainActivity, FirstActivity.class);
            break;
        case R.id.second:
        case R.id.pork:
        case R.id.beef:
        case R.id.turkey:
            intent = new Intent(mMainActivity, SecondActivity.class);
            break;
        }

        if (intent != null) {
            startActivity(intent);
        } else {
            Toast.makeText(ActivityWithActionBar.this,
                           String.format ("position %d isn't yet written", position),
                           Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.action_list,
                                                                         android.R.layout.simple_spinner_dropdown_item);
        actionBar.setListNavigationCallbacks(mSpinnerAdapter, this);
    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        // TODO Auto-generated method stub
        Toast.makeText(ActivityWithActionBar.this,
                       String.format ("itemPosition %d; itemId %d", itemPosition, itemId),
                       Toast.LENGTH_SHORT).show();
        return false;
    }
}
