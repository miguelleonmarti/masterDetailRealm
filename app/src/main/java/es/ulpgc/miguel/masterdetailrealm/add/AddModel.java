package es.ulpgc.miguel.masterdetailrealm.add;

import es.ulpgc.miguel.masterdetailrealm.model.Person;
import io.realm.Realm;

public class AddModel implements AddContract.Model {

  public static String TAG = AddModel.class.getSimpleName();

  private Realm realm;

  public AddModel() {
    // Get a Realm instance for this thread
    this.realm = Realm.getDefaultInstance();
  }

  @Override
  public void addPerson(String name, String surname, String age, String dni, String job, String title, String description) {
    realm.beginTransaction();
    Person person = realm.createObject(Person.class);
    Number number = realm.where(Person.class).max("id");
    person.setId(number.intValue() + 1);
    person.setName(name);
    person.setSurname(surname);
    person.setAge(Integer.parseInt(age));
    person.setDni(dni);
    person.setJob(job);
    person.setTitle(title);
    person.setDescription(description);
    realm.commitTransaction();
  }
}
