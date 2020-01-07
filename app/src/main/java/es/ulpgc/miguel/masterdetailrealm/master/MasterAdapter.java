package es.ulpgc.miguel.masterdetailrealm.master;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

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
    // Setting a tag and a listener in order to know who was clicked
    holder.itemView.setTag(personList.get(position));
    holder.itemView.setOnClickListener(listener);

    // Each item of the list or cell, has these attributes
    holder.personFullnameView.setText(personList.get(position).getSurname() + ", " +personList.get(position).getName());
    holder.personAgeView.setText(String.valueOf(personList.get(position).getAge()));
    String stars = "";
    int nStars = personList.get(position).getRating();
    for(int i = 0; i < nStars; i++) {
      stars += "*";
    }
    holder.personDNIView.setText(stars); // TODO: CAMBIO A RATING

    // Each item has a default image that is downloaded from the internet by url
    loadImageFromURL(holder.imageView, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJcKgk5kFmglQsOLKNrkp1oEC0e33KjNSaG_njjfk1NvhpyG0r&s"); // TODO: poner el de cada uno
  }

  @Override
  public int getItemCount() {
    return personList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    final TextView personFullnameView, personAgeView, personDNIView;
    final ImageView imageView;

    public ViewHolder(View view) {
      super(view);
      personFullnameView = view.findViewById(R.id.fullName);
      personAgeView = view.findViewById(R.id.age);
      personDNIView = view.findViewById(R.id.dni);
      imageView = view.findViewById(R.id.image);
    }
  }

  /**
   * Load an image from an URL
   *
   * @param imageView image where it is saved
   * @param imageUrl  image's URL
   */
  private void loadImageFromURL(ImageView imageView, String imageUrl) {
    RequestManager reqManager = Glide.with(imageView.getContext());
    RequestBuilder reqBuilder = reqManager.load(imageUrl);
    RequestOptions reqOptions = new RequestOptions();
    reqBuilder.into(imageView);
  }
}
