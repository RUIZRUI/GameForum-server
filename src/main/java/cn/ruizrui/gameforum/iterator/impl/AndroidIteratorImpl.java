package cn.ruizrui.gameforum.iterator.impl;
import java.util.ArrayList;
import cn.ruizrui.gameforum.model.AndroidGame;
import cn.ruizrui.gameforum.iterator.Template;

public class AndroidIteratorImpl extends Template<AndroidGame>{
	public AndroidIteratorImpl(int index,ArrayList<AndroidGame> games){
		this.index=index;
		this.contents=games;
	}
}
