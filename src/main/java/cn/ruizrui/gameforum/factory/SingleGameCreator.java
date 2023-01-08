package cn.ruizrui.gameforum.factory;
import cn.ruizrui.gameforum.model.*;
public class SingleGameCreator extends HostGameCreator{
	@Override
	public HostGame createHostGame() {
		return new HostGame();
	}

	@Override
	public MobileGame createMoblieGame() {
		return null;
	}
}
