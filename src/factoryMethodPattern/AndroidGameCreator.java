package factoryMethodPattern;
import entity.*;
public class AndroidGameCreator extends MobileGameCreator{

	@Override
	public MobileGame createMobileGame() {
		// TODO 自动生成的方法存根
		return new AndroidGame();
	}

	@Override
	public HostGame createHostGame() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public MobileGame createMoblieGame() {
		// TODO 自动生成的方法存根
		return null;
	}
}
