package aggregate;

import java.util.ArrayList;

import entity.Comment;
import iterator.impl.CommentIteratorImpl;

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
