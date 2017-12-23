package co.id.iu33.android.wisatagrobogan;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Server on 27/07/2017.
 */

public class DetailWisata extends AppCompatActivity {
    TextView judul, dsk;
    ImageView gbr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        judul =(TextView)findViewById(R.id.jdl);
        gbr =(ImageView)findViewById(R.id.img);
        dsk = (TextView)findViewById(R.id.desk);
        Intent intent= getIntent();
        String judul1 = intent.getStringExtra("judul");
        String gbr1 = intent.getStringExtra("gambar");
        String desk = intent.getStringExtra("desk");


        try {

            InputStream streamImg = getAssets().open(gbr1);
            Bitmap bmp = BitmapFactory.decodeStream(streamImg);
            gbr.setImageBitmap(bmp);

        } catch (IOException e) {
            e.printStackTrace();
        }

        judul.setText(judul1);
        dsk.setText(desk);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}