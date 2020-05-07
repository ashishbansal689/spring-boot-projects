package threadminions.springshell.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class MathOperations {

    @ShellMethod(key = "add", value = "Add two integer value")
    public Integer add(int a, int b){
        return a+b;
    }

    @ShellMethod(key = "subtract", value = "Subtract two integer value")
    public Integer subtract(int a, int b){
        return a-b;
    }

    @ShellMethod(key = "multiply", value = "Multiply two integer value")
    public Integer multiply(int a, int b){
        return a*b;
    }
}
