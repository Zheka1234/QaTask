package com.miskevich.homework3.parser;


import com.miskevich.homework3.utilities.Iterator;

public class ProgramRunner {

    public static void main(String[] args) {
        XMLParser parser = new XMLParser("src/test/java/homework3/filesxml/simple.xml");
        parser.parseDocument();
        if (parser.getErrors().isEmpty()) {
            System.out.println("Valid xml");
        } else {
            Iterator<String> errorsIter = parser.getErrors().iterator();
            while (errorsIter.hasNext()) {
                System.out.println(errorsIter.next());
            }
        }
    }
}
