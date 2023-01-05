package com.virnanda.candiindonesia;

import android.os.Parcel;
import android.os.Parcelable;

public class Candi implements Parcelable {
    private String nama, detail;
    private int photo;

    protected Candi(String nama, String detail, int photo) {
        this.nama = nama;
        this.detail = detail;
        this.photo = photo;
    }

    protected Candi(Parcel in) {
        nama = in.readString();
        detail = in.readString();
        photo = in.readInt();
    }

    public static final Creator<Candi> CREATOR = new Creator<Candi>() {
        @Override
        public Candi createFromParcel(Parcel in) {
            return new Candi(in);
        }

        @Override
        public Candi[] newArray(int size) {
            return new Candi[size];
        }
    };

    public Candi() {

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(detail);
        parcel.writeInt(photo);
    }
}

