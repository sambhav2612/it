package com.abc;

import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class CustomTag extends SimpleTagSupport {

    private String name = "World";

    public void setName(String name) {
        this.name = name;
    }

    public void doTag() throws IOException {
        getJspContext().getOut().println("Hello " + name);
    }

}
