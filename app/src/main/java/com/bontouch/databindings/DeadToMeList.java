package com.bontouch.databindings;

import java.util.ArrayList;

/**
 * Created by Christoffer Hirsimaa on 31/08/15.
 */
public class DeadToMeList {

	private static ArrayList<DeadToMe> list = new ArrayList<>();

	public static ArrayList<DeadToMe> getList() {
		if (list.isEmpty()) {
			list.add(new DeadToMe("The Android emulator", "http://cdn1.martinliu.cn/wp-content/gallery/citrix/vd.png"));
			list.add(new DeadToMe("Backstreet Boys\nAfter 'Lager than life'", "http://www.resume.se/contentassets/6c263830444e423790bcdb47403ce3ac/backstreet-boys.jpg"));
			list.add(new DeadToMe("Start/end lint warnings without any rtl languages supported", "https://dl.dropboxusercontent.com/u/3566166/start.jpg"));
			list.add(new DeadToMe("The Hobbit: The Battle of the Five Armies", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTObD10KSmgCNp0sX4oznjXAzxZ9IxFUEC3RHf6jTvpLCk_TkT-"));
			list.add(new DeadToMe("People blocking escalators", "http://i.imgur.com/NclbTsf.jpg"));
			list.add(new DeadToMe("Not pre sliced bread", "http://www.quinzanisbakery.com/images/bread-sesame-vienna.jpg"));
		}
		return list;
	}

	public static void addToList(DeadToMe pushedOnTop) {
		list.add(pushedOnTop);
	}
}
