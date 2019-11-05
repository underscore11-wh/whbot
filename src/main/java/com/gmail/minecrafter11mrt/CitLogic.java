package com.gmail.minecrafter11mrt;

import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;

public class CitLogic {
    Message m;
    Parser p;
    String pastOffenses;
    String username;
    public CitLogic(Message message, Parser parser){
        m=message;
        p=parser;
        String[] args=p.splitArgs(2);
        if(inputValidation(args,m)) {
            username = args[0];
            pastOffenses = args[1];
            message.getAuthor().asUser().ifPresent(user -> {
                Messages.citRequest(message.getAttachments().get(0).getUrl().toString(), username, pastOffenses, user).send(WHBot.borderForce);
            });
        }
    }
    private boolean inputValidation(String[] args,Message message){
        if(args.length==0){
            Messages.badFormat("Not enough arguments!","Make sure to at least include your IGN").send(message.getChannel());
            return false;
        }else if(message.getAttachments().isEmpty()){
            Messages.badFormat("No screenshot attached!","Make sure to attach the screenshot you took at the end of the citizenship test!").send(message.getChannel());
            return false;
        }else{
            return true;
        }
    }
}
