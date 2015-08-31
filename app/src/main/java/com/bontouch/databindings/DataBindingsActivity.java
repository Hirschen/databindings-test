package com.bontouch.databindings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bontouch.databindings.databinding.NewDeadToMeItemBinding;

public class DataBindingsActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_old);
		// Oh yes, this can be replaced too so we don't need findViewById here either :)
		final RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
		rv.setAdapter(new DataBindingsAdapter());
		rv.setLayoutManager(new LinearLayoutManager(this));
	}

	public class DataBindingsAdapter extends RecyclerView.Adapter<DeadToMeViewHolder>{
		@Override
		public DeadToMeViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
			final LayoutInflater li = LayoutInflater.from(parent.getContext());
			return new DeadToMeViewHolder(NewDeadToMeItemBinding.inflate(li));
		}

		@Override
		public void onBindViewHolder(final DeadToMeViewHolder holder, final int position) {
			final DeadToMe deadToMe = DeadToMeList.getList().get(position);
			holder.itemBinder.setDead(deadToMe);
		}

		@Override
		public int getItemCount() {
			return DeadToMeList.getList().size();
		}
	}

	public class DeadToMeViewHolder extends RecyclerView.ViewHolder{
		public NewDeadToMeItemBinding itemBinder;

		public DeadToMeViewHolder(final NewDeadToMeItemBinding itemBinder) {
			super(itemBinder.getRoot());
			this.itemBinder = itemBinder;
		}
	}
}
