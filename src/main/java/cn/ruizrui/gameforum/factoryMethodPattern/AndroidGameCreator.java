package cn.ruizrui.gameforum.factoryMethodPattern;
import cn.ruizrui.gameforum.entity.*;

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
