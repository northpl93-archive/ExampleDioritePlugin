package tk.northpl.helloworld;

import org.diorite.Diorite;
import org.diorite.plugin.Plugin;
import org.diorite.plugin.PluginMainClass;

@Plugin(name = "NorczykowyPlugin2", version = "0.1-SNAPSHOT", author = "NorthPL93")
public final class Main extends PluginMainClass
{
    private static Main instance;

    @Override
    public void onLoad()
    {
        instance = (Main) this.instance(); // Tutaj mozesz zastapic this.instance() na zwykle this, wtedy nie trzeba castowac
        System.out.println("Hello world in onLoad!");
    }

    @Override
    public void onEnable()
    {
        System.out.println("Hello world in onEnable!");
        this.registerCommand();
    }

    @Override
    public void onDisable()
    {
        System.out.println("Hello world in onDisable!");
    }

    public static Main getInstance()
    {
        return instance;
    }

    private void registerCommand()
    {
        Diorite.getCommandMap().registerCommand(Diorite.getServer().createCommand(this, "helloworld").executor((sender, command, label, matchedPattern, args) -> {
            sender.sendSimpleColoredMessage("&cHello world!", "&a#OnlyDiorite");
        }).build());
    }
}
