package hacine.mohamed.abdelhakim.retrofitmvvm.data;


import java.util.List;

import hacine.mohamed.abdelhakim.retrofitmvvm.pojo.PostModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PostInterface {
    @GET("posts")
    public Call<List<PostModel>>   getPosts();
//
//    @POST("posts")
//    public Call <PostModel>   creatPosts(@Body Post post);
}
