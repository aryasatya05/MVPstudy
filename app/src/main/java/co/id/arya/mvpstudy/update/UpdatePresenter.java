package co.id.arya.mvpstudy.update;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import co.id.arya.mvpstudy.GlobalClass;

public class UpdatePresenter implements UpdateConstract.Presenter{
    UpdateConstract.View view;

    public UpdatePresenter(UpdateConstract.View view) {
        this.view = view;
    }

    @Override
    public void updateBiodata(String id, String nama, String kelas, String email) {
        if (nama.length()>0 && kelas.length()>0 && email.length()>0){
            AndroidNetworking.post(GlobalClass.BASE_URL+"UpdateDataSiswa")
                    .setPriority(Priority.HIGH)
                    .addBodyParameter("nama", nama)
                    .addBodyParameter("id", id)
                    .addBodyParameter("kelas", kelas)
                    .addBodyParameter("email", email)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                if (response.getBoolean("status")){
                                    view.updateSuccses();
                                }else {
                                    view.updateFailed();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onError(ANError anError) { view.updateFailed();}
                    });

        }else{
            view.updateFailed();
        }


    }
}
