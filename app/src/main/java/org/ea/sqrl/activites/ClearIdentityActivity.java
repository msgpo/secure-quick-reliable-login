package org.ea.sqrl.activites;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.ea.sqrl.R;
import org.ea.sqrl.processors.SQRLStorage;

public class ClearIdentityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear_identity);

        SQRLStorage storage = SQRLStorage.getInstance();
        storage.clear();

        final ImageView imgClearIdentity = findViewById(R.id.imgClearIdentity);
        final TextView txtClearIdentity = findViewById(R.id.txtClearIdentity);

        final Drawable failureImage = getResources().getDrawable(android.R.drawable.stat_sys_download_done);
        final Drawable successImage = getResources().getDrawable(android.R.drawable.stat_notify_error);

        imgClearIdentity.setImageDrawable(failureImage);
        txtClearIdentity.setText(getString(R.string.clear_identity_fail));
        if(!storage.hasKeys()) {
            imgClearIdentity.setImageDrawable(successImage);
            txtClearIdentity.setText(getString(R.string.clear_identity_success));
        }
    }
}