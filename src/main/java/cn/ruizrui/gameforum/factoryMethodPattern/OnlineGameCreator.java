package cn.ruizrui.gameforum.factoryMethodPattern;
import cn.ruizrui.gameforum.entity.*;
public class OnlineGameCreator extends HostGameCreator{
	@Override
	public HostGame createHostGame() {
		// TODO �Զ����ɵķ������
		return new OnlineGame();
	}

	@Override
	public MobileGame createMoblieGame() {
		// TODO �Զ����ɵķ������
		return null;
	}
}
