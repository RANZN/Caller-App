package com.ranzan.callerapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClicked {
    private RecyclerView recyclerView;
    private final int REQ_CODE = 1;
    private ArrayList<Contact> contactArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        buildData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        ContactAdapter contactAdapter = new ContactAdapter(contactArrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void buildData() {
        for (int i = 0; i < 25; i++) {
            Contact contact = new Contact("tesghds", "7856534789");
            contactArrayList.add(contact);
        }

    }

    private void initView() {
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.READ_CONTACTS}, REQ_CODE);
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length >= 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Contacts Permission Granted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Contacts Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClicked(Contact contact, int position) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", contact.getContactNo(), null));
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}