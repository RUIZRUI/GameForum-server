package cn.ruizrui.gameforum.iterator.impl;
import java.util.ArrayList;
import cn.ruizrui.gameforum.entity.SingleGame;
import cn.ruizrui.gameforum.iterator.Template;;
public class SingleIteratorImpl  extends Template<SingleGame>{
	SingleIteratorImpl(int index,ArrayList<SingleGame> games){
		this.index=index;
		this.contents=games;
	}
}
