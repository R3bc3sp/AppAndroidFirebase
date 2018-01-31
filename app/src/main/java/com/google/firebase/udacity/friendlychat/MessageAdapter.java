package com.google.firebase.udacity.friendlychat;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<FriendlyMessage> {
    public MessageAdapter(Context context, int resource, List<FriendlyMessage> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_message, parent, false);
        }

        TextView messageTextView = (TextView) convertView.findViewById(R.id.messageTextView);
        TextView authorTextView = (TextView) convertView.findViewById(R.id.nameTextView);
        ImageView ivFoto = (ImageView) convertView.findViewById(R.id.ivFoto);


        FriendlyMessage message = getItem(position);


        if (message.getFotoUrl() != null) {
            messageTextView.setVisibility(View.GONE);
        ivFoto.setVisibility(View.VISIBLE);
        Glide.with(ivFoto.getContext())
                .load(message.getFotoUrl())
                .into(ivFoto);
        } else {
            messageTextView.setVisibility(View.VISIBLE);
            ivFoto.setVisibility(View.GONE);
            messageTextView.setText(message.getText());
        }



        messageTextView.setText(message.getText());
        authorTextView.setText(message.getName());

        return convertView;
    }
}
