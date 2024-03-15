package prem.dev.voting1;

import androidx.annotation.Nullable;

import com.bumptech.glide.load.model.Model;

public class model implements Model {
    String cisEnabled;

    String cage,cgender,feed;

    String mani;
    String email,name,cpartyname,cname;
    String image,Photo,cPhoto;

    public String getCage() {
        return cage;
    }

    public void setCage(String cage) {
        this.cage = cage;
    }

    public String getCgender() {
        return cgender;
    }

    public void setCgender(String cgender) {
        this.cgender = cgender;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public String getMani() {
        return mani;
    }

    public void setMani(String mani) {
        this.mani = mani;
    }

    public model(){};
    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return image;
    }

    public String getCisEnabled() {
        return cisEnabled;
    }

    public void setCisEnabled(String cisEnabled) {
        this.cisEnabled = cisEnabled;
    }

    public String getcPhoto() {
        return cPhoto;
    }

    public void setcPhoto(String cPhoto) {
        this.cPhoto = cPhoto;
    }

    public String getCpartyname() {
        return cpartyname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setCpartyname(String cpartyname) {
        this.cpartyname = cpartyname;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }

    public String getPhoto() {
        return Photo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }



    @Override
    public boolean isEquivalentTo(@Nullable Object other) {
        return false;
    }
}