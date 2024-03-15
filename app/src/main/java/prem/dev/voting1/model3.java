package prem.dev.voting1;

import androidx.annotation.Nullable;

import com.bumptech.glide.load.model.Model;

public class model3 implements Model {
    String feed,cname,cage,caddress,cemail,cbirthday,cpartycode,cpartyname,isCandidate,cisEnabled,cgender;
String cAadharCardBack,cBirthCertificate,cAadharCardFront,cleaving,mani,cPhoto,cid;

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getcPhoto() {
        return cPhoto;
    }

    public void setcPhoto(String cPhoto) {
        this.cPhoto = cPhoto;
    }

    public String getcAadharCardBack() {
        return cAadharCardBack;
    }

    public void setcAadharCardBack(String cAadharCardBack) {
        this.cAadharCardBack = cAadharCardBack;
    }

    public String getcBirthCertificate() {
        return cBirthCertificate;
    }

    public void setcBirthCertificate(String cBirthCertificate) {
        this.cBirthCertificate = cBirthCertificate;
    }

    public String getcAadharCardFront() {
        return cAadharCardFront;
    }

    public void setcAadharCardFront(String cAadharCardFront) {
        this.cAadharCardFront = cAadharCardFront;
    }

    public String getCleaving() {
        return cleaving;
    }

    public void setCleaving(String cleaving) {
        this.cleaving = cleaving;
    }

    public String getMani() {
        return mani;
    }

    public void setMani(String mani) {
        this.mani = mani;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCage() {
        return cage;
    }

    public void setCage(String cage) {
        this.cage = cage;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCbirthday() {
        return cbirthday;
    }

    public void setCbirthday(String cbirthday) {
        this.cbirthday = cbirthday;
    }

    public String getCpartycode() {
        return cpartycode;
    }

    public void setCpartycode(String cpartycode) {
        this.cpartycode = cpartycode;
    }

    public String getCpartyname() {
        return cpartyname;
    }

    public void setCpartyname(String cpartyname) {
        this.cpartyname = cpartyname;
    }

    public String getIsCandidate() {
        return isCandidate;
    }

    public void setIsCandidate(String isCandidate) {
        this.isCandidate = isCandidate;
    }

    public String getCisEnabled() {
        return cisEnabled;
    }

    public void setCisEnabled(String cisEnabled) {
        this.cisEnabled = cisEnabled;
    }

    public String getCgender() {
        return cgender;
    }

    public void setCgender(String cgender) {
        this.cgender = cgender;
    }

    public model3(){};



    @Override
    public boolean isEquivalentTo(@Nullable Object other) {
        return false;
    }
}