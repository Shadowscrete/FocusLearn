package com.csit321g6g5.treeidiots.focuslearn.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "content_page")
public class ContentPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "page_id")
    private Long pageId;

    @Column(name = "module_id")
    private Long moduleId;

    @Column(name = "heading")
    private String heading;

    @Column(name = "body_text")
    private String bodyText;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "sequence_order")
    private Integer sequenceOrder;

    public ContentPage() {}

    public Long getPageId() { return pageId; }
    public void setPageId(Long pageId) { this.pageId = pageId; }
    public Long getModuleId() { return moduleId; }
    public void setModuleId(Long moduleId) { this.moduleId = moduleId; }
    public String getHeading() { return heading; }
    public void setHeading(String heading) { this.heading = heading; }
    public String getBodyText() { return bodyText; }
    public void setBodyText(String bodyText) { this.bodyText = bodyText; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public Integer getSequenceOrder() { return sequenceOrder; }
    public void setSequenceOrder(Integer sequenceOrder) { this.sequenceOrder = sequenceOrder; }
}