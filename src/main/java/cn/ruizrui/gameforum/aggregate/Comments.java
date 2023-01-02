package cn.ruizrui.gameforum.aggregate;

import java.util.ArrayList;

import cn.ruizrui.gameforum.model.Comment;
import cn.ruizrui.gameforum.iterator.impl.CommentIteratorImpl;

public class Comments extends AbstractComments{
	ArrayList<Comment> comments;
	int index;
	public Comments(int index,ArrayList<Comment> comments) {
		this.index=index;
		this.comments=comments;
	}
	public CommentIteratorImpl createIterator() {
		return new CommentIteratorImpl(index,comments);
	}
}
