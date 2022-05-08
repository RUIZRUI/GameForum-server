package cn.ruizrui.gameforum.factoryMethodPattern;
import cn.ruizrui.gameforum.entity.*;
public class IosGameCreator extends MobileGameCreator{

	@Override
	public MobileGame createMobileGame() {
		// TODO �Զ����ɵķ������
		return new IosGame();
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
