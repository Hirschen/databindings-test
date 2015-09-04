package com.bontouch.databindings;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

public class OldActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_old);
		final RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
		rv.setAdapter(new OldStyleAdapter());
		rv.setLayoutManager(new LinearLayoutManager(this));
	}

	public class OldStyleAdapter extends RecyclerView.Adapter<DeadToMeViewHolder>{

		@Override
		public DeadToMeViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
			return new DeadToMeViewHolder(getLayoutInflater().inflate(R.layout.dead_to_me_item, parent, false));
		}

		@Override
		public void onBindViewHolder(final DeadToMeViewHolder holder, final int position) {
			final Resources c = holder.itemView.getContext().getResources();
			final DeadToMe deadToMe = DeadToMeList.getList().get(position);
			holder.name.setText(deadToMe.name.get());
			ImageLoader.getInstance().displayImage(deadToMe.imgUrl.get(), holder.img);
			holder.itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(final View v) {
					deadToMe.marked.set(!deadToMe.marked.get());
					holder.name.setTextColor(deadToMe.marked.get() ? c.getColor(R.color.red) : c.getColor(R.color.black));
				}
			});
			holder.name.setTextColor(deadToMe.marked.get() ? c.getColor(R.color.red) : c.getColor(R.color.black));
		}

		@Override
		public int getItemCount() {
			return DeadToMeList.getList().size();
		}
	}

	public class DeadToMeViewHolder extends RecyclerView.ViewHolder{
		public final ImageView img;
		public final TextView name;

		public DeadToMeViewHolder(final View itemView) {
			super(itemView);
			img = (ImageView) itemView.findViewById(R.id.dead_to_me_img);
			name = (TextView) itemView.findViewById(R.id.dead_to_me_name);
		}
	}
}
