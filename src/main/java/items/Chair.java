package items;

import interfaces.*;

public class Chair extends Item implements IsSitable {
    private boolean busy;

    public Chair(String name) {
        super(name);
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }
}
