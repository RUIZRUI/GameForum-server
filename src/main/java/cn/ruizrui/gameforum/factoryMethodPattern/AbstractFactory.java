package cn.ruizrui.gameforum.factoryMethodPattern;
import cn.ruizrui.gameforum.entity.HostGame;
import cn.ruizrui.gameforum.entity.MobileGame;

public abstract class AbstractFactory {
 abstract public HostGame createHostGame();
 abstract public MobileGame createMoblieGame();
}
