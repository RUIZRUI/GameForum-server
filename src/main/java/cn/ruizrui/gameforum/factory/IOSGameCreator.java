package cn.ruizrui.gameforum.factory;
import cn.ruizrui.gameforum.model.*;
public class IOSGameCreator extends MobileGameCreator{

	@Override
	public MobileGame createMobileGame() {
		return new IOSGame();
	}

	@Override
	public HostGame createHostGame() {
		return null;
	}

	@Override
	public MobileGame createMoblieGame() {
		return null;
	}
}
