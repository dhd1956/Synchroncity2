package com.mind.oceanic.the.synchronicity2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.mind.oceanic.the.synchronicity2.importExport.DownloadJSON;
import com.mind.oceanic.the.synchronicity2.event.EventListActivity;
import com.mind.oceanic.the.synchronicity2.match.MatchKeywordsActivity;
import com.mind.oceanic.the.synchronicity2.synch.SynchListActivity;

/**
 * Created by dave on 2/6/16.
 */
public class MainActivity extends Activity {

    TextView tvIntro;
    TextView tvContents1;
    TextView tvContents2;
    TextView tvContents3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvIntro = (TextView) findViewById(R.id.tv_intro);
        tvContents1 = (TextView) findViewById(R.id.tv_contents1);
        tvContents2 = (TextView) findViewById(R.id.tv_contents2);
        tvContents3 = (TextView) findViewById(R.id.tv_contents3);

        tvIntro.setText(Html.fromHtml("<p>Welcome to the Synchronicity Tracker.</p> " +
                "There is a companion site at 'TheOceanicMind.com' where you can upload synchronistic events. You can also download " +
                "events from there to your smart phone. This site provides a forum to showcase your synchronicities anonymously and see what " +
                "other people have. The site is being further upgraded to include help for this app. If you are upgrading your phone " +
                "you can use this site to retain and transfer your synchronistic information to your new phone. "+
                "For support or general comments, please email: admin@TheOceanicMind.com. " +
                "<br><br>The term synchronicity was coined by Carl Jung. He applied it to events that are considered 'meaningful coincidences'. Events where there is no apparent causal relationship but they seem to be meaningfully related.<br></p> <p>This app is intended to facilitate the tracking of events and assistance in discovering synchronicity. It is a bit of a time machine in that you can set the date forward or backward and 'connect the dots' between events at any time"));

        //tvContents1.setText(Html.fromHtml("<u>Maintain Events</u></> - used to log events that may or may not appear synchronistic. They can be linked at a later date if applicable."));
        //tvContents2.setText(Html.fromHtml("<br><u>Maintain Synchronicity</u></> - used when you have a synchronistic event in mind and you want to record it and associated events."));
        //tvContents3.setText(Html.fromHtml("<br><u>Match Synchronistic Events</u></> - used to compare events."));
    }

    //    private void setButtons() {
//
//        Button btn_goto_synch = (Button) findViewById(R.id.btn_goto_synch);
//
//        btn_goto_synch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v2) {
//                Intent intent1 = new Intent(MainActivity.this, SynchListActivity.class);
//                startActivityForResult(intent1, 1);
//
//            }
//        });
//
//        Button btn_goto_match = (Button) findViewById(R.id.btn_goto_match);
//
//        btn_goto_match.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2 = new Intent(MainActivity.this, MatchKeywordsActivity.class);
//                startActivityForResult(intent2, 1);
//            }
//        });
//
//        Button btn_goto_event = (Button) findViewById(R.id.btn_goto_event);
//
//        btn_goto_event.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent3 = new Intent(MainActivity.this, EventListActivity.class);
//                intent3.putExtra("EventSource", "EventList");
//                startActivityForResult(intent3, 1);
//            }
//        });
//
//
//    }
    protected void maintainEvents() {

    Intent intent5 = new Intent(MainActivity.this, EventListActivity.class);
    intent5.putExtra("EventSource","EventList");
    startActivityForResult(intent5, 5);
}
    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public void openMaintainEvents(View view){
        maintainEvents();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem i) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = i.getItemId();

        switch (i.getItemId()) {

//            case R.id.action_settings:
//                Intent intent = new Intent(this, HttpMainActivity.class);
//                startActivity(intent);
//                break;

            case R.id.menu_maintain_synchronicity:
                Intent intent4 = new Intent(MainActivity.this, SynchListActivity.class);
                startActivityForResult(intent4, 4);
                break;

            case R.id.menu_maintain_events:
                maintainEvents();
                break;

            case R.id.menu_match_events:
                Intent intent6 = new Intent(MainActivity.this, MatchKeywordsActivity.class);
                startActivityForResult(intent6, 6);
                break;

            case R.id.menu_import:
                Intent intent7 = new Intent(MainActivity.this, DownloadJSON.class);
                Log.i("dolphinp","intent7");
                startActivity(intent7);
                break;
//                )
//                if (isOnline) {
//                    requestData("http://10.0.0.2/feeds/synchItems.json");
//                } else {
//                    Toast.makeText(this,"no network",Toast.LENGTH_LONG).show();
//                }
//                break;

            default:
                break;
        }

        return super.onOptionsItemSelected(i);
    }

    /**
     * Created by dave on 8/13/15.
     */
    public static class SettingsActivity {
    }
}


