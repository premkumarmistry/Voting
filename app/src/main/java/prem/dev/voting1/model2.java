package prem.dev.voting1;

import androidx.annotation.Nullable;

import com.bumptech.glide.load.model.Model;

public class model2 implements Model {
    String  id,Photo,leaving,BirthCertificate,AadharCardFront,AadharCardBack,address,age,birthday,email,gender,isCandidate,isEnabled,isvoter,name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getLeaving() {
        return leaving;
    }

    public void setLeaving(String leaving) {
        this.leaving = leaving;
    }

    public String getBirthCertificate() {
        return BirthCertificate;
    }

    public void setBirthCertificate(String birthCertificate) {
        BirthCertificate = birthCertificate;
    }

    public String getAadharCardFront() {
        return AadharCardFront;
    }

    public void setAadharCardFront(String aadharCardFront) {
        AadharCardFront = aadharCardFront;
    }

    public String getAadharCardBack() {
        return AadharCardBack;
    }

    public void setAadharCardBack(String aadharCardBack) {
        AadharCardBack = aadharCardBack;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIsCandidate() {
        return isCandidate;
    }

    public void setIsCandidate(String isCandidate) {
        this.isCandidate = isCandidate;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getIsvoter() {
        return isvoter;
    }

    public void setIsvoter(String isvoter) {
        this.isvoter = isvoter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public model2(){};




    @Override
    public boolean isEquivalentTo(@Nullable Object other) {
        return false;
    }
}