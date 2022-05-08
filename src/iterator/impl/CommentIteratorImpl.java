package iterator.impl;

import java.util.ArrayList;
import entity.Comment;
import iterator.Template;
public class CommentIteratorImpl extends Template<Comment>{
	public CommentIteratorImpl(int index,ArrayList<Comment> comments) {
		this.index=index;
		this.contents=comments;
	}
}
