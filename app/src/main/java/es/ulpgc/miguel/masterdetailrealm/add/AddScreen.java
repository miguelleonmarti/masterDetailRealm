package es.ulpgc.miguel.masterdetailrealm.add;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;
import es.ulpgc.miguel.masterdetailrealm.app.AppMediator;

public class AddScreen {

  public static void configure(AddContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AddState state = mediator.getAddState();

    AddContract.Router router = new AddRouter(mediator);
    AddContract.Presenter presenter = new AddPresenter(state);
    AddContract.Model model = new AddModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
