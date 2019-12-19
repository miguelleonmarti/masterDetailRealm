package es.ulpgc.miguel.masterdetailrealm.master;

import java.lang.ref.WeakReference;

interface MasterContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(MasterViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(MasterState state);

    MasterState getDataFromPreviousScreen();
  }
}
