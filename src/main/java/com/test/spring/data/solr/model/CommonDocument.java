package com.test.spring.data.solr.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "search_common_info")
public class CommonDocument {

    @Id
    @Indexed(name = "id", type = "string")
    private String id;

    @Indexed(name = "object_id", type = "string")
    private String objectId;

    @Indexed(name = "document_type", type = "string")
    private String documentType;

    @Indexed(name = "author", type = "string")
    private String author;

    @Indexed(name = "department", type = "string")
    private String department;

    @Indexed(name = "barcode", type = "string")
    private String barcode;

    @Indexed(name = "reg_date", type = "date")
    private Date regDate;

    @Indexed(name = "reg_number", type = "string")
    private String regNumber;

    @Indexed(name = "state", type = "string")
    private String state;

    @Indexed(name = "identifier", type = "string")
    private String identifier;

    @Indexed(name = "attachment_id", type = "string")
    private String attachmentId;

    @Indexed(name = "attachment_name", type = "string")
    private String attachmentName;

    @Indexed(name = "doc_summary", type = "string")
    private String docSummary;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentIdAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getDocSummary() {
        return docSummary;
    }

    public void setDocSummary(String docSummary) {
        this.docSummary = docSummary;
    }

    @Override
    public String toString() {
        return "ContractDocument{" +
                "id='" + id + '\'' +
                ", objectId='" + objectId + '\'' +
                ", documentType='" + documentType + '\'' +
                ", author='" + author + '\'' +
                ", department='" + department + '\'' +
                ", barcode='" + barcode + '\'' +
                ", regDate=" + regDate +
                ", regNumber='" + regNumber + '\'' +
                ", state='" + state + '\'' +
                ", identifier='" + identifier + '\'' +
                ", attachmentId='" + attachmentId + '\'' +
                ", attachmentName='" + attachmentName + '\'' +
                ", docSummary='" + docSummary + '\'' +
                '}';
    }

}
