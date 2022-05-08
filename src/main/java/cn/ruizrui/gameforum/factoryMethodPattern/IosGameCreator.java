package factoryMethodPattern;
import entity.*;
public class IosGameCreator extends MobileGameCreator{

	@Override
	public MobileGame createMobileGame() {
		// TODO 自动生成的方法存根
		return new IosGame();
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
