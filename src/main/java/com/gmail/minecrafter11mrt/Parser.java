package com.gmail.minecrafter11mrt;

import org.javacord.api.entity.message.Message;

import java.util.logging.Level;
import java.util.logging.Logger;

class Parser {
    Type type = Type.NONE;
    String content;
    String trimmed;
    String[] args;
    Message m;

    Parser(Message message) {
        try {
            m=message;
            content = message.getContent();
        }catch (Exception e){
            Messages.error(e,WHBot.logger).send(message.getChannel());
        }
        WHBot.logger.log(Level.INFO,"New Parser initialized ",content);
    }

    Type preParse() {
        if (content.startsWith("-help")) {
            type = Type.HELP;
        } else if (content.startsWith("-ping")) {
            type = Type.PING;
        } else if(content.startsWith("<@!"+WHBot.api.getYourself().getIdAsString()+">")){
            type = Type.MENTION;
        } else if(content.startsWith("-changelog")){
            type = Type.CHANGELOG;
        } else if(content.startsWith("-citizenship")){
            type = Type.CITIZENSHIP;
        } else{
            type = Type.NONE;
        }
        return type;
    }

    String trim() {
        switch (type) {
            case HELP:
                trimmed=content.substring(6);
                break;
            case PING:
                trimmed=content.substring(6);
                break;
            case CHANGELOG:
                trimmed=content.substring(12);
                break;
            case CITIZENSHIP:
                trimmed=content.substring(13);
                break;
            default:
                trimmed="";
                break;
        }
        WHBot.logger.log(Level.INFO,"Trimmed message to "+trimmed);
        return trimmed;
    }
    String[] splitArgs(int argLimit){
        trim();
        args = trimmed.split(" ", argLimit);
        WHBot.logger.log(Level.INFO, "Split Message '" + trimmed + "' into:");
        for (String value : args) {
            WHBot.logger.log(Level.INFO, "'"+value+"'");
        }
        WHBot.logger.log(Level.INFO, "(Length of " + args.length + ")");
        return args;
    }
}
