package com.pritikjain.glideexample.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pritikjain.glideexample.R;
import com.pritikjain.glideexample.User;

import java.util.Collections;
import java.util.List;

/**
 * Created by pritijain on 08/01/2017.
 */

public class UserRecyclerviewAdapter extends RecyclerView.Adapter<UserRecyclerviewAdapter.UserViewHolder> {


    List<User> users = Collections.emptyList();
    LayoutInflater layoutInflater;
    Context context;

    public UserRecyclerviewAdapter(Context context , List<User> users)
    {
        this.context = context;
        this.users = users;
        layoutInflater = layoutInflater.from(context);

    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View row = layoutInflater.inflate(R.layout.single_user_row,parent,false);
        return new UserViewHolder(row);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position)
    {
        User thisUser = users.get(position);

        holder.userName.setText(thisUser.getName());

        // Parse the URL
        final Uri uri = Uri.parse(thisUser.getImage());

        //Glide part
        Glide.with(context)
                .load(uri)
                .centerCrop()
                .placeholder(R.drawable.image_placeholder)
                .crossFade()
                .into(holder.userImage);
    }



    @Override
    public int getItemCount()
    {
        return users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private TextView userName;
        private ImageView userImage;

        public UserViewHolder(View itemView)
        {
            super(itemView);

            userName = (TextView)itemView.findViewById(R.id.user_name);
            userImage = (ImageView)itemView.findViewById(R.id.user_image);        }
    }


}
