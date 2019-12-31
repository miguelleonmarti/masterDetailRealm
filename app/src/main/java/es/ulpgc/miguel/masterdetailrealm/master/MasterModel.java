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
    final RealmResults<Person> people = realm.where(Person.class).findAllAsync();
    people.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<Person>>() {
      @Override
      public void onChange(RealmResults<Person> people, OrderedCollectionChangeSet changeSet) {
        if (people.isEmpty()){
          initPeople();
        }
      }
    });
  }

  @Override
  public void loadMasterItemList(final OnMasterItemListFetchedCallback callback) {
    final RealmResults<Person> people = realm.where(Person.class).findAllAsync();
    people.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<Person>>() {
      @Override
      public void onChange(RealmResults<Person> people, OrderedCollectionChangeSet changeSet) {
        changeSet.getInsertions();
        callback.setMasterItemList(people);
      }
    });
  }

  private void initPeople() {
    realm.beginTransaction();
    Person person1 = realm.createObject(Person.class);
    person1.setId(0);
    person1.setName("Miguel Ángel");
    person1.setSurname("León Martí");
    person1.setAge(21);
    person1.setDni("43657386W");
    person1.setJob("Student");
    person1.setTitle("Soy yo");
    person1.setDescription("Este es mi curriculum");
    Person person2 = realm.createObject(Person.class);
    person2.setId(1);
    person2.setName("Antonio David");
    person2.setSurname("Galván Hernández");
    person2.setAge(21);
    person2.setDni("43645786S");
    person2.setJob("Antenna installer");
    person2.setTitle("Soy El Anto");
    person2.setDescription("No tengo dignidad");
    realm.commitTransaction();
  }


}
