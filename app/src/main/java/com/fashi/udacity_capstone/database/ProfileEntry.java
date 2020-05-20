package com.fashi.udacity_capstone.database;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "measurement")
public class ProfileEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String firstName;
    private String lastName;
    private String contact;
    private String topLength;
    private String chest;
    private String belly;
    private String shoulder;
    private String sleeveLength;
    private String roundSleeve;
    private String wrist;
    private String neck;
    private String trouserLength;
    private String waist;
    private String hip;
    private String lap;
    private String kneel;
    private String down;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTopLength() {
        return topLength;
    }

    public void setTopLength(String topLength) {
        this.topLength = topLength;
    }

    public String getChest() {
        return chest;
    }

    public void setChest(String chest) {
        this.chest = chest;
    }

    public String getBelly() {
        return belly;
    }

    public void setBelly(String belly) {
        this.belly = belly;
    }

    public String getShoulder() {
        return shoulder;
    }

    public void setShoulder(String shoulder) {
        this.shoulder = shoulder;
    }

    public String getSleeveLength() {
        return sleeveLength;
    }

    public void setSleeveLength(String sleeveLength) {
        this.sleeveLength = sleeveLength;
    }

    public String getRoundSleeve() {
        return roundSleeve;
    }

    public void setRoundSleeve(String roundSleeve) {
        this.roundSleeve = roundSleeve;
    }

    public String getWrist() {
        return wrist;
    }

    public void setWrist(String wrist) {
        this.wrist = wrist;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    public String getTrouserLength() {
        return trouserLength;
    }

    public void setTrouserLength(String trouserLength) {
        this.trouserLength = trouserLength;
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    public String getHip() {
        return hip;
    }

    public void setHip(String hip) {
        this.hip = hip;
    }

    public String getLap() {
        return lap;
    }

    public void setLap(String lap) {
        this.lap = lap;
    }

    public String getKneel() {
        return kneel;
    }

    public void setKneel(String kneel) {
        this.kneel = kneel;
    }

    public String getDown() {
        return down;
    }

    public void setDown(String down) {
        this.down = down;
    }

    public ProfileEntry(int id, String firstName, String lastName, String contact, String topLength, String chest, String belly, String shoulder, String sleeveLength, String roundSleeve, String wrist, String neck, String trouserLength, String waist, String hip, String lap, String kneel, String down) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.topLength = topLength;
        this.chest = chest;
        this.belly = belly;
        this.shoulder = shoulder;
        this.sleeveLength = sleeveLength;
        this.roundSleeve = roundSleeve;
        this.wrist = wrist;
        this.neck = neck;
        this.trouserLength = trouserLength;
        this.waist = waist;
        this.hip = hip;
        this.lap = lap;
        this.kneel = kneel;
        this.down = down;
    }

    @Ignore
    public ProfileEntry(String firstName, String lastName, String contact, String topLength, String chest, String belly, String shoulder, String sleeveLength, String roundSleeve, String wrist, String neck, String trouserLength, String waist, String hip, String lap, String kneel, String down) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.topLength = topLength;
        this.chest = chest;
        this.belly = belly;
        this.shoulder = shoulder;
        this.sleeveLength = sleeveLength;
        this.roundSleeve = roundSleeve;
        this.wrist = wrist;
        this.neck = neck;
        this.trouserLength = trouserLength;
        this.waist = waist;
        this.hip = hip;
        this.lap = lap;
        this.kneel = kneel;
        this.down = down;
    }
}
