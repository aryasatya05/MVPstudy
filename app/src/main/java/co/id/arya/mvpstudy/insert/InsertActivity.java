package co.id.arya.mvpstudy.insert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.id.arya.mvpstudy.R;

public class InsertActivity extends AppCompatActivity implements InsertSiswaContract.View{

    EditText nama, kelas, email;
    Button simpan;

    private InsertSiswaPresenter insertSiswaPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        nama = findViewById(R.id.edt_nama);
        kelas = findViewById(R.id.edt_kelas);
        email = findViewById(R.id.edt_email);
        simpan = findViewById(R.id.btn_tambah);

        insertSiswaPresenter = new InsertSiswaPresenter(this);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSiswaPresenter.addBiodata(nama.getText().toString(),kelas.getText().toString(),email.getText().toString());
            }
        });
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void addSucsess(String message) {
        Toast.makeText(this, "Insert Sucsess", Toast.LENGTH_LONG).show();

    }

    @Override
    public void addFailed(String message) {
        Toast.makeText(this, "insert failed", Toast.LENGTH_LONG).show();

    }
}
