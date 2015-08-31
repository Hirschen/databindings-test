package com.bontouch.databindings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
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
			final LayoutInflater li = LayoutInflater.from(parent.getContext());
			return new DeadToMeViewHolder(li.inflate(R.layout.dead_to_me_item, parent, false));
		}

		@Override
		public void onBindViewHolder(final DeadToMeViewHolder holder, final int position) {
			final DeadToMe deadToMe = DeadToMeList.getList().get(position);
			final String name = deadToMe.name.get();
			holder.name.setText(name);
			ImageLoader.getInstance().displayImage(deadToMe.imgUrl.get(), holder.img);
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
