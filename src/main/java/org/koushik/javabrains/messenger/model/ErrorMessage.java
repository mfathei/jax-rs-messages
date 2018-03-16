/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.koushik.javabrains.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mahdy
 */
@XmlRootElement
public class ErrorMessage {

    private long errorCode;
    private String message;
    private String documentation;

    public ErrorMessage() {
    }

    public ErrorMessage(long errorCode, String message, String documentation) {
        this.errorCode = errorCode;
        this.message = message;
        this.documentation = documentation;
    }

    public long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(long errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

}
