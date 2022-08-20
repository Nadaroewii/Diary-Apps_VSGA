package com.lat1.proyek_3_vsga_nada;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class RegistrationActivity extends AppCompatActivity {
    EditText Username, Password, Email, NamaLengkap, AsalSekolah, Alamat;
    Button Simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Register");
        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        Email = findViewById(R.id.Email);
        NamaLengkap = findViewById(R.id.NamaLengkap);
        AsalSekolah = findViewById(R.id.AsalSekolah);
        Alamat = findViewById(R.id.Alamat);
        Simpan = findViewById(R.id.Simpan);
        Simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidation()) {
                    tampilkanKonfirmasiRegister();
                } else {
                    Toast.makeText(RegistrationActivity.this, "Mohon Lengkapi Seluruh Data!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    boolean isValidation() {
        if (Username.getText().toString().equals("") ||
                Password.getText().toString().equals("") || Email.getText().toString().equals("") || NamaLengkap.getText().toString().equals("") || AsalSekolah.getText().toString().equals("") || Alamat.getText().toString().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    void simpanData() {
        String isiFile = Username.getText().toString() + ";" + Password.getText().toString() + ";" + Email.getText().toString() + ";" + NamaLengkap.getText().toString() + ";" + AsalSekolah.getText().toString() + ";" + Alamat.getText().toString();
        File file = new File(getFilesDir(), Username.getText().toString());
        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }
    void tampilkanKonfirmasiRegister() {
        new AlertDialog.Builder(this).setTitle("Registrasi")
                .setMessage("Apakah Anda yakin Data telah sesuai?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        simpanData();

                    }
                }).setNegativeButton(android.R.string.no, null).show();
    }
    @Override
    public void onBackPressed() {
       // tampilkanKonfirmasiRegister();
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {

            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}