package co.id.arya.mvpstudy.get;

import java.util.List;

import co.id.arya.mvpstudy.model.DataItem;

public interface GetSiswaContract {
    interface View{
        void ShowBiodata(List dataSiswa);
        void goToEditBiodata(DataItem dataItem);
        void showError(String message);
        void showSucceed(String message);
        void showDeleteSuccess(String message);
        void showDeleteFailder(String message);
        void showDeletetion(String id);
//        void setClickOnDel();
    }
    interface Presenter{
        void getDataSiswa();
        void deleteBiodata(String id);
        void goToEditBiodata(DataItem dataItem);
        void confirmDeletion(String id);
    }
}
