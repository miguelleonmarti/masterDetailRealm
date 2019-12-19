package es.ulpgc.miguel.masterdetailrealm.app;

import android.app.Application;

import es.ulpgc.miguel.masterdetailrealm.master.MasterState;
import io.realm.Realm;

public class AppMediator extends Application {

  private MasterState masterState;

  @Override
  public void onCreate() {
    super.onCreate();

    // initializing Realm Database
    Realm.init(this);

    // initializing states
    masterState = new MasterState();
  }

  // getters and setters


  public MasterState getMasterState() {
    return masterState;
  }

  public void setMasterState(MasterState masterState) {
    this.masterState = masterState;
  }
}
