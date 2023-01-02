package cn.ruizrui.gameforum.factory;
import cn.ruizrui.gameforum.model.*;

public class AndroidGameCreator extends MobileGameCreator{

	@Override
	public MobileGame createMobileGame() {
		// TODO �Զ����ɵķ������
		return new AndroidGame();
	}

	@Override
	public HostGame createHostGame() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public MobileGame createMoblieGame() {
		// TODO �Զ����ɵķ������
		return null;
	}
}
