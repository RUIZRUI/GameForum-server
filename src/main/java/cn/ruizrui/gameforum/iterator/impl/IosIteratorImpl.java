package cn.ruizrui.gameforum.iterator.impl;
import java.util.ArrayList;

import cn.ruizrui.gameforum.model.IosGame;
import cn.ruizrui.gameforum.iterator.Template;
public class IosIteratorImpl extends Template<IosGame>{
	IosIteratorImpl(int index,ArrayList<IosGame> games){
		this.index=index;
		this.contents=games;
		
	}
}
