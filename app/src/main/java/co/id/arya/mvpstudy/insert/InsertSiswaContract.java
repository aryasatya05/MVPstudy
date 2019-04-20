package co.id.arya.mvpstudy.insert;

public interface InsertSiswaContract {
    interface View{
        void showProgressDialog();
        void addSucsess(String message);
        void addFailed(String message);
    }

    interface Presenter {
        void addBiodata(String nama, String kelas, String email);
    }
}
