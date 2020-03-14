package com.example.firebaseauthentication26112019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText edtTk, edtMk, edtNhapphonexacthuc, edtMaxacthucdienthoai;
    Button btnDangnhap, btnDangky, btnThongtin, btnCapnhatthongtin, btnCapnhatmatkhau, btnXacthucEmail, btnXacthucphone, btnDangnhapqaxacthuc;
    private FirebaseAuth mAuth;

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

        mAuth = FirebaseAuth.getInstance();

        btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtTk.getText().toString();
                String password = edtMk.getText().toString();

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(MainActivity.this, "Dang ky thanh cong", Toast.LENGTH_SHORT).show();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtTk.getText().toString();
                String password = edtMk.getText().toString();
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(MainActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(MainActivity.this, "Danh nhap that bai", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Toast.makeText(this, currentUser.getEmail(), Toast.LENGTH_SHORT).show();
    }
}
