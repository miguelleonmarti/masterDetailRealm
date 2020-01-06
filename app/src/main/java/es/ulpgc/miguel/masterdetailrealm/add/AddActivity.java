package es.ulpgc.miguel.masterdetailrealm.add;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.miguel.masterdetailrealm.R;

public class AddActivity
    extends AppCompatActivity implements AddContract.View {

  public static String TAG = AddActivity.class.getSimpleName();

  private AddContract.Presenter presenter;

  // buttons
  private Button cancelButton, addButton;

  // edit texts
  private EditText nameText, surnameText, ageText, dniText, jobText, titleText, descriptionText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add);

    // initializing buttons and text views
    cancelButton = findViewById(R.id.cancelButton);
    addButton = findViewById(R.id.updateButton);

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

    addButton.setOnClickListener(new View.OnClickListener() {
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
          presenter.addPerson(name, surname, age, dni, job, description);
          presenter.startMasterScreen();
        } else {
          Toast.makeText(AddActivity.this, "There are some empty fields", Toast.LENGTH_SHORT).show();
        }
      }
    });

    // do the setup
    AddScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

  }

  @Override
  public void injectPresenter(AddContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(AddViewModel viewModel) {
  }
}
