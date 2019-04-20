package co.id.arya.mvpstudy.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import co.id.arya.mvpstudy.R;
import co.id.arya.mvpstudy.get.GetSiswaPresenter;
import co.id.arya.mvpstudy.model.DataItem;

public class AdapterSiswa extends RecyclerView.Adapter<AdapterSiswa.MyViewHolder> {

    private GetSiswaPresenter getSiswaPresenter;

    private List<DataItem> dataItemList;

    public AdapterSiswa(List<DataItem> dataItemList, GetSiswaPresenter getSiswaPresenter) {
        this.dataItemList = dataItemList;
        this.getSiswaPresenter =  getSiswaPresenter;

    }

    @NonNull
    @Override
    public AdapterSiswa.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_siswa, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSiswa.MyViewHolder myViewHolder, final int i) {
        myViewHolder.nama.setText(dataItemList.get(i).getNamaSiswa());
        myViewHolder.kelas.setText(dataItemList.get(i).getKelasSiswa());
        myViewHolder.email.setText(dataItemList.get(i).getEmailSiswa());

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSiswaPresenter.goToEditBiodata(dataItemList.get(i));
            }
        });

        myViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSiswaPresenter.confirmDeletion(dataItemList.get(i).getIdSiswa());
            }
        });

    }



    @Override
    public int getItemCount() {
        return dataItemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nama, kelas, email;

        ImageButton delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.itm_nama_siswa);
            kelas = itemView.findViewById(R.id.itm_kelas_siswa);
            email = itemView.findViewById(R.id.itm_email_siswa);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
