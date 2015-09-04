package com.bontouch.databindings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

	public class DataBindingsAdapter extends RecyclerView.Adapter<GenericViewHolder<NewDeadToMeItemBinding>>{
		@Override
		public GenericViewHolder<NewDeadToMeItemBinding> onCreateViewHolder(final ViewGroup parent, final int viewType) {
			final NewDeadToMeItemBinding binder = NewDeadToMeItemBinding.inflate(getLayoutInflater(), parent, false);
			return new GenericViewHolder<>(binder);
		}

		@Override
		public void onBindViewHolder(final GenericViewHolder<NewDeadToMeItemBinding> holder, final int position) {
			final DeadToMe deadToMe = DeadToMeList.getList().get(position);
			holder.getBinder().setDead(deadToMe);
		}

		@Override
		public int getItemCount() {
			return DeadToMeList.getList().size();
		}
	}
}
