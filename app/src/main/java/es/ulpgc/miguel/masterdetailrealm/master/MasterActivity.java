package es.ulpgc.miguel.masterdetailrealm.master;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.ulpgc.miguel.masterdetailrealm.R;

public class MasterActivity
    extends AppCompatActivity implements MasterContract.View {

  public static String TAG = MasterActivity.class.getSimpleName();

  private MasterContract.Presenter presenter;

  // adapter
  MasterAdapter masterAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_master);

    // adapter
    masterAdapter = new MasterAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Log.d("Click on person", "");
      }
    });

    // declaring the recyclerView, finding its id and changing its adapter
    RecyclerView recyclerView = findViewById(R.id.doorList);
    recyclerView.setAdapter(masterAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

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
  public void displayData(final MasterViewModel viewModel) {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
      /*  // toast with logout message
        if (!viewModel.getMessage().equals("")) {
          Toast.makeText(getApplicationContext(), viewModel.getMessage(), Toast.LENGTH_LONG).show();
        }
      */ // adapter sets the list items
        masterAdapter.setItems(viewModel.data);
      }
    });
  }
}
