package es.ulpgc.miguel.masterdetailrealm.master;

import es.ulpgc.miguel.masterdetailrealm.model.Person;
import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.Realm;
import io.realm.RealmResults;

public class MasterModel implements MasterContract.Model {

  public static String TAG = MasterModel.class.getSimpleName();

  private Realm realm;

  public MasterModel() {
    // Get a Realm instance for this thread
    this.realm = Realm.getDefaultInstance();
  }

  @Override
  public void loadMasterItemList(final OnMasterItemListFetchedCallback callback) {
    final RealmResults<Person> people = realm.where(Person.class).findAllAsync();
    people.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<Person>>() {
      @Override
      public void onChange(RealmResults<Person> people, OrderedCollectionChangeSet changeSet) {
        changeSet.getInsertions();
        // Once we get the list, it is passed to presenter
        callback.setMasterItemList(people);
      }
    });
  }
}
