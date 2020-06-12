package com.example.landmarkbook;

import android.graphics.Bitmap;

public class Singleton {

        private Bitmap selectedItem;
        private static Singleton singleton;

        private Singleton(){


        }

        public Bitmap getSelectedItem() {
            return selectedItem;
        }

        public void setSelectedItem(Bitmap selectedItem) {
            this.selectedItem = selectedItem;
        }

        //eğer bir singled nesnem yoksa oluştur, eğer varsa o nesneyi geri gönder.
        public static Singleton getInstance(){
            if (singleton==null){
                singleton=new Singleton();

            }
            return singleton;
        }

}
