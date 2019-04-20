package co.id.arya.mvpstudy.insert;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONObject;

import co.id.arya.mvpstudy.GlobalClass;

public class InsertSiswaPresenter implements InsertSiswaContract.Presenter {

    private InsertSiswaContract.View view;

    public InsertSiswaPresenter(InsertSiswaContract.View view) {
        this.view = view;
    }

    @Override
    public void addBiodata(String nama, String kelas, String email) {

        AndroidNetworking.post(GlobalClass.BASE_URL + "insertDataSiswa")
                .setPriority(Priority.HIGH)
                .addBodyParameter("nama", nama)
                .addBodyParameter("kelas", kelas)
                .addBodyParameter("email", email)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        view.addSucsess(response.toString());
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("erronya", anError.toString());
                        view.addFailed(anError.toString());

                    }
                });

    }
}
