package parking;

import executor.CommandExecutor;
import model.Slot;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static parking.CLI.context;

public class ParkingParser {



    public void parse(String input) {
        System.out.println(input);
        List<Slot> slots = new ArrayList<Slot>(6);

        try {
            BufferedReader br = new BufferedReader(new FileReader(input));
            String line ;
            while((line =br.readLine())!=null ){
                String [] options = line.split(" ");
                // System.out.println(options[0]+" ,"+options[1]);
                try {
                    CommandExecutor executor = (CommandExecutor) context.getBean(options[0]);
                    executor.execute(line);
                }
                catch (NoSuchBeanDefinitionException e ){
                    System.out.println("Invalid Command");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
