package iterator.impl;

import java.util.ArrayList;

import entity.CollectInfo;
import iterator.Template;

public class CollectIteratorImpl extends Template<CollectInfo>{
	public CollectIteratorImpl(int index,ArrayList<CollectInfo> collects) {
		this.index=index;
		this.contents=collects;
	}
}
