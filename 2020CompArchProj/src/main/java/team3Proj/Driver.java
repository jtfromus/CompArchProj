package team3Proj;

import org.apache.commons.cli.*;

public class Driver {

	static Options options = new Options();

	static void addOption(String opt, String description) {
		Option option = new Option(opt, true, description);
		option.setRequired(true);
		options.addOption(option);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Options options = new Options();

		addOption("f", "trace file name");
		addOption("s", "cache size in KB (up to 8MB)");
		addOption("b", "block size");
		addOption("a", "associativity");
		addOption("r", "replacement policy (RR, RND, or LRU)");

		CommandLineParser parser = new DefaultParser();
		HelpFormatter formatter = new HelpFormatter();
		CommandLine cmd = null;

		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			formatter.printHelp("Sim.jar", options);

			System.exit(1);
		}

		String traceFile = cmd.getOptionValue("f");
		String cacheSize = cmd.getOptionValue("s");
		String blockSize = cmd.getOptionValue("b");
		String associativity = cmd.getOptionValue("a");
		String replacementPolicy = cmd.getOptionValue("r");

		// TODO: Convert cache size to KB
		// TODO: Convert cacheSize, blockSize, and associativity to integers
		// Cache cache = new Cache(cacheSize, blockSize, associativity);
	}

}
