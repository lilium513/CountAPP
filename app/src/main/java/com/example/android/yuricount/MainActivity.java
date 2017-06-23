package com.example.android.yuricount;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count1 ;
    int count2 ;
    private FloatingActionButton button;
    private static final int RESULT_PICK_IMAGEFILE = 1001;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        count1=0;
        count2=0;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imageView = (ImageView)findViewById(R.id.imageView);

        Button b1= (Button) findViewById(R.id.yuri);

        b1.setOnClickListener(new View.OnClickListener() {
            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                TextView t1 = (TextView) findViewById(R.id.yuriVote);
                count1++;
                t1.setText(String.valueOf(count1)+ "票");

            }
        });
        Button b2= (Button) findViewById(R.id.notYuri);
        b2.setOnClickListener(new View.OnClickListener() {
            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                TextView t2 = (TextView) findViewById(R.id.notYuriVote);
                count2++;
                t2.setText(String.valueOf(count2)+ "票");

            }
        });
        TextView t1 = (TextView) findViewById(R.id.yuriVote);
        t1.setText(String.valueOf(count1)+ "票");
        TextView t2 = (TextView) findViewById(R.id.notYuriVote);
        t2.setText(String.valueOf(count2)+ "票");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        button = (FloatingActionButton)findViewById(R.id.fab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's file browser.
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

                // Filter to only show results that can be "opened", such as a
                // file (as opposed to a list of contacts or timezones)
                intent.addCategory(Intent.CATEGORY_OPENABLE);

                // Filter to show only images, using the image MIME data type.
                // it would be "*/*".
                intent.setType("image/*");

                startActivityForResult(intent, RESULT_PICK_IMAGEFILE);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.yuri:

                break;

            case R.id.notYuri:
                TextView t2 = (TextView) findViewById(R.id.notYuriVote);
                count2++;
                t2.setText(String.valueOf(count2)+ "票");
                break;


        }
    }

    @Override
        public void onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {

        // The ACTION_OPEN_DOCUMENT intent was sent with the request code
        // READ_REQUEST_CODE. If the request code seen here doesn't match, it's the
        // response to some other intent, and the code below shouldn't run at all.

        if (requestCode == RESULT_PICK_IMAGEFILE  && resultCode == Activity.RESULT_OK) {
            // The document selected by the user won't be returned in the intent.
            // Instead, a URI to that document will be contained in the return intent
            // provided to this method as a parameter.
            // Pull that URI using resultData.getData().
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                imageView.setImageURI(uri);
            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.reset:
                count2=count1=0;
                
                return true;
            case R.id.edit_text:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
// ボタンに OnClickListener インターフェースを実装する

}
