package cn.dcy.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.ReadListener;

public class TestRead {
    public static void main(String[] args) {
        String file = "D:\\javaExploit\\e\\01.xlsx";
        EasyExcel.read(file, UserData.class, new ExcelListener()).sheet().doRead();
    }
}
