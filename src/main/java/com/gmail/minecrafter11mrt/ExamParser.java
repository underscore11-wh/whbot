package com.gmail.minecrafter11mrt;

public class ExamParser {
    String attempts;
    String timezone;
    String other;
    public ExamParser(Parser parser){
        timezone=parser.content.substring(0,3);
        attempts=parser.content.substring(4,5);
        other=parser.content.substring(6);
    }
}
