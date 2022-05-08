package factoryMethodPattern;
import entity.HostGame;
import entity.MobileGame;

public abstract class AbstractFactory {
 abstract public HostGame createHostGame();
 abstract public MobileGame createMoblieGame();
}
