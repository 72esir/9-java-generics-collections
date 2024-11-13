package com.example.task02;

import javafx.beans.binding.When;

import java.io.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class SavedList<E extends Serializable> extends AbstractList<E> {

    private List<E> list;
    private File file;

    public SavedList(File file) throws IOException {
        if (file.exists()){
            try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
                this.list = (List<E>) objectInputStream.readObject();
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        else{
            this.list = new ArrayList<>();
        }
        this.file = file;
    }

    @Override
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public E set(int index, E element) {
        E val = list.set(index,element);
        changedList();
        return val;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void add(int index, E element) {
        list.add(index,element);
        changedList();
    }

    @Override
    public E remove(int index) {
        E val = list.remove(index);
        changedList();
        return val;
    }

    public void changedList() {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(list);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
