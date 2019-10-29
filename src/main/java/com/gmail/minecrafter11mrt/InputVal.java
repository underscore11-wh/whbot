package com.gmail.minecrafter11mrt;

import org.javacord.api.entity.message.Message;

class InputVal {
    Type cmd;
    Message message;
    boolean valid;
    InputVal(Type t, Message m){
        cmd=t;
        message=m;
    }
    boolean lengthcheck(){
        switch(cmd){
            case EXAM:
                valid=examLCheck();
                return valid;
            default:
                return true;
        }
    }
    private boolean examLCheck(){
        if(message.getContent().length()>=13){return true;}
        else{return false;}
    }
}
