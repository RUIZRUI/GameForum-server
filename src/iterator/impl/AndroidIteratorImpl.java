package iterator.impl;
import java.util.ArrayList;
import entity.AndroidGame;
import iterator.Template;

public class AndroidIteratorImpl extends Template<AndroidGame>{
	public AndroidIteratorImpl(int index,ArrayList<AndroidGame> games){
		this.index=index;
		this.contents=games;
	}
}
