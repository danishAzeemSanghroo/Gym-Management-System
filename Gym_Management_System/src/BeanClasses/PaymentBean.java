/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanClasses;

import java.util.Date;

/**
 *
 * @author Danish
 */
public class PaymentBean {

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Date getPaymentMonth() {
        return paymentMonth;
    }

    public void setPaymentMonth(Date paymentMonth) {
        this.paymentMonth = paymentMonth;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }




    int memberId;
    int paymentId;
    Date paymentMonth;
    String paymentAmount;
    String remarks;
}
