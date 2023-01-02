package cn.ruizrui.gameforum.iterator.impl;
import java.util.ArrayList;

import cn.ruizrui.gameforum.model.OnlineGame;
import cn.ruizrui.gameforum.iterator.Template;
public class OnlineIteratorImpl extends Template<OnlineGame>{
	OnlineIteratorImpl(int index,ArrayList<OnlineGame> games){
		this.index=index;
		this.contents=games;
	}

}
