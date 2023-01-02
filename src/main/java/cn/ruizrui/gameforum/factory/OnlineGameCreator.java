package cn.ruizrui.gameforum.factory;
import cn.ruizrui.gameforum.model.*;
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
