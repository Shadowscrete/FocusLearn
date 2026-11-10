package com.csit321g6g5.treeidiots.focuslearn.dto;

public class AccessibilityProfileRequest {
    private Integer userID;
    private String fontFamily;
    private Integer fontSize;
    private String colorTheme;
    private Boolean focusModeDefault;
    private Float ttsSpeed;
    private Float lineSpacing;
    private Float letterSpacing;

    public Integer getUserID() { return userID; }
    public void setUserID(Integer userID) { this.userID = userID; }
    public String getFontFamily() { return fontFamily; }
    public void setFontFamily(String fontFamily) { this.fontFamily = fontFamily; }
    public Integer getFontSize() { return fontSize; }
    public void setFontSize(Integer fontSize) { this.fontSize = fontSize; }
    public String getColorTheme() { return colorTheme; }
    public void setColorTheme(String colorTheme) { this.colorTheme = colorTheme; }
    public Boolean getFocusModeDefault() { return focusModeDefault; }
    public void setFocusModeDefault(Boolean focusModeDefault) { this.focusModeDefault = focusModeDefault; }
    public Float getTtsSpeed() { return ttsSpeed; }
    public void setTtsSpeed(Float ttsSpeed) { this.ttsSpeed = ttsSpeed; }
    public Float getLineSpacing() { return lineSpacing; }
    public void setLineSpacing(Float lineSpacing) { this.lineSpacing = lineSpacing; }
    public Float getLetterSpacing() { return letterSpacing; }
    public void setLetterSpacing(Float letterSpacing) { this.letterSpacing = letterSpacing; }
}
