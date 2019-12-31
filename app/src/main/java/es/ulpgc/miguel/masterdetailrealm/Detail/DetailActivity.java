package es.ulpgc.miguel.masterdetailrealm.Detail;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.miguel.masterdetailrealm.R;

public class DetailActivity
    extends AppCompatActivity implements DetailContract.View {

  public static String TAG = DetailActivity.class.getSimpleName();

  private DetailContract.Presenter presenter;

  // buttons
  private Button cancelButton, addButton;

  // text views
  private TextView nameText, surnameText, ageText, jobText, titleText, descriptionText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    //

    // do the setup
    DetailScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(DetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(DetailViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((EditText) findViewById(R.id.nameText)).setText(viewModel.person.getName());
    ((EditText) findViewById(R.id.surnameText)).setText(viewModel.person.getSurname());
    ((EditText) findViewById(R.id.ageText)).setText(String.valueOf(viewModel.person.getAge()));
    ((EditText) findViewById(R.id.dniText)).setText(viewModel.person.getDni());
    ((EditText) findViewById(R.id.jobText)).setText(viewModel.person.getJob());
    ((EditText) findViewById(R.id.titleText)).setText(viewModel.person.getTitle());
    ((EditText) findViewById(R.id.descriptionText)).setText(viewModel.person.getDescription());
  }
}
