package com.example.telemediktest.ui.main;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.telemediktest.R;
import com.example.telemediktest.model.User;
import com.example.telemediktest.ui.glide.GlideApp;
import com.example.telemediktest.ui.listeners.ItemClickListener;
import java.util.List;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<User> mUserList;
    private Context mContext;
    private ViewHolder mViewHolder;

    public MainAdapter(List<User> mUserList, Context mContext) {
        this.mUserList = mUserList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, parent, false);
        mViewHolder = new ViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final User user = mUserList.get(position);
        holder.mUserName.setText(user.getFirstName() + " " + user.getLastName());

        GlideApp
                .with(mContext)
                .load(user.getAvatar())
                .into(holder.mUserAvatar);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(mContext,user.getEmail(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mUserName;
        ImageView mUserAvatar;

        public ItemClickListener mItemClickListener;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mUserName = itemView.findViewById(R.id.tvUserNAme);
            mUserAvatar = itemView.findViewById(R.id.ivUserAvatar);

        }

        public void setItemClickListener(ItemClickListener itemClickListener){
            mItemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            mItemClickListener.onClick(view,getAdapterPosition());
        }
    }
}
