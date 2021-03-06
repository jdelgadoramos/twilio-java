/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link SsmlS}
 */
public class SsmlSTest {
    @Test
    public void testElementWithParams() {
        SsmlS elem = new SsmlS.Builder("words").build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<s>words</s>",
            elem.toXml()
        );
    }
}