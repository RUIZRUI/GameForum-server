package iterator.impl;
import java.util.ArrayList;

import entity.IosGame;
import iterator.Template;
public class IosIteratorImpl extends Template<IosGame>{
	IosIteratorImpl(int index,ArrayList<IosGame> games){
		this.index=index;
		this.contents=games;
		
	}
}
