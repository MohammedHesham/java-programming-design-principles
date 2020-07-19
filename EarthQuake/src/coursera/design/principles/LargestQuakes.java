package coursera.design.principles;

import java.util.*;

public class LargestQuakes {


    public void findLargestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
//		String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size());

        List<QuakeEntry> largest = getLargest(list, 50);
        System.out.println("Largest quakes");
        for (QuakeEntry quakeEntry : largest) {
            System.out.println(quakeEntry);
        }

    }

    private int indexOfLargest(List<QuakeEntry> data) {
        int largestIndex = 0;
        for (int i = 1; i < data.size(); i++) {
            if (data.get(largestIndex).getMagnitude() < data.get(i).getMagnitude()) {
                largestIndex = i;
            }
        }
//        System.out.println("Largest quake " + largestIndex + " :" + data.get(largestIndex));
        return largestIndex;
    }


    public List<QuakeEntry> getLargest(List<QuakeEntry> quakeData, int howMany) {
        List<QuakeEntry> answer = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            int index = indexOfLargest(quakeData);
            answer.add(quakeData.get(index));
            quakeData.remove(index);
        }
        return answer;
    }
}
