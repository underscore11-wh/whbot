package com.gmail.minecrafter11mrt;

import java.util.logging.Level;
import java.util.logging.Logger;

class Parser {
    Type type = Type.NONE;
    String content;

    Parser(String message) {
        WHBot.logger.log(Level.FINER,"New Parser initialized",this);
        content = message;
    }

    Type preParse() {
        if (content.startsWith("-help")) {
            type = Type.HELP;
        } else if (content.startsWith("-ping")) {
            type = Type.PING;
        } else if(content.startsWith("<@!"+Main.api.getYourself().getIdAsString()+">")){
            type = Type.MENTION;
        } else if(content.startsWith("-changelog")){
            type = Type.CHANGELOG;
        } else{
            type = Type.NONE;
        }
        return type;
    }

    String trim() {
        switch (type) {
            case HELP:
                content=content.substring(6);
                break;
            case PING:
                content=content.substring(6);
                break;
            default:
                content="";
                break;
        }
        WHBot.logger.log(Level.FINER,"Trimmed message to "+content);
        return content;
    }
}
