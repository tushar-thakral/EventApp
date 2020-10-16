package com.example.hp.appname;

import java.io.Serializable;
/**
 * Created by hp on 08-Jun-18.
 */

public class Mobile implements Serializable {

    private String mName;
    private String mCompanyName;
    private String mOperatingSystem;
    private String mProcessor;
    private String mRam;
    private String mRom;
    private String mFrontCamera;
    private String mBackCamera;
    private String mScreenSize;
    private String mBattery;
    private String mUrl;

    public String getName() {
        return mName;
    }
    public void setName(String mName) {
        this.mName = mName;
    }
    public String getCompanyName() {
        return mCompanyName;
    }
    public void setCompanyName(String mCompanyName) {
        this.mCompanyName = mCompanyName;
    }
    public String getOperatingSystem() {
        return mOperatingSystem;
    }
    public void setOperatingSystem(String mOperatingSystem) {
        this.mOperatingSystem = mOperatingSystem;
    }
    public String getProcessor() {
        return mProcessor;
    }
    public void setProcessor(String mProcessor) {
        this.mProcessor = mProcessor;
    }
    public String getRam() {
        return mRam;
    }
    public void setRam(String mRam) {
        this.mRam = mRam;
    }
    public String getRom() {
        return mRom;
    }
    public void setRom(String mRom) {
        this.mRom = mRom;
    }
    public String getFrontCamera() {
        return mFrontCamera;
    }
    public void setFrontCamera(String mFrontCamera) {
        this.mFrontCamera = mFrontCamera;
    }
    public String getBackCamera() {
        return mBackCamera;
    }
    public void setBackCamera(String mBackCamera) {
        this.mBackCamera = mBackCamera;
    }
    public String getScreenSize() {
        return mScreenSize;
    }
    public void setScreenSize(String mScreenSize) {
        this.mScreenSize = mScreenSize;
    }
    public String getBattery() {
        return mBattery;
    }
    public void setBattery(String mBattery) {
        this.mBattery = mBattery;
    }
    public String getUrl() {
        return mUrl;
    }
    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }

}
