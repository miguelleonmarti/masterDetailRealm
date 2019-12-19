package es.ulpgc.miguel.masterdetailrealm.master;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.miguel.masterdetailrealm.R;

public class MasterActivity
    extends AppCompatActivity implements MasterContract.View {

  public static String TAG = MasterActivity.class.getSimpleName();

  private MasterContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_master);

    // do the setup
    MasterScreen.configure(this);

    // fetch list of people
    presenter.fetchData();
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(MasterContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(MasterViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.data)).setText(viewModel.data.get(0).getName());
  }
}
