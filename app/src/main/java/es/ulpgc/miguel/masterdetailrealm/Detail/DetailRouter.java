package es.ulpgc.miguel.masterdetailrealm.Detail;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.miguel.masterdetailrealm.app.AppMediator;
import es.ulpgc.miguel.masterdetailrealm.master.MasterActivity;
import es.ulpgc.miguel.masterdetailrealm.model.Person;

public class DetailRouter implements DetailContract.Router {

  public static String TAG = DetailRouter.class.getSimpleName();

  private AppMediator mediator;

  public DetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, DetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(DetailState state) {
    mediator.setDetailState(state);
  }

  @Override
  public Person getDataFromPreviousScreen() {
    return mediator.getPerson();
  }

  @Override
  public void navigateToMasterScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MasterActivity.class);
    context.startActivity(intent);
  }
}
