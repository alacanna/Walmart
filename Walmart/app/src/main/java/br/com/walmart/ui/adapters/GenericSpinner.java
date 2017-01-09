package br.com.walmart.ui.adapters;

/**
 * Created by amandalacanna on 1/8/17.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.walmart.R;
import butterknife.BindView;
import butterknife.ButterKnife;


public class GenericSpinner<T> extends ArrayAdapter<T> {
    public GenericSpinner(Context context, int resource) {
        super(context, resource);
    }

    private List<T> objList;

    public GenericSpinner(Context context, List<T> objList) {
        super(context, R.layout.item_spinner, R.id.name, objList);
        this.objList = objList;
    }

    static class ViewHolder {
        @BindView(R.id.name) TextView txtName;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        return convertView(position, convertView, parent, false);
    }

    @Override public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return convertView(position, convertView, parent, true);
    }

    private View convertView(int position, View convertView, ViewGroup parent, boolean dropDown) {
        ViewHolder viewHolder; // view lookup cache stored in tag

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_spinner, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data into the template view using the data object
        viewHolder.txtName.setText(((ArrayList<String>)objList).get(position));

        // Return the completed view to render on screen
        return convertView;
    }
}

