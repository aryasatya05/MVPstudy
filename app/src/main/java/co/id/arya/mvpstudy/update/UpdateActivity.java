package co.id.arya.mvpstudy.update;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.id.arya.mvpstudy.R;
import co.id.arya.mvpstudy.model.DataItem;

public class UpdateActivity extends AppCompatActivity implements UpdateConstract.View{
    private UpdatePresenter presenter;
    EditText updt_nama, updt_kelas, updt_email;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        final DataItem dataItem = (DataItem) getIntent().getSerializableExtra("data");
        presenter = new UpdatePresenter(this);

        updt_nama = findViewById(R.id.updt_nama);
        updt_kelas = findViewById(R.id.updt_kelas);
        updt_email = findViewById(R.id.updt_email);

        btnUpdate = findViewById(R.id.btn_update);

        updt_nama.setText(dataItem.getNamaSiswa());
        updt_kelas.setText(dataItem.getKelasSiswa());
        updt_email.setText(dataItem.getEmailSiswa());


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateBiodata(dataItem.getIdSiswa(), updt_nama.getText().toString(), updt_kelas.getText().toString(), updt_email.getText().toString());
            }
        });
    }

    @Override
    public void showProgressDialog() {


    }

    @Override
    public void updateSuccses() {
        Toast.makeText(this,"Berhasil di update boss",Toast.LENGTH_LONG).show();
        finish();

    }

    @Override
    public void updateFailed() {
        Toast.makeText(this, "Ini Succses panjul", Toast.LENGTH_SHORT).show();

    }
}
