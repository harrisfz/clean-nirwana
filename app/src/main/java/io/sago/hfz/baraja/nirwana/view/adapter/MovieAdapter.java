package io.sago.hfz.baraja.nirwana.view.adapter;

import com.squareup.picasso.Picasso;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.sago.hfz.baraja.nirwana.R;
import io.sago.hfz.baraja.nirwana.model.Movie;
import io.sago.hfz.baraja.nirwana.view.activity.MainActivity;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version MovieAdapter, v 0.1 2019-07-14 22:41 by Harris Febryantony Z
 */

public class MovieAdapter extends ListAdapter<Movie, MovieAdapter.MovieViewHolder> {

    public static DiffUtil.ItemCallback<Movie> DIFF_CALLBACK = new DiffUtil.ItemCallback<Movie>() {
        @Override
        public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {

            return oldItem.equals(newItem);
        }
    };

    @Inject
    public MovieAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = getItem(position);

        holder.tvTitle.setText(String.format("%s", movie.getTitle()));
        holder.tvRating.setText(String.format("%s", movie.getVoteAverage()));

        Picasso.with(holder.ivPoster.getContext())
            .load(MainActivity.BASE_IMAGE_URL + movie.getPosterPath())
            .placeholder(R.drawable.img_poster)
            .into(holder.ivPoster);

        holder.itemView.setOnClickListener(view -> {
            if (onItemClickListener != null)
                onItemClickListener.onClickItem(movie);

        });
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(
        OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {

        void onClickItem(Movie position);
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view_title)
        TextView tvTitle;

        @BindView(R.id.text_view_rating)
        TextView tvRating;

        @BindView(R.id.image_view_poster)
        ImageView ivPoster;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
