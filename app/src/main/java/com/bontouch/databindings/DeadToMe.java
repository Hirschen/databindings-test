package com.bontouch.databindings;

import android.databinding.ObservableField;
import android.view.View;

/**
 * Created by Christoffer Hirsimaa on 31/08/15.
 */
public class DeadToMe {

	public ObservableField<String> name = new ObservableField<>("");

	public ObservableField<String> imgUrl = new ObservableField<>("");

	public ObservableField<Boolean> marked = new ObservableField<>(Boolean.FALSE);

	public DeadToMe(String name, String imgUrl){
		this.name.set(name);
		this.imgUrl.set(imgUrl);
	}

	public void onClick(View v){
		marked.set(!marked.get());
	}
}
