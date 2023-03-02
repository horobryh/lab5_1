package commands;

import java.util.Scanner;

public interface Executable {
    void execute(String[] args, Scanner... scanner);
    String getName();
    String getArgs();
    String getDescription();
}
