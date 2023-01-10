package cn.ruizrui.gameforum.repository;

public interface LoginLogDAO {
	int getDay();
	int getMonth();
	boolean log(String useName);
}
