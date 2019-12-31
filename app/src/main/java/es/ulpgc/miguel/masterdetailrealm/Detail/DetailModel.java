package es.ulpgc.miguel.masterdetailrealm.Detail;

import es.ulpgc.miguel.masterdetailrealm.model.Person;
import io.realm.Realm;

public class DetailModel implements DetailContract.Model {

  public static String TAG = DetailModel.class.getSimpleName();

  private Realm realm;

  public DetailModel() {
    // Get a Realm instance for this thread
    this.realm = Realm.getDefaultInstance();
  }

  @Override
  public void deleteUser(int id) {
    realm.beginTransaction();
    realm.where(Person.class).equalTo("id", id).findAll().deleteAllFromRealm();
    realm.commitTransaction();
  }
}
