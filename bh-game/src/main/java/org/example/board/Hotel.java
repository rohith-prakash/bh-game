package org.example.board;

import org.example.bank.Bank;
import org.example.common.Constants;
import org.example.player.Player;



import static org.example.board.HotelClass.Gold;
import static org.example.board.HotelClass.Platinum;

public class Hotel implements BoardPiece{
    private Player owner;
    private HotelClass status;
    public void action(Player player, Bank bank){
        if(owner == null){
            setOwner(player);
        } else if(player.getId().equals(owner.getId())){
            upgrade(bank);
        } else {
            payRent(player);
        }
    }
    public void setOwner(Player player){
        this.owner = player;
        status = HotelClass.Silver;
    }

    public long getRent(){
        switch (status){
            case Silver: return Constants.silverHotelRent;
            case Gold:return Constants.goldHotelRent;
            case Platinum:return Constants.platinumHotelRent;
            default: return 0;
        }
    }

    private long getUpgradeCost(){
        switch (status){
            case Silver: return Constants.goldHotelValue - Constants.silverHotelValue;
            case Gold: return Constants.platinumHotelValue - Constants.goldHotelValue;
            default: return 0;
        }
    }

    private HotelClass getUpgradedClass(){
        switch(status){
            case Silver: return Gold;
            default: return Platinum;
        }
    }

    private void upgrade(Bank bank){
        if(status.equals(HotelClass.Platinum)) return;
        long cost = getUpgradeCost();
        owner.setCurrentAmount(owner.getCurrentAmount()-cost);
        bank.depositAmount(cost);
        status = getUpgradedClass();
    }

    private void payRent(Player player){
        long rent = getRent();
        player.setCurrentAmount(player.getCurrentAmount()-rent);
        owner.setCurrentAmount(owner.getCurrentAmount()+rent);
    }
}