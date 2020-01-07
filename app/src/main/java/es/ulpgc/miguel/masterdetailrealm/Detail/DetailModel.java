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
  public void deletePerson(int id) {
    realm.beginTransaction();
    realm.where(Person.class).equalTo("id", id).findAll().deleteAllFromRealm();
    realm.commitTransaction();
  }

  @Override
  public void updatePerson(int id, String rating, String name, String surname, String age, String dni, String job, String description) {
    realm.beginTransaction();
    Person person = realm.where(Person.class).equalTo("id", id).findFirst();
    person.setName(name);
    person.setSurname(surname);
    person.setAge(Integer.valueOf(age));
    person.setDni(dni);
    person.setJob(job);
    person.setDescription(description);
    person.setRating(Integer.valueOf(rating));
    realm.commitTransaction();
  }
}
