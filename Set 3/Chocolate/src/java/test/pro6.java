package test;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*; 
import java.io.*;
import java.util.*;
public class pro6 extends SimpleTagSupport{
 String texture;

 public void setName(String texture){
 this.texture=texture;
 }

 public void doTag() throws IOException{
 JspWriter out = getJspContext().getOut();;
 out.println("Hello "+ texture);
 }
} 