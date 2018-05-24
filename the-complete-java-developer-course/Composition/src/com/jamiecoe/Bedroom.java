package com.jamiecoe;

public class Bedroom {
    private Bed bed;
    private Table table;
    private Wardrobe wardrobe;

    public Bedroom(Bed bed, Table table, Wardrobe wardrobe) {
        this.bed = bed;
        this.table = table;
        this.wardrobe = wardrobe;
    }

    public Bedroom(PC pc) {
        this(new Bed(), new Table(pc), new Wardrobe());
    }

    public String getBedFrameMaterial() {
        return bed.getBedFrameMaterial();
    }

    public Bed getBed() {
        return bed;
    }

    public Table getTable() {
        return table;
    }

    public Wardrobe getWardrobe() {
        return wardrobe;
    }
}
