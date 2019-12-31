package es.ulpgc.miguel.masterdetailrealm.master;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import es.ulpgc.miguel.masterdetailrealm.R;
import es.ulpgc.miguel.masterdetailrealm.model.Person;

public class MasterAdapter extends RecyclerView.Adapter<MasterAdapter.ViewHolder> {

  private List<Person> personList;
  private final View.OnClickListener listener;

  public MasterAdapter(View.OnClickListener listener) {
    this.personList = new ArrayList<>();
    this.listener = listener;
  }

  public void addItem(Person person) {
    personList.add(person);
    notifyDataSetChanged();
  }

  public void addItems(List<Person> personList) {
    this.personList.addAll(personList);
    notifyDataSetChanged();
  }

  public void setItems(List<Person> personList) {
    this.personList = personList;
    notifyDataSetChanged();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
    View view = LayoutInflater.from(parent.getContext()).
        inflate(R.layout.person_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, final int position) {
    holder.itemView.setTag(personList.get(position));
    holder.itemView.setOnClickListener(listener);

    holder.personFullnameView.setText(personList.get(position).getSurname() + ", " +personList.get(position).getName());
    holder.personAgeView.setText(String.valueOf(personList.get(position).getAge()));
    holder.personDNIView.setText(String.valueOf(personList.get(position).getDni()));

  }

  @Override
  public int getItemCount() {
    return personList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    final TextView personFullnameView, personAgeView, personDNIView;

    public ViewHolder(View view) {
      super(view);
      personFullnameView = view.findViewById(R.id.fullName);
      personAgeView = view.findViewById(R.id.age);
      personDNIView = view.findViewById(R.id.dni);
    }
  }
}
