package es.ulpgc.miguel.masterdetailrealm.master;

public class MasterModel implements MasterContract.Model {

  public static String TAG = MasterModel.class.getSimpleName();

  public MasterModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}
