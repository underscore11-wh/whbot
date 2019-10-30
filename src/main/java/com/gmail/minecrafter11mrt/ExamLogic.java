package com.gmail.minecrafter11mrt;

import com.gmail.minecrafter11mrt.lib.Logger;
import org.javacord.api.entity.message.Message;

public class ExamLogic {
    String attempts;
    String timezone;
    String other;
    Message message;
    Logger logger = new Logger("Examlogic");
    public ExamLogic(Parser parser, Message mes){
        timezone=parser.content.substring(0,3);
        attempts=parser.content.substring(4,5);
        other=parser.content.substring(6);
        message=mes;
    }
    void sendMessage() {
        Messages.newrequest(message.getAuthor(), timezone, attempts, other)
                .append("Request Submitted!\nIf you haven't already, please watch the Train-ing 101 video: [LINK]")
                .send(message.getChannel());
        Messages.newrequest(message.getAuthor(), timezone, attempts, other)
                .append("ROLE TAG")
                .send(Main.logchannel);
        System.out.println("Entering Lambada");
        Messages.newrequest(message.getAuthor(), timezone, attempts, other).send(Main.queuechannel).thenAcceptAsync(queuemessage ->{
            System.out.println("In Lambada");
            Long mid=queuemessage.getId();
            System.out.println("Message ID:"+mid);
            Long mau = message.getAuthor().getId();
            System.out.println("Requester:"+mau);
            Main.queuemessages.put(mid, mau);
            System.out.println("Done Lambada");
        }).exceptionally(throwable -> {
            Messages.error(throwable).send(message.getChannel());
            return null;
        });
    }
}

