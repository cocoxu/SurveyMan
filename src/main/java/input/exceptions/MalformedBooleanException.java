package input.exceptions;

import input.Parser;
import input.csv.CSVParser;
import survey.SurveyException;
import system.Bug;
import system.Debugger;

import java.lang.reflect.Method;

public class MalformedBooleanException extends SurveyException implements Bug {
    Object caller;
    Method lastAction;
    public MalformedBooleanException(String boolStr, String column, Parser caller, Method lastAction) {
        super(String.format("Unrecognized boolean string (%s) in column %s. See the SurveyMan wiki for accepted strings.", boolStr, column));
        this.caller = caller;
        this.lastAction = lastAction;
        Debugger.addBug(this);
    }

    @Override
    public Object getCaller() {
        return caller;
    }

    @Override
    public Method getLastAction() {
        return lastAction;
    }
}