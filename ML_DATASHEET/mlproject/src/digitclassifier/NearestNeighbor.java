package digitclassifier;

import java.util.*;

public class NearestNeighbor {
    private List<DataInstance> trainingData;

    public NearestNeighbor(List<DataInstance> trainingData) {
        this.trainingData = trainingData;
    }

    public double calculateDistance(DataInstance pointA, DataInstance pointB) {
        double distance = 0;
        double[] featuresA = pointA.getFeatures();
        double[] featuresB = pointB.getFeatures();
        for (int i = 0; i < featuresA.length; i++) {
            distance += Math.pow(featuresA[i] - featuresB[i], 2);
        }
        return Math.sqrt(distance);
    }

    public int predict(DataInstance testPoint, int k) {
        List<Map.Entry<DataInstance, Double>> distances = new ArrayList<>();
        for (DataInstance trainPoint : trainingData) {
            double distance = calculateDistance(testPoint, trainPoint);
            distances.add(new AbstractMap.SimpleEntry<>(trainPoint, distance));
        }

        distances.sort(Map.Entry.comparingByValue());

        int[] votes = new int[10]; 
        for (int i = 0; i < k; i++) {
            int label = distances.get(i).getKey().getLabel();
            votes[label]++;
        }

        int mostVotedLabel = -1;
        int maxVotes = -1;
        for (int i = 0; i < votes.length; i++) {
            if (votes[i] > maxVotes) {
                maxVotes = votes[i];
                mostVotedLabel = i;
            }
        }

        return mostVotedLabel;
    }
}
