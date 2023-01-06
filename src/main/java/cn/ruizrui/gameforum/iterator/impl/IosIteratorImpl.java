package cn.ruizrui.gameforum.iterator.impl;
import java.util.ArrayList;

import cn.ruizrui.gameforum.model.IOSGame;
import cn.ruizrui.gameforum.iterator.Template;
public class IosIteratorImpl extends Template<IOSGame>{
	IosIteratorImpl(int index,ArrayList<IOSGame> games){
		this.index=index;
		this.contents=games;
		
	}
}
