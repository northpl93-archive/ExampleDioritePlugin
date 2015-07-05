package tk.northpl.helloworld;

import org.diorite.Diorite;
import org.diorite.plugin.DioritePlugin;
import org.diorite.plugin.Plugin;

@Plugin(name = "NorczykowyPlugin", version = "0.1-SNAPSHOT", author = "NorthPL93")
public final class Main extends DioritePlugin
{
    private static Main instance;

    @Override
    public void onLoad()
    {
        instance = this;
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
        Diorite.getCommandMap().registerCommand(Diorite.getServer().createCommand(this, "helloworld").alias("hello").executor((sender, command, label, matchedPattern, args) ->
        {
            sender.sendSimpleColoredMessage("&cHello world!", "&a#OnlyDiorite");
        }).build());
    }
}
