package es.ulpgc.miguel.masterdetailrealm.app;

import android.app.Application;

import es.ulpgc.miguel.masterdetailrealm.master.MasterState;

public class AppMediator extends Application {

  private MasterState masterState;

  @Override
  public void onCreate() {
    super.onCreate();

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
