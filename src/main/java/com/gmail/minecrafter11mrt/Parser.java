package com.gmail.minecrafter11mrt;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

class Parser {
    Type type = Type.NONE;
    String content;
    private static Logger logger = Logger.getLogger("Parser");

    Parser(String message) {
        Main.initLogger(logger);
        logger.log(Level.FINER,"New Parser initialized",this);
        content = message;
    }

    Type preParse() {
        if (content.startsWith("-exam")) {
            type = Type.EXAM;
        } else if (content.startsWith("-help")) {
            type = Type.HELP;
        } else if (content.startsWith("-ping")) {
            type = Type.PING;
        } else if(content.startsWith("<@!"+Main.api.getYourself().getIdAsString()+">")){
            type = Type.MENTION;
        }
        else {
            type = Type.NONE;
        }
        return type;
    }

    String trim() {
        switch (type) {
            case EXAM:
                content=content.substring(6);
                break;
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
        logger.log(Level.FINER,"Trimmed message to "+content);
        return content;
    }
}
