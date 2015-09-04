package com.bontouch.databindings;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Christoffer Hirsimaa on 01/09/15.
 */
public class GenericViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
	private T binder;

	public GenericViewHolder(final T binder) {
		super(binder.getRoot());
		this.binder = binder;
	}

	public T getBinder(){
		return binder;
	}
}
