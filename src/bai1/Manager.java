package bai1;public interface Manager<T> {
    void add(T t);
    int findName (String name);
    int find(String phoneNumber);
    void delete (String phoneNumber);
    void edit (String phoneNumber ,T t);
    void print ();
}
