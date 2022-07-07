package com.example.calculator07062022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvKetQua;
    EditText edtSoThu1, edtSoThu2;
    Button btnCong, btnTru, btnNhan, btnChia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ
        tvKetQua = findViewById(R.id.text_view_ket_qua);
        edtSoThu1 = findViewById(R.id.edit_text_so_thu_1);
        edtSoThu2 = findViewById(R.id.edit_text_so_thu_2);
        btnCong = findViewById(R.id.button_cong);
        btnTru = findViewById(R.id.button_tru);
        btnNhan = findViewById(R.id.button_nhan);
        btnChia = findViewById(R.id.button_chia);

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textSoThu1 = edtSoThu1.getText().toString();
                String textSoThu2 = edtSoThu2.getText().toString();

                if (textSoThu1.isEmpty() || textSoThu2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bạn chưa truyền đủ thông tin", Toast.LENGTH_LONG).show();
                    return;
                }

                float numberSoThu1 = Float.parseFloat(textSoThu1);
                float numberSoThu2 = Float.parseFloat(textSoThu2);

                float ketQua = numberSoThu1 + numberSoThu2;

                // Nếu chia hết cho 1 sẽ là kiểu int và ngược lại
                boolean isInteger = ketQua % 1 == 0;

                if (isInteger) {
                    tvKetQua.setText(String.valueOf((int) ketQua));
                } else {
                    tvKetQua.setText(String.valueOf(ketQua));
                }
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textSoThu1 = edtSoThu1.getText().toString();
                String textSoThu2 = edtSoThu2.getText().toString();

                if (textSoThu1.isEmpty() || textSoThu2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bạn chưa truyền đủ thông tin", Toast.LENGTH_LONG).show();
                    return;
                }

                float numberSoThu1 = Float.parseFloat(textSoThu1);
                float numberSoThu2 = Float.parseFloat(textSoThu2);

                if (numberSoThu2 == 0) {
                    Toast.makeText(MainActivity.this, "Không thực phép chia cho số 0", Toast.LENGTH_LONG).show();
                    return;
                }

                float ketQua = numberSoThu1 / numberSoThu2;

                // Nếu chia hết cho 1 sẽ là kiểu int và ngược lại
                boolean isInteger = ketQua % 1 == 0;

                if (isInteger) {
                    tvKetQua.setText(String.valueOf((int) ketQua));
                } else {
                    tvKetQua.setText(String.format("%.2f", ketQua));
                }
            }
        });
    }
}
