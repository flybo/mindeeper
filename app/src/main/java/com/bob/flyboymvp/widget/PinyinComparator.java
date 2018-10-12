package com.bob.flyboymvp.widget;

import com.bob.flyboymvp.model.PerAddrInfo;

import java.util.Comparator;

public class PinyinComparator implements Comparator<PerAddrInfo> {

	public int compare(PerAddrInfo o1, PerAddrInfo o2) {
		if (o1.getPer_pinyin().equals("@")
				|| o2.getPer_pinyin().equals("#")) {
			return 1;
		} else if (o1.getPer_pinyin().equals("#")
				|| o2.getPer_pinyin().equals("@")) {
			return -1;
		} else {
			return o1.getPer_pinyin().compareTo(o2.getPer_pinyin());
		}
	}

}
