package org.example.player;

import org.example.common.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DummyPlayer implements Player{
    private UUID id;
    private List<Property> properties;
    private int totalAmount;

    public DummyPlayer() {
        id = UUID.randomUUID();
        properties = new ArrayList<>();
        totalAmount = Constants.playerInitialAmount;
    }

    @Override
    public int getCurrentAmount() {
        return totalAmount;
    }

    @Override
    public void setCurrentAmount(int totalAmount) {
        if(totalAmount < 0) throw new InvalidPlayerAmountException();
        this.totalAmount = totalAmount;
    }

    @Override
    public void addProperty(Property property){
        properties.add(property);
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public int getMoneyFromProperty(){
        return properties.stream().map(property -> property.getTotalValue()).mapToInt(Integer::intValue).sum();
    }

    @Override
    public void printAssets(int index){
        System.out.println("The Player " + index + " has amount " + getCurrentAmount() + " and " + properties.size() + " worth " + getMoneyFromProperty());
    }
}
