package digitclassifier;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String trainFilePath = "src/dataSet1.csv";  
        String testFilePath = "src/dataSet2.csv";  

        DataLoader dataLoader = new DataLoader();
        List<DataInstance> trainingData = dataLoader.loadData(trainFilePath);
        List<DataInstance> testData = dataLoader.loadData(testFilePath);

        NearestNeighbor knn = new NearestNeighbor(trainingData);

        int correctPredictions = 0;
        for (DataInstance testPoint : testData) {
            int predictedLabel = knn.predict(testPoint, 3);  // using k=3 
            if (predictedLabel == testPoint.getLabel()) {
                correctPredictions++;
            }
        }

        double accuracy = (double) correctPredictions / testData.size() * 100;
        System.out.println("Accuracy: " + accuracy + "%");
    }
}
