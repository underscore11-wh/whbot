package com.gmail.minecrafter11mrt;

public class ExamParser {
    String attempts;
    String timezone;
    String other;
    public ExamParser(Parser parser){
        timezone=parser.content.substring(6,9);
        attempts=parser.content.substring(10,11);
        other=parser.content.substring(12);
    }
}
