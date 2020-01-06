package es.ulpgc.miguel.masterdetailrealm.Detail;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.miguel.masterdetailrealm.R;

public class DetailActivity
    extends AppCompatActivity implements DetailContract.View {

  public static String TAG = DetailActivity.class.getSimpleName();

  private DetailContract.Presenter presenter;

  // buttons
  private Button cancelButton, updateButton, deleteButton;

  // text views
  private TextView nameText, surnameText, ageText, dniText, jobText, descriptionText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    // initializing buttons and edit texts
    cancelButton = findViewById(R.id.cancelButton);
    updateButton = findViewById(R.id.updateButton);
    deleteButton = findViewById(R.id.deleteButton);

    nameText = findViewById(R.id.nameText);
    surnameText = findViewById(R.id.surnameText);
    ageText = findViewById(R.id.ageText);
    dniText = findViewById(R.id.dniText);
    jobText = findViewById(R.id.jobText);
    descriptionText = findViewById(R.id.descriptionText);

    // listeners
    cancelButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.startMasterScreen();
      }
    });

    updateButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String name = nameText.getText().toString();
        String surname = surnameText.getText().toString();
        String age = ageText.getText().toString();
        String dni = dniText.getText().toString();
        String job = jobText.getText().toString();
        String description = descriptionText.getText().toString();
        if (
            !name.equals("") &&
                !surname.equals("") &&
                !age.equals("") &&
                !dni.equals("") &&
                !job.equals("") &&
                !description.equals("")
        ) {
          presenter.updatePerson(name, surname, age, dni, job, description);
          presenter.startMasterScreen();
        } else {
          Toast.makeText(DetailActivity.this, "There are some empty fields", Toast.LENGTH_SHORT).show();
        }
      }
    });

    deleteButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.deleteUser();
        presenter.startMasterScreen();
      }
    });

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
    ((EditText) findViewById(R.id.descriptionText)).setText(viewModel.person.getDescription());
  }
}
