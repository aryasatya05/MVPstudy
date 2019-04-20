package co.id.arya.mvpstudy.get;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import co.id.arya.mvpstudy.adapter.AdapterSiswa;
import co.id.arya.mvpstudy.GlobalClass;
import co.id.arya.mvpstudy.model.DataItem;
import co.id.arya.mvpstudy.model.ResponseData;

public class GetSiswaPresenter implements GetSiswaContract.Presenter {


    private GetSiswaContract.View view;

    public GetSiswaPresenter(GetSiswaContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataSiswa() {
        AndroidNetworking.get(GlobalClass.BASE_URL + "getAllSiswa")
                //ketika applikasi itu mendapat request berbarengan jadi yang di prioritaskan yang high dulu
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(ResponseData.class, new ParsedRequestListener<ResponseData>() {

                    @Override
                    //response kodenya 20, yang awalnya 200
                    public void onResponse(ResponseData response) {
                        view.showSucceed(response.toString());
                        view.ShowBiodata(response.getData());
                    }

                    @Override
                    //selain 200.
                    public void onError(ANError anError) {
                        Log.d("ada ngak?", anError.toString());
                        view.showError(anError.toString());

                    }
                });
    }

    @Override
    public void deleteBiodata(String id) {
        AndroidNetworking.post(GlobalClass.BASE_URL + "deleteDataSiswa")
                .setPriority(Priority.HIGH)
                .addUrlEncodeFormBodyParameter("id", id)
                .build()
                //banyak kelasnya jika munggunkana getA
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        getDataSiswa();
                        try {
                            if (response.getBoolean("status")){
                                view.showDeleteSuccess(response.toString());

                                //ADA kemungkinana json ini bukan json object

                            }
                        } catch (JSONException e) {
                            view.showDeleteFailder(e.getMessage());
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        view.showDeleteFailder(anError.toString());
                    }
                });

    }

    @Override
    public void goToEditBiodata(DataItem dataItem) {
        view.goToEditBiodata(dataItem);
    }

    @Override
    public void confirmDeletion(String id) {
        view.showDeletetion(id);
    }
}
