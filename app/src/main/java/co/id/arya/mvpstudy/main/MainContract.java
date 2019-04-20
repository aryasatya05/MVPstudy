package co.id.arya.mvpstudy.main;

public interface MainContract {
    interface View{
        void goToListBiodata();
        void goToAddBiodata();

    }
    interface Presenter{
        void seeAllBiodata();
        void addBiodata();
    }
}
