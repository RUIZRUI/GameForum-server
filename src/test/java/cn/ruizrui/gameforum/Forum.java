package cn.ruizrui.gameforum;

import cn.ruizrui.gameforum.repository.impl.*;
import cn.ruizrui.gameforum.proxy.ProxyUser;
import cn.ruizrui.gameforum.service.AndroidConcretWindow;

public class Forum {
	public static void main(String[] args) {
		AndroidDAOImpl a=new AndroidDAOImpl();
		AndroidConcretWindow aw=new AndroidConcretWindow();
		UserDAOImpl ui =new UserDAOImpl();
		//ArrayList<AndroidGame> games=aw.getAndroidGameByTime();
		//AndroidIteratorImpl iter=new AndroidIteratorImpl(1,games);
		/*for(int i=0;i<games.size();i++){
			System.out.println(games.get(i).get);
		}*/
		/*
		AndroidGame game=aw.getGame("熊猫运动会");
		System.out.println(game.getGame_id());

		
		UserEntity ue=ui.getByName("12345");
		
		/*ue.setPassword("112");
		ue.setUser_name("12345");
		ue.setMail("12345");
		ue.setPhone("123455");
		
		/*
		p.commentGame("12345", "灵刃传说","nice");
		p.commentGame("12345", "热血征程","good");
		p.deleteCommentFromMe(8, "12345");
		UserEntity ue=new UserEntity();;
		
		ue.setPassword("112");
		ue.setUser_name("54321");
		ue.setMail("12345");
		ue.setPhone("123455");
				p.commentComment("54321", 9,"nice");
		p.commentComment("54321",10,"good");
		ArrayList<Comment> cs=p.getCommentFromMe("12345");
		for(int i=0;i<cs.size();i++) {
			System.out.println(cs.get(i).getComment_name());
		}
		*/
		/* ProxyUser p=new ProxyUser("管理员");
		System.out.println(p.cleanCommentFromMe("54321")); */
		
		/*
		 * 	public UserEntity getUserData(String userName);
	
	public String setUserAvater(String userName,String imgUrl);
	
	public ArrayList<Comment> getCommentToMe(String userName);
	
	public ArrayList<Comment> getCommentFromMe(String userName);
	
	public String deleteCommentFromMe(int commentId,String userName);
	
	public String cleanCommentFromMe(String userName);
		 */

		
		
	}

}
