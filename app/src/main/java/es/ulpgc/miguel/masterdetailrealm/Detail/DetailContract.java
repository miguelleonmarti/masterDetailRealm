package es.ulpgc.miguel.masterdetailrealm.Detail;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.masterdetailrealm.model.Person;

interface DetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(DetailViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void startMasterScreen();

    void deleteUser();
  }

  interface Model {
    void deleteUser(int id);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(DetailState state);

    //DetailState getDataFromPreviousScreen();
    Person getDataFromPreviousScreen();

    void navigateToMasterScreen();
  }
}
