
package com.google.api.ads.adwords.jaxws.v201409.ch;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomerSyncError.Reason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CustomerSyncError.Reason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INVALID_CAMPAIGN_ID"/>
 *     &lt;enumeration value="INVALID_FEED_ID"/>
 *     &lt;enumeration value="INVALID_DATE_RANGE"/>
 *     &lt;enumeration value="TOO_MANY_CHANGES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CustomerSyncError.Reason")
@XmlEnum
public enum CustomerSyncErrorReason {


    /**
     * 
     *                 The request attempted to access a campaign that either does not
     *                 exist or belongs to a different account.
     *               
     * 
     */
    INVALID_CAMPAIGN_ID,

    /**
     * 
     *                 The request attempted to access a feed that either does not
     *                 exist or belongs to a different account.
     *               
     * 
     */
    INVALID_FEED_ID,

    /**
     * 
     *                 The request asked for an invalid date range
     *               
     * 
     */
    INVALID_DATE_RANGE,

    /**
     * 
     *                 There have been too many changes to sync the campaign over the requested
     *                 date/time range.  To avoid this error, try specifying a smaller date/time range.
     *                 If this does not work, you should assume that everything has changed and
     *                 retrieve the objects using their respective services.
     *               
     * 
     */
    TOO_MANY_CHANGES;

    public String value() {
        return name();
    }

    public static CustomerSyncErrorReason fromValue(String v) {
        return valueOf(v);
    }

}
