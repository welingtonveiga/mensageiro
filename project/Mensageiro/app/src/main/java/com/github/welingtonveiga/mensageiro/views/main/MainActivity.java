package com.github.welingtonveiga.mensageiro.views.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.github.welingtonveiga.mensageiro.R;
import com.github.welingtonveiga.mensageiro.services.RefreshService;
import com.github.welingtonveiga.mensageiro.views.settings.SettingsActivity;
import com.github.welingtonveiga.mensageiro.views.status.StatusActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;

            case R.id.action_tweet:
                startActivity(new Intent(this, StatusActivity.class));
                return true;

            case R.id.action_refresh:
                startService(new Intent(this, RefreshService.class));
                // Refresh
                startActivity(new Intent(this, MainActivity.class));
                finish();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
