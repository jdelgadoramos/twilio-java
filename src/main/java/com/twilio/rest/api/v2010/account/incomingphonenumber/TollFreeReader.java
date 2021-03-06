/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.incomingphonenumber;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class TollFreeReader extends Reader<TollFree> {
    private String pathAccountSid;
    private Boolean beta;
    private String friendlyName;
    private com.twilio.type.PhoneNumber phoneNumber;
    private String origin;

    /**
     * Construct a new TollFreeReader.
     */
    public TollFreeReader() {
    }

    /**
     * Construct a new TollFreeReader.
     *
     * @param pathAccountSid The SID of the Account that created the resources to
     *                       read
     */
    public TollFreeReader(final String pathAccountSid) {
        this.pathAccountSid = pathAccountSid;
    }

    /**
     * Whether to include phone numbers new to the Twilio platform. Can be: `true`
     * or `false` and the default is `true`..
     *
     * @param beta Whether to include new phone numbers
     * @return this
     */
    public TollFreeReader setBeta(final Boolean beta) {
        this.beta = beta;
        return this;
    }

    /**
     * A string that identifies the resources to read..
     *
     * @param friendlyName A string that identifies the resources to read
     * @return this
     */
    public TollFreeReader setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The phone numbers of the IncomingPhoneNumber resources to read. You can
     * specify partial numbers and use '*' as a wildcard for any digit..
     *
     * @param phoneNumber The phone numbers of the resources to read
     * @return this
     */
    public TollFreeReader setPhoneNumber(final com.twilio.type.PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * The phone numbers of the IncomingPhoneNumber resources to read. You can
     * specify partial numbers and use '*' as a wildcard for any digit..
     *
     * @param phoneNumber The phone numbers of the resources to read
     * @return this
     */
    public TollFreeReader setPhoneNumber(final String phoneNumber) {
        return setPhoneNumber(Promoter.phoneNumberFromString(phoneNumber));
    }

    /**
     * Whether to include phone numbers based on their origin. Can be: `twilio` or
     * `hosted`. By default, phone numbers of all origin are included..
     *
     * @param origin Include phone numbers based on their origin. By default, phone
     *               numbers of all origin are included.
     * @return this
     */
    public TollFreeReader setOrigin(final String origin) {
        this.origin = origin;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return TollFree ResourceSet
     */
    @Override
    public ResourceSet<TollFree> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return TollFree ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<TollFree> firstPage(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/IncomingPhoneNumbers/TollFree.json"
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the target page from the Twilio API.
     *
     * @param targetUrl API-generated URL for the requested results page
     * @param client TwilioRestClient with which to make the request
     * @return TollFree ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<TollFree> getPage(final String targetUrl, final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<TollFree> nextPage(final Page<TollFree> page,
                                   final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.API.toString())
        );
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the previous page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Previous Page
     */
    @Override
    public Page<TollFree> previousPage(final Page<TollFree> page,
                                       final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.API.toString())
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of TollFree Resources for a given request.
     *
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<TollFree> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("TollFree read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
           throw new ApiException(restException);
        }

        return Page.fromJson(
            "incoming_phone_numbers",
            response.getContent(),
            TollFree.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     *
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (beta != null) {
            request.addQueryParam("Beta", beta.toString());
        }

        if (friendlyName != null) {
            request.addQueryParam("FriendlyName", friendlyName);
        }

        if (phoneNumber != null) {
            request.addQueryParam("PhoneNumber", phoneNumber.toString());
        }

        if (origin != null) {
            request.addQueryParam("Origin", origin);
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}