
package com.usbrecovery.pro;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(32, 48, 32, 32);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView title = new TextView(this);
        title.setText("USB Recovery Pro");
        title.setTextSize(28);
        title.setGravity(Gravity.CENTER);
        layout.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("Recover files from USB drives");
        subtitle.setTextSize(16);
        subtitle.setGravity(Gravity.CENTER);
        layout.addView(subtitle);

        status = new TextView(this);
        status.setText("Connect your USB pendrive using OTG.");
        status.setTextSize(16);
        status.setPadding(0, 40, 0, 30);
        layout.addView(status);

        Button scanButton = new Button(this);
        scanButton.setText("SCAN USB DRIVE");
        layout.addView(scanButton);

        scanButton.setOnClickListener(v ->
            Toast.makeText(this,
                "USB scanning feature is coming next.",
                Toast.LENGTH_SHORT).show()
        );

        setContentView(layout);
    }
}
