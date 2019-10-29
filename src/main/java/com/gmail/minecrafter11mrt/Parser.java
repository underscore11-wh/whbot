package com.gmail.minecrafter11mrt;

public class Parser {
    Type type = Type.NONE;
    String content;

    public Parser(String message) {
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
        return content;
    }
}
