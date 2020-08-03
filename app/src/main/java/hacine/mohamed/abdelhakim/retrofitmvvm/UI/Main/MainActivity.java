package hacine.mohamed.abdelhakim.retrofitmvvm.UI.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import java.util.List;

import hacine.mohamed.abdelhakim.retrofitmvvm.R;
import hacine.mohamed.abdelhakim.retrofitmvvm.pojo.PostModel;

public class MainActivity extends AppCompatActivity {
PostViewModel postViewModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);

        postViewModel.getpostsfromapi();
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final PostsAdapter adapter = new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        postViewModel.postmutablelivadata.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList(postModels);
            }
        });
    }
}