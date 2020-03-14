package com.example.firebaseauthentication26112019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtTk,edtMk,edtNhapphonexacthuc,edtMaxacthucdienthoai;
    Button btnDangnhap,btnDangky,btnThongtin,btnCapnhatthongtin,btnCapnhatmatkhau,btnXacthucEmail,btnXacthucphone,btnDangnhapqaxacthuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTk = findViewById(R.id.edittextEmail);
        edtMk = findViewById(R.id.edittextPassword);
        edtNhapphonexacthuc = findViewById(R.id.edittextVerificationPhone);
        edtMaxacthucdienthoai = findViewById(R.id.edittextPhoneVerification);
        btnDangnhap = findViewById(R.id.buttonDangnhap);
        btnDangky = findViewById(R.id.buttonDangky);
        btnThongtin = findViewById(R.id.buttonThongtin);
        btnCapnhatthongtin = findViewById(R.id.buttonCapnhat);
        btnCapnhatmatkhau = findViewById(R.id.buttonResetpassword);
        btnXacthucEmail = findViewById(R.id.buttonVerification);
        btnXacthucphone = findViewById(R.id.buttonVerificationPhone);
        btnDangnhapqaxacthuc = findViewById(R.id.buttonLoginPhoneVerification);
    }
}
