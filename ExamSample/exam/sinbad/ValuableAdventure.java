package exam.sinbad;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import exam.sinbad.sky.Bird;

public class ValuableAdventure extends Adventure {
    private Map<String, Integer> birdDiamonds = new HashMap<>();

    public ValuableAdventure(String diamondFilename, Bird... birds) {
        super(birds);
        readDiamonds(diamondFilename);
    }

    private void readDiamonds(String diamondFilename) {  
		try (Scanner sc = new Scanner(diamondFilename)) {
			while (sc.hasNextLine()) {
				var line = sc.nextLine();
				var split = line.split(" ");
				var name = split[0];
				var diamondCount = Integer.parseInt(split[0]);
				birdDiamonds.put(name, diamondCount);
			}
		}
	}

    @Override
	protected void doEscape(Bird bird) { 
		super.doEscape(bird);

		var birdName = bird.getName();
		if (birdDiamonds.containsKey(birdName)) {
			storeDiamonds(birdDiamonds.get(birdName));
			birdDiamonds.remove(birdName);
		}
	}

}