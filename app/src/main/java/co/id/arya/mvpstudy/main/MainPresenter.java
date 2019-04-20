package co.id.arya.mvpstudy.main;

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void seeAllBiodata() {
        view.goToListBiodata();
    }

    @Override
    public void addBiodata() {
        view.goToAddBiodata();

    }
}
