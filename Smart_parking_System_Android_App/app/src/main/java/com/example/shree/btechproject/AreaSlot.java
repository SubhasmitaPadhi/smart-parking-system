package com.example.shree.btechproject;

/**
 * Created by user on 1/25/2018.
 */

public class AreaSlot {

    private String  User, Date,Time;
    private int Book_Id,SlotNo,Area,Flag,Duration;

    public AreaSlot(int Book_Id, String User, int SlotNo, String Date, String Time, int Duration, int Area, int Flag) {
        this.Book_Id = Book_Id;
        this.User = User;
        this.SlotNo= SlotNo;
        this.Date=Date;
        this.Time=Time;
        this.Duration = Duration;
        this.Area = Area;
        this.Flag=Flag;
    }
    public int getBook_Id() { return Book_Id; }

    public String getUser() {
        return User;
    }

    public int getSlotNo() { return SlotNo; }

    public String getDate() {
        return Date;
    }

    public String getTime() {
        return Time;
    }

    public int getDuration() { return Duration; }

    public int getArea() {
        return Area;
    }

    public int getFlag() { return Flag; }


}
