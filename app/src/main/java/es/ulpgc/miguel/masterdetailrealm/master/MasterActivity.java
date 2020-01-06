package es.ulpgc.miguel.masterdetailrealm.master;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.ulpgc.miguel.masterdetailrealm.R;
import es.ulpgc.miguel.masterdetailrealm.model.Person;

public class MasterActivity
    extends AppCompatActivity implements MasterContract.View {

  public static String TAG = MasterActivity.class.getSimpleName();

  private MasterContract.Presenter presenter;
  private Button addButton;

  // adapter
  MasterAdapter masterAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_master);

    // adapter and button
    masterAdapter = new MasterAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Person person = (Person) view.getTag();
        presenter.startDetailScreen(person);
      }
    });
    addButton = findViewById(R.id.updateButton);

    // declaring the recyclerView, finding its id and changing its adapter
    RecyclerView recyclerView = findViewById(R.id.doorList);
    recyclerView.setAdapter(masterAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    // listener
    addButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.startAddScreen();
      }
    });

    // do the setup
    MasterScreen.configure(this);

    // fetch list of people
    presenter.fetchData();
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  public void injectPresenter(MasterContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(final MasterViewModel viewModel) {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
       // adapter sets the list items
        masterAdapter.setItems(viewModel.data);
      }
    });
  }
}
