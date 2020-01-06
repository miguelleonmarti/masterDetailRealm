package es.ulpgc.miguel.masterdetailrealm.add;

import java.lang.ref.WeakReference;

public class AddPresenter implements AddContract.Presenter {

  public static String TAG = AddPresenter.class.getSimpleName();

  private WeakReference<AddContract.View> view;
  private AddViewModel viewModel;
  private AddContract.Model model;
  private AddContract.Router router;

  public AddPresenter(AddState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<AddContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AddContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AddContract.Router router) {
    this.router = router;
  }

  @Override
  public void startMasterScreen() {
    router.navigateToMasterScreen();
  }

  @Override
  public void addPerson(String name, String surname, String age, String dni, String job, String description) {
    model.addPerson(name, surname, age, dni, job, description);
  }

}
