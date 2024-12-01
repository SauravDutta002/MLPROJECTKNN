package digitclassifier;

public class DataInstance {
    private double[] features;
    private int label;

    public DataInstance(double[] features, int label) {
        this.features = features;
        this.label = label;
    }

    public double[] getFeatures() {
        return features;
    }

    public int getLabel() {
        return label;
    }
}
