package com.scalar.LldDesignPatterns;


abstract class LoggingProcessor
{
    public static int INFO=1;
    public static int DEBUG=2;
    public static int WARN=3;

    LoggingProcessor nextLoggingProcessor;

    LoggingProcessor(LoggingProcessor nextLoggingProcessor)
    {
        this.nextLoggingProcessor = nextLoggingProcessor;
    }

    void logger(int level, String message)
    {
        if(nextLoggingProcessor != null)
        {
            nextLoggingProcessor.logger(level, message);
        }

    }
}


class InfoProcessor extends LoggingProcessor {

    InfoProcessor(LoggingProcessor nextLoggingProcessor) {
        super(nextLoggingProcessor);
    }

    void logger(int level, String message) {
        if(level == INFO)
        {

            System.out.println(message);
        }
        else
        {
            System.out.println("INFO NOPE:");
            nextLoggingProcessor.logger(level, message);
        }

    }
}

class DebugProcessor extends LoggingProcessor {

    DebugProcessor(LoggingProcessor nextLoggingProcessor) {
        super(nextLoggingProcessor);
    }

    void logger(int level, String message) {
        if(level == DEBUG)
        {
            //System.out.println("DEBUG NOPE:");
            System.out.println(message);
        }
        else
        {
            System.out.println("DEBUG NOPE:");
            nextLoggingProcessor.logger(level, message);
        }
    }
}


class WarnProcessor extends LoggingProcessor {

    WarnProcessor(LoggingProcessor nextLoggingProcessor) {
        super(nextLoggingProcessor);
    }

    void logger(int level, String message) {
        if(level == WARN)
        {
            //System.out.println("WARN NOPE:");
            System.out.println(message);
        }
        else
        {
            System.out.println("WARN NOPE:");
            nextLoggingProcessor.logger(level, message);
        }
    }
}
public class ChainOfRespMain {
    public static void main(String[] args) {
       LoggingProcessor loggingProcessor=new InfoProcessor(new DebugProcessor(new WarnProcessor(null)));

       loggingProcessor.logger(loggingProcessor.WARN, "Hello World");
    }
}
