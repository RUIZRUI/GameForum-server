package iterator;

import java.util.ArrayList;
public abstract class Template<T> {
	protected int index;
	protected ArrayList<T> contents;
	public T first() {
		if(contents!=null) {
			return contents.get(0);
		}else {
			return null;
		}
	}
	public T get(int index) {
		if(contents!=null) {
			return contents.get(index);
		}else {
			return null;
		}
	}
	public T next() {
		if(contents==null) {
			 return null;
			}else if(index>contents.size()-1) {
				return null;
			}else {
				return contents.get(index++);
			}
	}
	public T previous() {
		if(contents==null) {
			return null;
		}else if(index<0) {
			return null;
		}else {
				return contents.get(index--);
		}
	}
	
	public T last() {
		if(contents==null) {
			return null;
		}else {
			return contents.get(contents.size()-1);
		}
	}
	
	public T current() {
		if(contents==null) {
			return null;
		}else if(index<0||index>contents.size()-1){
			return null;
		}else {
			return contents.get(index);
		}
	}

}

