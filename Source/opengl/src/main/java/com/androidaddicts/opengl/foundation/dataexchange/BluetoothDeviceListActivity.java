package com.androidaddicts.opengl.foundation.dataexchange;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.androidaddicts.opengl.R;

import java.util.Set;

public class BluetoothDeviceListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static String EXTRA_DEVICE_ADDR = "device_address";
    private BluetoothAdapter mBtAdapter;
    private ArrayAdapter<String> mAdapterPaired;
    private ArrayAdapter<String> mAdapterNew;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_device_list);

        setResult(Activity.RESULT_CANCELED);

        init();
    }

    private void init() {
        mAdapterPaired = new ArrayAdapter<String>(this, R.layout.device_name);
        mAdapterNew = new ArrayAdapter<String>(this, R.layout.device_name);

        ListView lvPaired = findViewById(R.id.paired_devices);
        ListView lvNew = findViewById(R.id.new_devices);

        lvPaired.setAdapter(mAdapterPaired);
        lvNew.setAdapter(mAdapterNew);

        lvPaired.setOnItemClickListener(this);
        lvNew.setOnItemClickListener(this);

        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        this.registerReceiver(mReceiver, filter);

        filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        this.registerReceiver(mReceiver, filter);

        mBtAdapter = BluetoothAdapter.getDefaultAdapter();

        Set<BluetoothDevice> pairedDevices = mBtAdapter.getBondedDevices();

        if (pairedDevices.size() > 0) {
            findViewById(R.id.title_paired_devices).setVisibility(View.VISIBLE);
            for (BluetoothDevice device: pairedDevices) {
                mAdapterPaired.add(device.getName() + "\n" + device.getAddress());
            }
        }else {
            String noDevice = getResources().getText(R.string.none_paired).toString();
            mAdapterPaired.add(noDevice);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBtAdapter != null) {
            mBtAdapter.cancelDiscovery();
        }
        this.unregisterReceiver(mReceiver);
    }

    private void doDiscovery() {
        setTitle(R.string.scanning);
        findViewById(R.id.title_new_devices).setVisibility(View.VISIBLE);
        if (mBtAdapter.isDiscovering()) {
            mBtAdapter.cancelDiscovery();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mBtAdapter.cancelDiscovery();
        String msg = ((TextView) view).getText().toString();
        String address = msg.substring(msg.length() - 17);
        Intent intent = new Intent();
        intent.putExtra(EXTRA_DEVICE_ADDR, address);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void scan(View view) {
        doDiscovery();
        view.setVisibility(View.GONE);
    }

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
                    mAdapterNew.add(device.getName() + "\n" + device.getAddress());
                }
            }else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                setTitle(R.string.select_device);
                if (mAdapterNew.getCount() == 0) {
                    String noDevice = getResources().getText(R.string.none_found).toString();
                    mAdapterNew.add(noDevice);
                }
            }
        }
    };
}
