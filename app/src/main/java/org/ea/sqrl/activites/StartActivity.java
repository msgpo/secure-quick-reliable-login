package org.ea.sqrl.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.ea.sqrl.R;

/**
 *
 * @author Daniel Persson
 */
public class StartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final TextView txtWelcomeMessage = findViewById(R.id.txtWelcomeMessage);
        txtWelcomeMessage.setMovementMethod(new ScrollingMovementMethod());

        final Button btnScanSecret = findViewById(R.id.btnScanSecret);
        btnScanSecret.setOnClickListener(v -> new Thread(() -> {
            Intent intent = new Intent(StartActivity.this, ScanActivity.class);
            intent.putExtra(ScanActivity.SCAN_MODE_MESSAGE, ScanActivity.SCAN_MODE_SECRET);
            startActivity(intent);
        }).start());
    }
}
