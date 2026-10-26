package memento.guistate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private String savedTime;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.savedTime = LocalTime.now().format(formatter);
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public String getSavedTime() {
        return savedTime;
    }

    @Override
    public String toString() {
        return "State at " + savedTime;
    }
}
