package cn.dcy.easyexcel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class TestWrite {
    public static void main(String[] args) {
        List<UserData> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            UserData userData = new UserData();
            userData.setUid(i);
            userData.setUsername("jdf"+i);
            list.add(userData);
        }
        String fileName = "D:\\javaExploit\\e\\01.xlsx";
        EasyExcel.write(fileName,UserData.class).sheet("用户信息").doWrite(list);
    }
}
