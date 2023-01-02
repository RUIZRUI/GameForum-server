package cn.ruizrui.gameforum.factory;
import cn.ruizrui.gameforum.model.HostGame;
import cn.ruizrui.gameforum.model.MobileGame;

public abstract class AbstractFactory {
 abstract public HostGame createHostGame();
 abstract public MobileGame createMoblieGame();
}
