package bai1;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    private static PhoneBookManager phoneBookManager;
    public static void main(String[] args) throws IOException {
        phoneBookManager = new PhoneBookManager();
        Scanner scanner = new Scanner(System.in);
        phoneBookManager.add(new Phonebook("1234","3","sdsa","dfd","dfdfd"));
        phoneBookManager.add(new Phonebook("12348854","3","sdsa","dfd","dfdfd"));
        phoneBookManager.add(new Phonebook("1224334","3","sdsa","dfd","dfdfd"));
        phoneBookManager.add(new Phonebook("1343234","3","sdsa","dfd","dfdfd"));
        phoneBookManager.add(new Phonebook("1245234","3","sdsa","dfd","dfdfd"));

        int input;
        do {
            System.out.println("Nhập 0 để thoát ra : ");
            System.out.println("Nhập 1 để nhập vào học sinh mới: ");
            System.out.println("Nhập 2 để in ra: ");
            System.out.println("Nhập 3 để tìm kiếm : ");
            System.out.println("Nhập 4 đê xóa : ");
            System.out.println("Nhập 5 để sưa: ");
            System.out.println("Nhập 6 để  tìm: ");
            System.out.println("Nhập 7 in csv: ");
            System.out.println("nhập 8 đọc từ csv");
            input = scanner.nextInt();
            if (input > 0 && input < 9) {
                switch (input) {
                    case 1:
                        System.out.println("Nhập số điện thoại: ");
                        scanner.nextLine();
                        String phoneNumber = scanner.nextLine();
                        System.out.println(("Nhập group: "));
                        String group = scanner.nextLine();
                        System.out.println("Nhập tên: ");
                        String fullName = scanner.nextLine();
                        System.out.println("Nhập giới tính ");
                        String sex = scanner.nextLine();
                        System.out.println("Nhập vào địa chỉ: ");
                        String address = scanner.nextLine();
//                        System.out.println("Nhập tên học sinh: ");
//                        String gmail= scanner.nextLine();

                        phoneBookManager.add(new Phonebook(phoneNumber,group,fullName,sex,address));
                        System.out.println(">>>>>>>>>>>gà nhất tem >>>>>>>>>");
                        break;
                    case 2:
                        phoneBookManager.print();
                        break;
                    case 3:
                        System.out.println("Nhập vào tên hoặc số bạn muốn tìm: ");
                        scanner.nextLine();
                        String idToSearch = scanner.nextLine();
                        phoneBookManager.findName(idToSearch);
                        phoneBookManager.find(idToSearch);
                        break;
                    case 4:
                        System.out.println("Nhập vào tên hoặc số bạn muốn xóa: ");
                        scanner.nextLine();
                        String idDelete = scanner.nextLine();
                       phoneBookManager.delete(idDelete);
                        break;
                    case 5:
                        System.out.println("nhập tên hoặc số bạn muốn sửa ");
                        scanner.nextLine();
                        String idToEdit = scanner.nextLine();
                        if (phoneBookManager.find(idToEdit)>-1&&phoneBookManager.findName(idToEdit)>-1) {
                            System.out.println("Nhập số điện thoại: ");
                            scanner.nextLine();
                            String phoneNumber1 = scanner.nextLine();
                            System.out.println(("Nhập group: "));
                            String group1 = scanner.nextLine();
                            System.out.println("Nhập tên: ");
                            String fullName1 = scanner.nextLine();
                            System.out.println("Nhập giới tính ");
                            String sex1 = scanner.nextLine();
                            System.out.println("Nhập vào địa chỉ: ");
                            String address1 = scanner.nextLine();

                           Phonebook phonebook=new Phonebook(phoneNumber1,group1,fullName1,sex1,address1);
                            phoneBookManager.edit(idToEdit, phonebook);
                        }
                        break;
                    case 6:
                        System.out.println("nhập tên hoặc số bạn cần tìm: ");
                        scanner.nextLine();
                        String namefint = scanner.nextLine();
                        if (phoneBookManager.find(namefint)!=-1&&phoneBookManager.findName(namefint)!=-1){
                            System.out.println(phoneBookManager.listPhonebook.get(phoneBookManager.find(namefint)));
                            System.out.println(phoneBookManager.listPhonebook.get(phoneBookManager.findName(namefint)));
                        }
                        break;
                    case 7:

                      phoneBookManager.writercsv();
                        break;
                    case 8:
                       phoneBookManager.readerCsv();
                        break;

                }
            }
        }while (input != 0);
    }
}
