package com.gmail.minecrafter11mrt;

import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;

public class CitLogic {
    Message m;
    Parser p;
    String pastOffenses;
    String username;
    public CitLogic(Message message, Parser parser){
        try {
            m = message;
            p = parser;
            if(message.getContent().equalsIgnoreCase("-citizenship")){
                Messages.badFormat("Not enough arguments!", "Make sure to include your in-game name and any past offenses.\nPut none if you have no previous offenses.").send(message.getChannel());
            }else {
                String[] args = p.splitArgs(2);
                if (inputValidation(args, m)) {
                    username = args[0];
                    pastOffenses = args[1];
                    message.getAuthor().asUser().ifPresent(user -> {
                        Messages.citRequest(message.getAttachments().get(0).getUrl().toString(), username, pastOffenses, user).send(WHBot.borderForce);
                    });
                }
            }
        }catch(Exception e){
            Messages.error(e, WHBot.logger).send(message.getChannel());
        }
    }
    private boolean inputValidation(String[] args,Message message){
        try {
            if (args.length != 2) {
                Messages.badFormat("Not enough arguments!", "Make sure to include your in-game name and any past offenses.\nPut none if you have no previous offenses.").send(message.getChannel());
                return false;
            } else if (message.getAttachments().isEmpty()) {
                Messages.badFormat("No screenshot attached!", "Make sure to attach the screenshot you took at the end of the citizenship test!").send(message.getChannel());
                return false;
            } else {
                return true;
            }
        }catch (Exception e){
            Messages.error(e,WHBot.logger);
            return false;
        }
    }
}
