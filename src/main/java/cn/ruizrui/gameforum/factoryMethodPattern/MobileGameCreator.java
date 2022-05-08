package factoryMethodPattern;
import entity.*;
public abstract class MobileGameCreator extends AbstractFactory{
	public abstract MobileGame createMobileGame();
}
