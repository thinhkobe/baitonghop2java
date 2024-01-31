package service;

public interface Management <T,E>{
    void display();
    void add(T element);
    void editInfo(E id);
    T findById(E id);

}
