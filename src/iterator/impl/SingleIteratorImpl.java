package iterator.impl;
import java.util.ArrayList;
import entity.SingleGame;
import iterator.Template;;
public class SingleIteratorImpl  extends Template<SingleGame>{
	SingleIteratorImpl(int index,ArrayList<SingleGame> games){
		this.index=index;
		this.contents=games;
	}
}
