package co.id.arya.mvpstudy.update;

public interface UpdateConstract {
    interface View{
        void showProgressDialog();
        void updateSuccses();
        void updateFailed();
    }
    interface Presenter{
        void updateBiodata(String id, String nama,String kelas, String email);
    }
}
