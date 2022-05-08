package iterator.impl;
import java.util.ArrayList;

import entity.OnlineGame;
import iterator.Template;
public class OnlineIteratorImpl extends Template<OnlineGame>{
	OnlineIteratorImpl(int index,ArrayList<OnlineGame> games){
		this.index=index;
		this.contents=games;
	}

}
