package com.andreubita.alfajda.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class PingCommand extends Command {

    public PingCommand(){
        super.name = "ping";
    }

    @Override
    protected void execute(CommandEvent event) {
        event.reply("Pong! Delay: **" + event.getJDA().getGatewayPing() + "ms**");
    }
}
