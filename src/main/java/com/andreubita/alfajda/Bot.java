package com.andreubita.alfajda;

import com.andreubita.alfajda.commands.PingCommand;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.util.concurrent.TimeUnit;

public class Bot {

    private Bot() throws LoginException {
        final JDA jda = new JDABuilder(AccountType.BOT)
                .setToken(Config.get("TOKEN")).build();

        CommandClientBuilder builder = new CommandClientBuilder()
                .setActivity(Activity.watching("you"))
                .setPrefix("!")
                .setOwnerId("455346901278261281")
                .setHelpWord("help");

        CommandClient client = builder.build();
        jda.addEventListener(client);
        client.addCommand(new PingCommand());
    }

    public static void main(String[] args) throws LoginException {
        long enable = System.currentTimeMillis();
        new Bot();
        System.out.println("Bot iniciado em " + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - enable) + "s");
    }
}
