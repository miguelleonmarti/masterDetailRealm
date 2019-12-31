package es.ulpgc.miguel.masterdetailrealm.master;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.miguel.masterdetailrealm.Detail.DetailActivity;
import es.ulpgc.miguel.masterdetailrealm.add.AddActivity;
import es.ulpgc.miguel.masterdetailrealm.app.AppMediator;
import es.ulpgc.miguel.masterdetailrealm.model.Person;

public class MasterRouter implements MasterContract.Router {

  public static String TAG = MasterRouter.class.getSimpleName();

  private AppMediator mediator;

  public MasterRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToDetailScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, DetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToDetailScreen(Person person) {
    mediator.setPerson(person);
  }

  @Override
  public MasterState getDataFromPreviousScreen() {
    MasterState state = mediator.getMasterState();
    return state;
  }

  @Override
  public void navigateToAddScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AddActivity.class);
    context.startActivity(intent);
  }
}
