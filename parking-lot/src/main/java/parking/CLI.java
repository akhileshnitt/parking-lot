package parking;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CLI {

    private String[] args = null;
    private static Options OPTIONS = new Options();
    private static final String		FILE_OPTION_KEY						= "inputFile";
    private static final String		HELP_OPTION_KEY						= "help";
    public static ApplicationContext context =null;


    public CLI(String[] args) {

        context = new ClassPathXmlApplicationContext("parking-lot.xml");
        this.args = args;
        OptionGroup optionGroup = new OptionGroup();
        optionGroup.addOption(new Option(HELP_OPTION_KEY, "help message"));
        OPTIONS.addOptionGroup(optionGroup);


        OptionGroup optionGroup1 = new OptionGroup();
        OptionBuilder.withArgName("input file location");
        OptionBuilder.hasArg();
        OptionBuilder.isRequired(true);
        OptionBuilder.withDescription("input file location");
        optionGroup1.addOption(OptionBuilder.create(FILE_OPTION_KEY));
        OPTIONS.addOptionGroup(optionGroup1);

    }



    private void parse() {

        CommandLineParser parser = new BasicParser();
        CommandLine cmd = null;
        String input=null;

        try {
            cmd = parser.parse(OPTIONS, args);
            if (cmd.hasOption(HELP_OPTION_KEY)) {
                printHelp();
            }
            else if(cmd.hasOption(FILE_OPTION_KEY)){
                input = cmd.getOptionValue(FILE_OPTION_KEY);
                parseInputFile(input);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    private void parseInputFile(String input) {
        ParkingParser parkingParser = new ParkingParser();
        parkingParser.parse(input);
    }

    private static void printHelp()
    {
        HelpFormatter formatter = new HelpFormatter();
        formatter.setWidth(250);
        formatter.printHelp("java -jar parking-lot.jar -inputFile <input file  location> ", OPTIONS);
        System.exit(0);
    }


  /*  public static void main(String[] args) {
  //      System.out.println("inside CLI");
        switch (args.length) {
            case 0:
                break;
            case 1:
                new CLI(args).parse();
                break;
        }

    }
*/
}


