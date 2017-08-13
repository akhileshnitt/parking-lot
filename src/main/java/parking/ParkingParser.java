package parking;

import executor.CommandExecutor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static parking.CLI.context;

public class ParkingParser {



    public void parse(String input) {
        System.out.println(input);

        try {
            BufferedReader br = new BufferedReader(new FileReader(input));
            String line ;
            while((line =br.readLine())!=null ){
                String [] options = line.split(" ");
                System.out.println(options[0]+" ,"+options[1]);
                CommandExecutor executor = (CommandExecutor) context.getBean(options[0]);
                executor.execute(Integer.parseInt(options[1]));
           //     System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
