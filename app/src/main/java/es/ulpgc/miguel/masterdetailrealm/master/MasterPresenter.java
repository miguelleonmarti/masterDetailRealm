package es.ulpgc.miguel.masterdetailrealm.master;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.miguel.masterdetailrealm.model.Person;

public class MasterPresenter implements MasterContract.Presenter {

  public static String TAG = MasterPresenter.class.getSimpleName();

  private WeakReference<MasterContract.View> view;
  private MasterViewModel viewModel;
  private MasterContract.Model model;
  private MasterContract.Router router;

  public MasterPresenter(MasterState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<MasterContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(MasterContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(MasterContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    model.loadMasterItemList(new MasterContract.Model.OnMasterItemListFetchedCallback() {
      @Override
      public void setMasterItemList(List<Person> itemList) {
        // update the view
        viewModel.data = itemList;
        view.get().displayData(viewModel);
      }
    });

  }


}
