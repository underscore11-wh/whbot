package com.gmail.minecrafter11mrt;

import java.util.logging.Level;
import java.util.logging.Logger;

class Parser {
    Type type = Type.NONE;
    String content;
    String trimmed;
    String[] args;

    Parser(String message) {
        WHBot.logger.log(Level.INFO,"New Parser initialized",this);
        content = message;
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
            default:
                trimmed="";
                break;
        }
        WHBot.logger.log(Level.INFO,"Trimmed message to "+content);
        return content;
    }
    String[] splitArgs(){
        args=trim().split("|");
        WHBot.logger.log(Level.INFO,"Split Message '"+content+"' into "+args);
        return args;
    }
}
