package br.com.walmart.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.walmart.R;
import br.com.walmart.model.Edge;
import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by amandalacanna on 1/8/17.
 */

public class RoutesAdapter extends RecyclerView.Adapter<RoutesAdapter.ViewHolder> {
    private List<Edge> map;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.txt_vertex_ori) TextView txtVertexOrigin;
        @Bind(R.id.txt_vertex_dest) TextView txtVertexDestination;
        @Bind(R.id.txt_distance) TextView txtDistance;


        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this,v);
        }
    }

    public RoutesAdapter(List<Edge> map) {
        this.map = map;
    }

    @Override
    public RoutesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_route, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtVertexDestination.setVisibility(View.GONE);
        holder.txtVertexOrigin.setText(map.get(position).getOriginPoint().toString());

        holder.txtDistance.setText(String.format("%s Km",map.get(position).getDistance()));

        if(position == map.size()-1) {
            holder.txtVertexDestination.setVisibility(View.VISIBLE);
            holder.txtVertexDestination.setText(map.get(position).getDestinationPoint().toString());
        }


    }

    @Override
    public int getItemCount() {
        return map.size();
    }
}

