package factoryMethodPattern;
import entity.*;
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
