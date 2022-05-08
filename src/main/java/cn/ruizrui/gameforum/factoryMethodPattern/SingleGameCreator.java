package cn.ruizrui.gameforum.factoryMethodPattern;
import cn.ruizrui.gameforum.entity.*;
public class SingleGameCreator extends HostGameCreator{
	@Override
	public HostGame createHostGame() {
		// TODO �Զ����ɵķ������
		return new HostGame();
	}

	@Override
	public MobileGame createMoblieGame() {
		// TODO �Զ����ɵķ������
		return null;
	}
}
