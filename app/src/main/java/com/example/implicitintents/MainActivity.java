package com.example.implicitintents;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.core.app.ShareCompat;

public class MainActivity extends Activity {
    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareTextEditText = findViewById(R.id.share_edittext);
    }

    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString().trim();
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void openLocation(View view) {
        String loc = mLocationEditText.getText().toString().trim();
        Uri addressUri = Uri.parse("geo:0,0?q=" + Uri.encode(loc));
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void shareText(View view) {
        String txt = mShareTextEditText.getText().toString();
        ShareCompat.IntentBuilder
                .from(this)
                .setType("text/plain")
                .setChooserTitle(R.string.share_text_with)
                .setText(txt)
                .startChooser();
    }
}
