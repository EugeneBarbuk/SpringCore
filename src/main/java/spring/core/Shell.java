package spring.core;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class Shell {
    @ShellMethod("Just try")
    public int add(int a, int b){
        return a+b;
    }
}
