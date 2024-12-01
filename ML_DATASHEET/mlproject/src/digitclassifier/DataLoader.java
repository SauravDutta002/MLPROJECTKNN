package digitclassifier;

import java.io.*;
import java.util.*;

public class DataLoader {
    public List<DataInstance> loadData(String filePath) {
        List<DataInstance> instances = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                double[] features = new double[values.length - 1];
                for (int i = 0; i < values.length - 1; i++) {
                    features[i] = Double.parseDouble(values[i]);
                }
                int label = Integer.parseInt(values[values.length - 1]);
                instances.add(new DataInstance(features, label));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instances;
    }
}
