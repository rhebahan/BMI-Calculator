package model;

public enum Gender {
    COWOK("Cowok"),
    CEWEK("Cewek");

    private final String label;

    Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
