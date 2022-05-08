package factoryMethodPattern;
import entity.*;
public class SingleGameCreator extends HostGameCreator{
	@Override
	public HostGame createHostGame() {
		// TODO 自动生成的方法存根
		return new HostGame();
	}

	@Override
	public MobileGame createMoblieGame() {
		// TODO 自动生成的方法存根
		return null;
	}
}
