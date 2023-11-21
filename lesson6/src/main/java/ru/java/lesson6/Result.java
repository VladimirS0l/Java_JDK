package ru.java.lesson6;

public class Result {
    private int id;
    private int car;
    private int lead;
    private int player;
    private boolean success;
    private int general;

    public Result() {
    }

    public Result(int id, int car, int lead, int player, boolean success, int general) {
        this.id = id;
        this.car = car;
        this.lead = lead;
        this.player = player;
        this.success = success;
        this.general = general;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCar() {
        return car;
    }

    public void setCar(int car) {
        this.car = car;
    }

    public int getLead() {
        return lead;
    }

    public void setLead(int lead) {
        this.lead = lead;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getGeneral() {
        return general;
    }

    public void setGeneral(int general) {
        this.general = general;
    }
}
