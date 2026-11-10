package com.csit321g6g5.treeidiots.focuslearn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "accessibility_profiles")
public class AccessibilityProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profileID;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "userID", nullable = false, unique = true)
    private User user;

    private String fontFamily;
    private Integer fontSize;
    private String colorTheme;
    private Boolean focusModeDefault = false;
    private Float ttsSpeed = 1.0f;
    private Float lineSpacing = 1.0f;
    private Float letterSpacing = 0.0f;

    public Integer getProfileID() {
        return profileID;
    }

    public void setProfileID(Integer profileID) {
        this.profileID = profileID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public String getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(String colorTheme) {
        this.colorTheme = colorTheme;
    }

    public Boolean getFocusModeDefault() {
        return focusModeDefault;
    }

    public void setFocusModeDefault(Boolean focusModeDefault) {
        this.focusModeDefault = focusModeDefault;
    }

    public Float getTtsSpeed() {
        return ttsSpeed;
    }

    public void setTtsSpeed(Float ttsSpeed) {
        this.ttsSpeed = ttsSpeed;
    }

    public Float getLineSpacing() {
        return lineSpacing;
    }

    public void setLineSpacing(Float lineSpacing) {
        this.lineSpacing = lineSpacing;
    }

    public Float getLetterSpacing() {
        return letterSpacing;
    }

    public void setLetterSpacing(Float letterSpacing) {
        this.letterSpacing = letterSpacing;
    }
}
