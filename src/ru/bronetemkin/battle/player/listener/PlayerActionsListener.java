package ru.bronetemkin.battle.player.listener;

import ru.bronetemkin.battle.listener.StatusListener;
import ru.bronetemkin.battle.player.Player;

/**
 * Created by Bronetemkin on 27.09.2016.
 */
public class PlayerActionsListener implements StatusListener<Integer, Player.Status>{

    @Override
    public void onStatusChanged(Integer status, Player.Status data) {
        switch (status){
            case Player.Status.ATTACK:{
                onAttack(data);
                break;
            }
            case Player.Status.HALF_ATTACK:{
                onHalfAttack(data);
                break;
            }
            case Player.Status.DEFENSE:{
                onDefense(data);
                break;
            }
            case Player.Status.WAIT:{
                onWait(data);
                break;
            }
            case Player.Status.DEAD:{
                onDead();
                break;
            }
        }
    }

    public void onAttack(Player.Status data){}

    public void onHalfAttack(Player.Status data){}

    public void onDefense(Player.Status data){}

    public void onWait(Player.Status data){}

    public void onDead(){}
}
