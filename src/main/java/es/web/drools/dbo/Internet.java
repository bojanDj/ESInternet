/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.web.drools.dbo;

/**
 *
 * @author Bojan
 */

public class Internet {
	private int users;
	private int devices;
	private int devices4K;
	private int gamers;
	private int remoteWorkers;
	private int cloud;
	private boolean rural;
	private boolean fiber;
	private boolean cabel;
	private boolean dsl;
	private boolean price;
	
	private double speed = 0;
	private String type = "Satelite";
	
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public int getUsers() {
		return users;
	}
	public void setUsers(int users) {
		this.users = users;
	}
	public int getDevices() {
		return devices;
	}
	public void setDevices(int devices) {
		this.devices = devices;
	}
	public int getDevices4K() {
		return devices4K;
	}
	public void setDevices4K(int devices4k) {
		devices4K = devices4k;
	}
	public int getGamers() {
		return gamers;
	}
	public void setGamers(int gamers) {
		this.gamers = gamers;
	}
	public int getRemoteWorkers() {
		return remoteWorkers;
	}
	public void setRemoteWorkers(int remoteWorkers) {
		this.remoteWorkers = remoteWorkers;
	}
	public int getCloud() {
		return cloud;
	}
	public void setCloud(int cloud) {
		this.cloud = cloud;
	}
	public boolean isRural() {
		return rural;
	}
	public void setRural(boolean rural) {
		this.rural = rural;
	}
	public boolean isFiber() {
		return fiber;
	}
	public void setFiber(boolean fiber) {
		this.fiber = fiber;
	}
	public boolean isCabel() {
		return cabel;
	}
	public void setCabel(boolean cabel) {
		this.cabel = cabel;
	}
	public boolean isDsl() {
		return dsl;
	}
	public void setDsl(boolean dsl) {
		this.dsl = dsl;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

    @Override
    public String toString() {
        return "Internet{" + "users=" + users + ", devices=" + devices + ", devices4K=" + devices4K + ", gamers=" + gamers + ", remoteWorkers=" + remoteWorkers + ", cloud=" + cloud + ", rural=" + rural + ", fiber=" + fiber + ", cabel=" + cabel + ", dsl=" + dsl + ", price=" + price + ", speed=" + speed + ", type=" + type + '}';
    }
	
	public boolean isPrice() {
		return price;
	}
	public void setPrice(boolean price) {
		this.price = price;
	}
}

