package es.ulpgc.miguel.masterdetailrealm.Detail;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.masterdetailrealm.model.Person;

public class DetailPresenter implements DetailContract.Presenter {

  public static String TAG = DetailPresenter.class.getSimpleName();

  private WeakReference<DetailContract.View> view;
  private DetailViewModel viewModel;
  private DetailContract.Model model;
  private DetailContract.Router router;

  public DetailPresenter(DetailState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<DetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(DetailContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(DetailContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    /*DetailState state = router.getDataFromPreviousScreen();
    if (state != null) {
      viewModel.data = state.data;
    }

    if (viewModel.data == null) {
      // call the model
      String data = model.fetchData();

      // set initial state
      viewModel.data = data;
    }

    // update the view
    view.get().displayData(viewModel);*/

    Person person = router.getDataFromPreviousScreen();

    if (person != null) {
      viewModel.person = person;
    }

    view.get().displayData(viewModel);

  }

  @Override
  public void startMasterScreen() {
    router.navigateToMasterScreen();
  }

  @Override
  public void deleteUser() {
    model.deletePerson(viewModel.person.getId());
  }

  @Override
  public void updatePerson(String rating, String name, String surname, String age, String dni, String job, String description) {
    model.updatePerson(viewModel.person.getId(), rating, name, surname, age, dni, job, description);
  }
}
