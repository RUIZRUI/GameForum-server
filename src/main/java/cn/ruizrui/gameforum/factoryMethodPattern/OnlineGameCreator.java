package factoryMethodPattern;
import entity.*;
public class OnlineGameCreator extends HostGameCreator{
	@Override
	public HostGame createHostGame() {
		// TODO 自动生成的方法存根
		return new OnlineGame();
	}

	@Override
	public MobileGame createMoblieGame() {
		// TODO 自动生成的方法存根
		return null;
	}
}
