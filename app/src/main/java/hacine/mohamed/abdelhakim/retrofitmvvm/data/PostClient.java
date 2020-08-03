package hacine.mohamed.abdelhakim.retrofitmvvm.data;

import java.util.List;

import hacine.mohamed.abdelhakim.retrofitmvvm.pojo.PostModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {

    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static PostClient INSTANCE;

    public PostClient( ) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }
    public static PostClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new PostClient();
        }
        return INSTANCE;
    }
    public Call<List<PostModel>>getPosts(){
        return postInterface.getPosts();
    }
}
