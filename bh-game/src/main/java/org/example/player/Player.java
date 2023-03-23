package org.example.player;

import java.util.UUID;

public interface Player {

    public UUID getId();

    public int getCurrentAmount();

    public void setCurrentAmount(int amount);

    public void addProperty(Property property);
//    public List<Property> getProperties();

    public int getMoneyFromProperty();

    public void printAssets(int index);
}
