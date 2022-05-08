package cn.ruizrui.gameforum.factoryMethodPattern;
import cn.ruizrui.gameforum.entity.*;
public abstract class HostGameCreator extends AbstractFactory {
	@Override
	public abstract HostGame createHostGame();

}
