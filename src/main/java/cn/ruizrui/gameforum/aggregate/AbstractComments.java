package cn.ruizrui.gameforum.aggregate;

import cn.ruizrui.gameforum.entity.Comment;
import cn.ruizrui.gameforum.iterator.Template;
public abstract class AbstractComments {
	public abstract Template<Comment> createIterator();
}
