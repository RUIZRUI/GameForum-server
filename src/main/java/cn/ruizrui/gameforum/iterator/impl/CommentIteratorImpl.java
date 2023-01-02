package cn.ruizrui.gameforum.iterator.impl;

import java.util.ArrayList;
import cn.ruizrui.gameforum.model.Comment;
import cn.ruizrui.gameforum.iterator.Template;
public class CommentIteratorImpl extends Template<Comment>{
	public CommentIteratorImpl(int index,ArrayList<Comment> comments) {
		this.index=index;
		this.contents=comments;
	}
}
