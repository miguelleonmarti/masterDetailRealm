package es.ulpgc.miguel.masterdetailrealm.master;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.miguel.masterdetailrealm.model.Person;

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
    interface OnMasterItemListFetchedCallback {
      void setMasterItemList(List<Person> itemList);
    }

    void loadMasterItemList(OnMasterItemListFetchedCallback callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(MasterState state);

    MasterState getDataFromPreviousScreen();
  }
}
