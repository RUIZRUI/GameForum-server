package cn.ruizrui.gameforum.repository;

public interface loginLogDAO {
	public int getDay();
	public int getMonth();
	public boolean log(String useName);
}
