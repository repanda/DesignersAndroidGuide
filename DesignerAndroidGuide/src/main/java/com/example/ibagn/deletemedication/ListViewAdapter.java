package com.example.ibagn.deletemedication;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Widget> {

	Context context;
	LayoutInflater inflater;
	List<Widget> widgets_list;
	private SparseBooleanArray mSelectedItemsIds;

	public ListViewAdapter(Context context, int resourceId,
			List<Widget> widgets_list) {
		super(context, resourceId, widgets_list);
		mSelectedItemsIds = new SparseBooleanArray();
		this.context = context;
		this.widgets_list = widgets_list;
		inflater = LayoutInflater.from(context);
	}

	private class ViewHolder {

		TextView name;
		TextView position;
		TextView description;
		ImageView image;
	}

	public View getView(int position, View view, ViewGroup parent) {
		final ViewHolder holder;
		if (view == null) {
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.listview_item, null);
			// Locate the TextViews in listview_item.xml

			holder.name = (TextView) view.findViewById(R.id.name);
			holder.position = (TextView) view.findViewById(R.id.position);
			holder.description=(TextView) view.findViewById(R.id.description);
			// Locate the ImageView in listview_item.xml
			holder.image = (ImageView) view.findViewById(R.id.img);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		holder.position.setText("Position: " + widgets_list.get(position).getPosition());
		holder.name.setText(widgets_list.get(position).getName());
		holder.description.setText(widgets_list.get(position).getDescription());
		holder.image.setImageResource(widgets_list.get(position)
				.getImg());
		return view;
	}

	@Override
	public void remove(Widget object) {
		widgets_list.remove(object);
		notifyDataSetChanged();
	}

	public List<Widget> getWorldPopulation() {
		return widgets_list;
	}

	public void toggleSelection(int position) {
		selectView(position, !mSelectedItemsIds.get(position));
	}

	public void removeSelection() {
		mSelectedItemsIds = new SparseBooleanArray();
		notifyDataSetChanged();
	}

	public void selectView(int position, boolean value) {
		if (value)
			mSelectedItemsIds.put(position, value);

		else
			mSelectedItemsIds.delete(position);
		notifyDataSetChanged();
	}

	public int getSelectedCount() {
		return mSelectedItemsIds.size();
	}

	public SparseBooleanArray getSelectedIds() {
		return mSelectedItemsIds;
	}
}