package com.example.abbinizar.classonline;

import android.os.Parcel;
import android.os.Parcelable;

public class person implements Parcelable {
    private String nama;
    private int age;
    private String email;
    private String City;

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama=nama;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeInt(this.age);
        dest.writeString(this.email);
        dest.writeString(this.City);
    }

    public person() {
    }

    protected person(Parcel in) {
        this.nama = in.readString();
        this.age = in.readInt();
        this.email = in.readString();
        this.City = in.readString();
    }

    public static final Parcelable.Creator<person> CREATOR = new Parcelable.Creator<person>() {
        @Override
        public person createFromParcel(Parcel source) {
            return new person(source);
        }

        @Override
        public person[] newArray(int size) {
            return new person[size];
        }
    };
}
