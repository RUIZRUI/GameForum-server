package factoryMethodPattern;
import entity.*;
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
