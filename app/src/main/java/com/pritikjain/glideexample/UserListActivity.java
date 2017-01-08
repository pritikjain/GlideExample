package com.pritikjain.glideexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pritikjain.glideexample.adapter.UserRecyclerviewAdapter;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        //Make an Object from the RecyclerView
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.user_recycler_view);

        //Attach a layout manager to the recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Instantiate the adapter with the data -list of users- from getData method
        UserRecyclerviewAdapter recyclerviewAdapter = new UserRecyclerviewAdapter(this, getData());

        //Attch the recyclerView with the adapter
        recyclerView.setAdapter(recyclerviewAdapter);


    }

    public List<User> getData()
    {
        List<User> users = new ArrayList<>();

        // Add % normal users with working URL
        for (int i = 0; i < 5; i++) {
            users.add(new User("Normal User", "http://androidgifts.com/wp-content/uploads/2016/04/target_image.png"));
        }

        // Add 2 users with wrong URLs
        users.add(new User("Not Found User", "http://androidgifts.com/wrong_image.png"));
        users.add(new User("Not Found User", "http://androidgifts.com/wrong_image.png"));

        // Add more users with working URL
        for (int i = 0; i < 8; i++) {
            users.add(new User("Normal User", "http://androidgifts.com/wp-content/uploads/2016/04/target_image.png"));
        }

        return users;
    }
}
