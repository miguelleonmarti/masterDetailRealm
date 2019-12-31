package es.ulpgc.miguel.masterdetailrealm.app;

import android.app.Application;

import es.ulpgc.miguel.masterdetailrealm.Detail.DetailState;
import es.ulpgc.miguel.masterdetailrealm.add.AddState;
import es.ulpgc.miguel.masterdetailrealm.master.MasterState;
import es.ulpgc.miguel.masterdetailrealm.model.Person;
import io.realm.Realm;

public class AppMediator extends Application {

  private MasterState masterState;
  private AddState addState;
  private DetailState detailState;

  private Person person;

  @Override
  public void onCreate() {
    super.onCreate();

    // initializing Realm Database
    Realm.init(this);

    // TODO: FOR DELETING THE DATABASE
    /*Realm realm;
    try {
      realm = Realm.getDefaultInstance();
    } catch (Exception e) { // Get a Realm instance for this thread
      RealmConfiguration config = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
      realm = Realm.getInstance(config);
    }*/

    // initializing states
    masterState = new MasterState();
    addState = new AddState();
    detailState = new DetailState();

    // initializing objects
    person = new Person();
  }

  // getters and setters

  public MasterState getMasterState() {
    return masterState;
  }

  public void setMasterState(MasterState masterState) {
    this.masterState = masterState;
  }

  public AddState getAddState() {
    return addState;
  }

  public void setAddState(AddState addState) {
    this.addState = addState;
  }

  public DetailState getDetailState() {
    return detailState;
  }

  public void setDetailState(DetailState detailState) {
    this.detailState = detailState;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
}
