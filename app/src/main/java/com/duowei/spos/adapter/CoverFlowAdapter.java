package com.duowei.spos.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duowei.spos.R;
import com.duowei.spos.bean.YHJBQK;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.LinkedList;

/**
 * Created by yichao on 16/2/25.
 */
public class CoverFlowAdapter extends RecyclerView.Adapter<CoverFlowAdapter.ViewHolder> {

    private int total = 0;
    private int factor = 100;

    private LinkedList<YHJBQK> cardModels;
    private int border_position = 0;

    private ImageLoader loader;
    private DisplayImageOptions displayImageOptions;

    private int[]imgs={R.mipmap.ic_user_1,
            R.mipmap.ic_user_2,
            R.mipmap.ic_user_3,
            R.mipmap.ic_user_4,
            R.mipmap.ic_user_5,
            };

    public CoverFlowAdapter(LinkedList<YHJBQK> cardModels, Context context){
        this.cardModels = cardModels;
        this.total = cardModels.size() * factor;
        loader = ImageLoader.getInstance();
        loader.init(ImageLoaderConfiguration.createDefault(context));
        displayImageOptions = new DisplayImageOptions.Builder()
                .displayer(new RoundedBitmapDisplayer(1000))
                .build();
    }

    @Override
    public CoverFlowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.card_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        position = position % cardModels.size();
        holder.card_layout.setVisibility(View.VISIBLE);
        if(position<=imgs.length-1){
            showPic(holder.card_image, "drawable://" + imgs[position]);
        }else{
            showPic(holder.card_image, "drawable://" + imgs[position%imgs.length%imgs.length]);
        }
        if (!cardModels.get(position).isBorder()){
            holder.card_title.setText(cardModels.get(position).getYHMC());
        }
        if (position < border_position || position > getItemCount() - border_position - 1){
            holder.card_layout.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return total;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout card_layout;
        public ImageView card_image;
        public TextView card_title;

        public ViewHolder(View v) {
            super(v);
            card_layout = (LinearLayout) v.findViewById(R.id.card_layout);
            card_image = (ImageView) v.findViewById(R.id.card_img);
            card_title = (TextView) v.findViewById(R.id.card_title);
        }
    }

    public void setBorder_position(int border_position) {
        this.border_position = border_position;
        for (int i  = 0; i < border_position; i++){
            cardModels.addFirst(new YHJBQK(true));
            cardModels.addLast(new YHJBQK(true));
            total = total + 2;
        }
        notifyDataSetChanged();
    }

    private void showPic(ImageView imgView, String url) {
        if (url == null) {
            imgView.setVisibility(View.GONE);
        } else {
            if (imgView != null && !url.equals("drawable://0")){
                loader.displayImage(url, imgView, displayImageOptions);
            }
        }
    }

    public void setFactor(int factor) {
        this.factor = factor;
        this.total = cardModels.size() * factor;
    }

    public int getOriginDataSize() {
        if (cardModels == null) {
            return 0;
        }
        return cardModels.size();
    }
}
