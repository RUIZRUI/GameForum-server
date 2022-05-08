package cn.ruizrui.gameforum.iterator.impl;

import java.util.ArrayList;

import cn.ruizrui.gameforum.entity.CollectInfo;
import cn.ruizrui.gameforum.iterator.Template;

public class CollectIteratorImpl extends Template<CollectInfo>{
	public CollectIteratorImpl(int index,ArrayList<CollectInfo> collects) {
		this.index=index;
		this.contents=collects;
	}
}
