package factoryMethodPattern;
import entity.*;
public abstract class HostGameCreator extends AbstractFactory {
	@Override
	public abstract HostGame createHostGame();

}
