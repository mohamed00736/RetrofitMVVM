package hacine.mohamed.abdelhakim.retrofitmvvm.UI.Main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import hacine.mohamed.abdelhakim.retrofitmvvm.data.PostClient;
import hacine.mohamed.abdelhakim.retrofitmvvm.pojo.PostModel;
import retrofit2.Call;
import retrofit2.*;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {

    MutableLiveData <List<PostModel>> postmutablelivadata = new MutableLiveData<>();


    public void getpostsfromapi(){

        PostClient.getINSTANCE().getPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postmutablelivadata.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

            }
        });
    }
}
