package cn.ruizrui.gameforum.factory;
import cn.ruizrui.gameforum.model.*;
public class OnlineGameCreator extends HostGameCreator{
	@Override
	public HostGame createHostGame() {
		return new OnlineGame();
	}

	@Override
	public MobileGame createMoblieGame() {
		return null;
	}
}
