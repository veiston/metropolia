package memento.guistate;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {
    private Model model;
    private Gui gui;
    private ObservableList<IMemento> history; // Memento history
    private List<IMemento> redoHistory;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = FXCollections.observableArrayList();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public ObservableList<IMemento> getHistory() {
        return history;
    }

    public void restoreFromHistory(IMemento state) {
        if (state != null) {
            model.restoreState(state);
            gui.updateGui();
        }
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            redoHistory.add(model.createMemento());
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            System.out.println("Memento found in redo history");
            history.add(model.createMemento());
            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(nextState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
        redoHistory.clear();
    }
}
