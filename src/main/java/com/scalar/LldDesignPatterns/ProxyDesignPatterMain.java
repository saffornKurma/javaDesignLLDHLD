package com.scalar.LldDesignPatterns;

//THIS IS INTERFACE
interface  Actor{
    void giveSignature();
}

//MAIN ACTOR
class RealActor implements Actor{

    @Override
    public void giveSignature() {
        System.out.println("RealActor gaveSignature");
    }
}
//PROXY WHICH HAS A ACTOR MANAGERS WHAT TO DO
class ManagerProxy implements Actor{
    //MAIN THING HAS A ACTOR
    Actor actor;
    boolean permission;
    public ManagerProxy(boolean permission, Actor actor) {
        this.actor = actor;
        this.permission = permission;
    }


    @Override
    public void giveSignature() {
        if(this.permission) {
            System.out.println("Manager: with permission");
            actor.giveSignature();
        }
        else {
            System.out.println("Manager: without permission");
        }
    }
}

public class ProxyDesignPatterMain {
    public static void main(String[] args) {
        Actor actor = new RealActor();
        ManagerProxy manager = new ManagerProxy(true, actor);
        manager.giveSignature();
        ManagerProxy manager2 = new ManagerProxy(false, actor);
        manager2.giveSignature();
    }
}
