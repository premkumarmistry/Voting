package prem.dev.voting1;

import androidx.annotation.Nullable;

import com.bumptech.glide.load.model.Model;

public class User implements Model {
    private String voted;
    private String Cisvoter;
    private String id;
    private String isvoter;
    private String candidate;
    private String VisCandidate;
    private String mani;

    public String getMani() {
        return mani;
    }

    public void setMani(String mani) {
        this.mani = mani;
    }

    public String getVisCandidate() {
        return VisCandidate;
    }

    public void setVisCandidate(String visCandidate) {
        VisCandidate = visCandidate;
    }

    public String getCisvoter() {
        return Cisvoter;
    }

    public void setCisvoter(String cisvoter) {
        Cisvoter = cisvoter;
    }

    private String name;
    private String email;
    private String isEnabled;
    private String address;
    private String image;
    private String pdf;

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public String getIsvoter() {
        return isvoter;
    }

    public void setIsvoter(String isvoter) {
        this.isvoter = isvoter;
    }

    private String age;
    private String birthday;
    private String gender;
    private String mobile;
    private String AadharCard;
    private String AadharCardFront;
    private String AadharCardBack;
    private String BirthCertificate;
    private String leaving;
    private String Photo;

    private String cVoted;
    private String cname;
    private String cemail;
    private String cisEnabled;
    private String caddress;
    private String cimage;
    private String cpdf;
    private String cage;
    private String cbirthday;
    private String cgender;
    private String cmobile;
    private String cAadharCard;
    private String cAadharCardFront;
    private String cAadharCardBack;
    private String cBirthCertificate;
    private String cleaving;
    private String cpartyname;
    private String cpartycode;
    public String getcVoted() {
        return cVoted;
    }

    public String getCpartyname() {
        return cpartyname;
    }

    public void setCpartyname(String cpartyname) {
        this.cpartyname = cpartyname;
    }

    public String getCpartycode() {
        return cpartycode;
    }

    public void setCpartycode(String cpartycode) {
        this.cpartycode = cpartycode;
    }

    public void setcVoted(String cVoted) {
        this.cVoted = cVoted;
    }

    public String getIsCandidate() {
        return isCandidate;
    }

    public void setIsCandidate(String isCandidate) {
        this.isCandidate = isCandidate;
    }

    private String cPhoto;
    private String isCandidate ;

    public String getVoted() {
        return voted;
    }

    public void setVoted(String voted) {
        this.voted = voted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCisEnabled() {
        return cisEnabled;
    }

    public void setCisEnabled(String cisEnabled) {
        this.cisEnabled = cisEnabled;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCimage() {
        return cimage;
    }

    public void setCimage(String cimage) {
        this.cimage = cimage;
    }

    public String getCpdf() {
        return cpdf;
    }

    public void setCpdf(String cpdf) {
        this.cpdf = cpdf;
    }

    public String getCage() {
        return cage;
    }

    public void setCage(String cage) {
        this.cage = cage;
    }

    public String getCbirthday() {
        return cbirthday;
    }

    public void setCbirthday(String cbirthday) {
        this.cbirthday = cbirthday;
    }

    public String getCgender() {
        return cgender;
    }

    public void setCgender(String cgender) {
        this.cgender = cgender;
    }

    public String getCmobile() {
        return cmobile;
    }

    public void setCmobile(String cmobile) {
        this.cmobile = cmobile;
    }

    public String getcAadharCard() {
        return cAadharCard;
    }

    public void setcAadharCard(String cAadharCard) {
        this.cAadharCard = cAadharCard;
    }

    public String getcAadharCardFront() {
        return cAadharCardFront;
    }

    public void setcAadharCardFront(String cAadharCardFront) {
        this.cAadharCardFront = cAadharCardFront;
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

    public String getCleaving() {
        return cleaving;
    }

    public void setCleaving(String cleaving) {
        this.cleaving = cleaving;
    }

    public String getcPhoto() {
        return cPhoto;
    }

    public void setcPhoto(String cPhoto) {
        this.cPhoto = cPhoto;
    }

    public String getPhoto() {
        return Photo;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getAge() {
        return age;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAadharCard() {
        return AadharCard;
    }

    public String getBirthCertificate() {
        return BirthCertificate;
    }

    public String getLeaving() {
        return leaving;
    }

    public User(){

    }

    public String getAadharCardFront() {
        return AadharCardFront;
    }

    public String getAadharCardBack() {
        return AadharCardBack;
    }

    @Override
    public boolean isEquivalentTo(@Nullable Object other) {
        return false;
    }

  /*  public User(String name, String email, String isEnabled, String address, String image, String pdf) {
        this.name = name;
        this.email = email;
        this.isEnabled = isEnabled;
        this.address = address;
        this.image = image;
        this.pdf = pdf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }*/
}
