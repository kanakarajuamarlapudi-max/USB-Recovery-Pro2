
package com.usbrecovery.pro;

import android.app.Activity;
import android.app.AlertDialog;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends Activity {

    private TextView status;
    private UsbManager usbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        usbManager = (UsbManager) getSystemService(USB_SERVICE);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(32, 48, 32, 32);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView title = new TextView(this);
        title.setText("USB Recovery Pro");
        title.setTextSize(28);
        title.setGravity(Gravity.CENTER);
        layout.addView(title);

        status = new TextView(this);
        status.setText("Connect your USB pendrive using OTG.");
        status.setTextSize(17);
        status.setPadding(0, 40, 0, 30);
        layout.addView(status);

        Button scanButton = new Button(this);
        scanButton.setText("SCAN USB DRIVE");
        layout.addView(scanButton);

        scanButton.setOnClickListener(v -> scanUsb());

        setContentView(layout);
    }

    private void scanUsb() {

        HashMap<String, UsbDevice> devices =
                usbManager.getDeviceList();

        if (devices.isEmpty()) {
            status.setText("No USB device detected.");
            new AlertDialog.Builder(this)
                    .setTitle("USB Not Found")
                    .setMessage("Connect your pendrive using a compatible OTG adapter.")
                    .setPositiveButton("OK", null)
                    .show();
            return;
        }

        StringBuilder result = new StringBuilder();

        for (UsbDevice device : devices.values()) {
            result.append("Device: ")
                    .append(device.getDeviceName())
                    .append("\nVendor ID: ")
                    .append(device.getVendorId())
                    .append("\nProduct ID: ")
                    .append(device.getProductId())
                    .append("\n\n");
        }

        status.setText("USB device detected!");

        new AlertDialog.Builder(this)
                .setTitle("USB Devices Found")
                .setMessage(result.toString())
                .setPositiveButton("OK", null)
                .show();
    }
}
