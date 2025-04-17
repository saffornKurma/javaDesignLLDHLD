package com.scalar.LldDesignPatterns;


import java.util.ArrayList;
import java.util.List;

interface Filesystem{
    void ls();
}

class Directory implements Filesystem{

    String name;
    List<Filesystem> filesystemList;

    Directory(String name){
        this.name = name;
        this.filesystemList = new ArrayList<>();
    }

    void addFilesystem(Filesystem filesystem){
        filesystemList.add(filesystem);
    }

    @Override
    public void ls() {
        System.out.println("Directory Filesystem: " + name);
        for(Filesystem filesystem : filesystemList){

            filesystem.ls();
        }
    }
}

class File implements Filesystem{
    String name;

    File(String name){
        this.name = name;
    }
    @Override
    public void ls() {
        System.out.println("File: " + name);
    }
}
public class CompositeDesignPatternMain {
    public static void main(String[] args) {
        Directory dr=new Directory("Movie");
        Directory dr2=new Directory("Horror");
        Directory dr3=new Directory("comedy");




        File f1=new File("Conjuring");
        File f2=new File("Insidious");
        File f3=new File("Dhamaal");
        File f4=new File("Golmaal");
        File f5=new File("hulchul");

        dr2.addFilesystem(f1);
        dr2.addFilesystem(f2);

        dr3.addFilesystem(f3);
        dr3.addFilesystem(f4);
        dr3.addFilesystem(f5);



        dr.addFilesystem(dr2);
        dr.addFilesystem(dr3);

        dr.ls();
    }
}
