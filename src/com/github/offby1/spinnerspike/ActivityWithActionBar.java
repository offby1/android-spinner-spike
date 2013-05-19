package com.github.offby1.spinnerspike;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ActivityWithActionBar extends Activity {

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
            intent = new Intent(mMainActivity, FirstActivity.class);
            break;
        case R.id.second:
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
}
