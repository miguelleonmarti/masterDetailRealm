package es.ulpgc.miguel.masterdetailrealm.master;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.miguel.masterdetailrealm.app.AppMediator;

public class MasterRouter implements MasterContract.Router {

  public static String TAG = MasterRouter.class.getSimpleName();

  private AppMediator mediator;

  public MasterRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MasterActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(MasterState state) {
    mediator.setMasterState(state);
  }

  @Override
  public MasterState getDataFromPreviousScreen() {
    MasterState state = mediator.getMasterState();
    return state;
  }
}
