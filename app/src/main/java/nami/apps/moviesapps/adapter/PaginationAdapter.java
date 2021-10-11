package nami.apps.moviesapps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import nami.apps.moviesapps.R;

public class PaginationAdapter extends RecyclerView.Adapter<PaginationAdapter.PageViewHolder> {


    private LayoutInflater mInflater;
    private Context mContext;

    public PaginationAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
    }

    @NonNull
    @Override
    public PageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.column_pagination, parent, false);
        PageViewHolder viewHolder = new PageViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PageViewHolder holder, int position) {
          //  holder.pageNumbering.setText("100");
    }

    @Override
    public int getItemCount() {
        return 5;
    }


    public class PageViewHolder extends RecyclerView.ViewHolder {
        public TextView pageNumbering;

        public PageViewHolder(@NonNull View itemView) {
            super(itemView);
            pageNumbering = itemView.findViewById(R.id.pageNumber);
        }
    }
}
