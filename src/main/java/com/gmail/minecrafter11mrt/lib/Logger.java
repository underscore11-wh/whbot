package com.gmail.minecrafter11mrt.lib;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Logger {
    String file;
    static Date time = new Date();
    static String format="HH:mm:ss-SSS";
    static DateFormat dateFormat = new SimpleDateFormat(format);
    static LogLevel loglevel;
    public Logger(String filename){
        file=filename;
    }
    public void println(Object content,LogLevel level){
        if(loglevel.equals(LogLevel.DEBUG)&&((level.equals(LogLevel.DEBUG)||level.equals(LogLevel.INFO)||level.equals(LogLevel.WARN)||level.equals(LogLevel.FATAL)))){
            printLogLn(content,level);
        }else if(loglevel.equals(LogLevel.INFO)&&(level.equals(LogLevel.INFO)||level.equals(LogLevel.WARN)||level.equals(LogLevel.FATAL))){
            printLogLn(content,level);
        }else if(loglevel.equals(LogLevel.WARN)&&(level.equals(LogLevel.WARN)||level.equals(LogLevel.FATAL))){
            printLogLn(content,level);
        }else if(loglevel.equals(LogLevel.FATAL)&&level.equals(LogLevel.FATAL)){
            printLogLn(content,level);
        }
    }
    public void print(Object content,LogLevel level){
        if(loglevel.equals(LogLevel.DEBUG)&&((level.equals(LogLevel.DEBUG)||level.equals(LogLevel.INFO)||level.equals(LogLevel.WARN)||level.equals(LogLevel.FATAL)))){
            printLog(content,level);
        }else if(loglevel.equals(LogLevel.INFO)&&(level.equals(LogLevel.INFO)||level.equals(LogLevel.WARN)||level.equals(LogLevel.FATAL))){
            printLog(content,level);
        }else if(loglevel.equals(LogLevel.WARN)&&(level.equals(LogLevel.WARN)||level.equals(LogLevel.FATAL))){
            printLog(content,level);
        }else if(loglevel.equals(LogLevel.FATAL)&&level.equals(LogLevel.FATAL)){
            printLog(content,level);
        }
    }
    static public void setLogLevel(LogLevel level){
        loglevel=level;
    }
    static public LogLevel getLoglevel(){
        return loglevel;
    }
    private void printLogLn(Object content,LogLevel level){
        System.out.println(dateFormat.format(time) + " [" + file + " " + level + "] " + content);
    }
    private void printLog(Object content,LogLevel level){
        System.out.print(dateFormat.format(time) + " [" + file + " " + level + "] " + content);
    }
}
