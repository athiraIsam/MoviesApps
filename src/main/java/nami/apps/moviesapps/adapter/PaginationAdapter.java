package nami.apps.moviesapps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nami.apps.moviesapps.R;

public class PaginationAdapter extends RecyclerView.Adapter<PaginationAdapter.PageViewHolder> {


    private LayoutInflater mInflater;
    private Context mContext;
    private List<String> listPageNumber ;
    PageinationOnListerner onItemClickListener;

    public PaginationAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        this.listPageNumber = new ArrayList<>();
    }

    @NonNull
    @Override
    public PageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.column_pagination, parent, false);
        PageViewHolder viewHolder = new PageViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PageViewHolder holder, final int position) {
            holder.pageNumbering.setText(this.listPageNumber.get(position));
            holder.pageNumbering.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   onItemClickListener.onClick(position);
                }
            });
    }

    @Override
    public int getItemCount() {
        return this.listPageNumber == null? 0 : this.listPageNumber.size();
    }


    public class PageViewHolder extends RecyclerView.ViewHolder {
        public Button pageNumbering;


        public PageViewHolder(@NonNull View itemView) {
            super(itemView);
            pageNumbering = itemView.findViewById(R.id.pageNumber);
        }

    }

    public void setListPageNumber(List<String> listPageNumber) {
        this.listPageNumber.clear();
        this.listPageNumber.addAll(listPageNumber);
        notifyDataSetChanged();
    }
    public void setOnPaginationListener( PaginationAdapter.PageinationOnListerner onListerner) {
        this.onItemClickListener = onListerner;
    }
   public interface PageinationOnListerner
    {
        void onClick(int position);
    }
}
