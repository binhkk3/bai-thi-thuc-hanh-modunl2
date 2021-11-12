package bai1;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class PhoneBookManager implements Manager<Phonebook> {
    public ArrayList<Phonebook> listPhonebook;

    public PhoneBookManager(ArrayList<Phonebook> arrayList) {
        this. listPhonebook = arrayList;
    }

    public PhoneBookManager() {
        listPhonebook = new ArrayList<>();

    }
    @Override
    public void add(Phonebook phonebook) {
        listPhonebook.add(phonebook);
    }

    @Override
    public int findName(String name) {
        boolean check  =  true;
        for (int i = 0; i < listPhonebook.size(); i++) {
            if (listPhonebook.get(i).getFullName().contains(name.toLowerCase(Locale.ROOT))){
                System.out.println("số điện thoại có tên: "+name+" có thông tin là"+listPhonebook.get(i));
//                check = false;
                return i;
            }
        }
//        if(check = true){
//            System.out.println("không tìm thấy tên bạn muốn tìm: ");
//        }
        return -1;
    }
    public void writercsv () throws IOException {
        FileWriter fileWriter = new FileWriter("fileStaff.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "Số điện thoại,group,Tên,giới tính,địa chỉ";
        for (int i = 0; i < listPhonebook.size(); i++) {
            str += "\n" + listPhonebook.get(i).getPhoneNumber() +","+listPhonebook.get(i).getGroup()+listPhonebook.get(i).getFullName()+
                    listPhonebook.get(i).getSex()+listPhonebook.get(i).getAddress();
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
    }
    public static void readerCsv() throws IOException {
        File file =new File("E:\\java\\untitled7\\src\\fileStaff.csv");
        FileReader fileReader =new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(new File("demo.txt")));
        String str ="";
        String line;
        while ((line = bufferedReader.readLine()) != null){
            str = str + line;
        }
        System.out.println(str);
    }

    @Override
    public int find(String phoneNumber) {
        boolean check  =  true;
        for (int i = 0; i < listPhonebook.size(); i++) {
            if (listPhonebook.get(i).getPhoneNumber().contains(phoneNumber.toLowerCase(Locale.ROOT))){
                System.out.println("số : "+phoneNumber+" có thông tin là"+listPhonebook.get(i));
                check = false;
                return i;
            }
        }
//        if(check = true){
            //System.out.println("không tìm thấy số bạn muốn tìm: ");
//        }
        return -1;
    }

    @Override
    public void delete(String phoneNumber) {
        int index = find(phoneNumber);
        int index2 = findName(phoneNumber);
        if (index == -1&&index2==-1){
            System.out.println("Không có sô bạn muốn xóa: ");
        }
        else {
            listPhonebook.remove(index);
        }

    }

    @Override
    public void edit(String phoneNumber, Phonebook phonebook) {
        int index = find(phoneNumber);
        int index2 = findName(phoneNumber);
        if (index == -1&&  index2==-1){
            System.out.println("Không có sô bạn muốn xóa: ");
        }
        else {
            listPhonebook.add(index,phonebook);
        }

    }

    @Override
    public void print() {
        for (int i = 0; i < listPhonebook.size(); i++) {
            System.out.println(listPhonebook.get(i));
        }
        System.out.println(">>>>@@@@@@@@@@@@@@@@@>>>>");

    }
}
