package com.unicomg.maher.a.photo;

import android.net.Uri;

public class PhotoModel {
   private Uri officephoto;
    public PhotoModel(Uri officephoto) {
      this.officephoto=officephoto;
    }


    public Uri getOfficephoto() {
        return officephoto;
    }

    public void setOfficephoto(Uri officephoto) {
        this.officephoto = officephoto;
    }
}
