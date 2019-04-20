package co.id.arya.mvpstudy.get;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import co.id.arya.mvpstudy.adapter.AdapterSiswa;
import co.id.arya.mvpstudy.R;
import co.id.arya.mvpstudy.adapter.AdapterSiswa;
import co.id.arya.mvpstudy.model.DataItem;
import co.id.arya.mvpstudy.update.UpdateActivity;

public class GetActivity extends AppCompatActivity implements GetSiswaContract.View {

    private GetSiswaPresenter getSiswaPresenter;
    private RecyclerView recyclerView;
    private AdapterSiswa adapterSiswa;

//    ImageButton btnhapus;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
//        final DataItem dataItem = (DataItem) getIntent().getSerializableExtra("data");
//        btnhapus = findViewById(R.id.delete);



        recyclerView = findViewById(R.id.rvBiodata);
        getSiswaPresenter = new GetSiswaPresenter(this);

        getSiswaPresenter.getDataSiswa();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));




    }

//

    @Override
    public void ShowBiodata(List dataSiswa) {
        adapterSiswa = new AdapterSiswa(dataSiswa, getSiswaPresenter);
        recyclerView.setAdapter(adapterSiswa);

        if (dataSiswa.size() > 1){
            Toast.makeText(this, "data sudah ada!", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, "data kosong!", Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    public void goToEditBiodata(DataItem  dataItem) {
        Intent intent = new Intent(GetActivity.this, UpdateActivity.class);
        intent.putExtra("data", dataItem);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        getSiswaPresenter.getDataSiswa();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, "tidak ada data", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSucceed(String message) {
        Toast.makeText(this, "Data Success", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showDeleteSuccess(String message) {
        Toast.makeText(this, "Delete Success!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showDeleteFailder(String message) {
        Toast.makeText(this, "Delete Failed!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showDeletetion(final String id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(GetActivity.this)
                .setMessage("Hapus Biodata Ini?")
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        getSiswaPresenter.deleteBiodata(id);

                    }
                });
        AlertDialog build = builder.create();
        build.show();

    }


}
