package org.example.player;

import java.util.UUID;

public interface Player {

    public UUID getId();
    public long getCurrentAmount();
    public void setCurrentAmount(long amount);
}
