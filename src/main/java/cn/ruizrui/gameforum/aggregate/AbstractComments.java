package aggregate;

import entity.Comment;
import iterator.Template;
public abstract class AbstractComments {
	public abstract Template<Comment> createIterator();
}
