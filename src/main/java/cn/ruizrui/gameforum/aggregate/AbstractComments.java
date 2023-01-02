package cn.ruizrui.gameforum.aggregate;

import cn.ruizrui.gameforum.model.Comment;
import cn.ruizrui.gameforum.iterator.Template;
public abstract class AbstractComments {
	public abstract Template<Comment> createIterator();
}
