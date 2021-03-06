/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.sync.v1.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class SyncStream extends Resource {
    private static final long serialVersionUID = 240146789601739L;

    /**
     * Create a SyncStreamFetcher to execute fetch.
     *
     * @param pathServiceSid The SID of the Sync Service with the Sync Stream
     *                       resource to fetch
     * @param pathSid The SID of the Stream resource to fetch
     * @return SyncStreamFetcher capable of executing the fetch
     */
    public static SyncStreamFetcher fetcher(final String pathServiceSid,
                                            final String pathSid) {
        return new SyncStreamFetcher(pathServiceSid, pathSid);
    }

    /**
     * Create a SyncStreamDeleter to execute delete.
     *
     * @param pathServiceSid The SID of the Sync Service with the Sync Stream
     *                       resource to delete
     * @param pathSid The SID of the Stream resource to delete
     * @return SyncStreamDeleter capable of executing the delete
     */
    public static SyncStreamDeleter deleter(final String pathServiceSid,
                                            final String pathSid) {
        return new SyncStreamDeleter(pathServiceSid, pathSid);
    }

    /**
     * Create a SyncStreamCreator to execute create.
     *
     * @param pathServiceSid The SID of the Sync Service to create the new Stream in
     * @return SyncStreamCreator capable of executing the create
     */
    public static SyncStreamCreator creator(final String pathServiceSid) {
        return new SyncStreamCreator(pathServiceSid);
    }

    /**
     * Create a SyncStreamUpdater to execute update.
     *
     * @param pathServiceSid The SID of the Sync Service with the Sync Stream
     *                       resource to update
     * @param pathSid The SID of the Stream resource to update
     * @return SyncStreamUpdater capable of executing the update
     */
    public static SyncStreamUpdater updater(final String pathServiceSid,
                                            final String pathSid) {
        return new SyncStreamUpdater(pathServiceSid, pathSid);
    }

    /**
     * Create a SyncStreamReader to execute read.
     *
     * @param pathServiceSid The SID of the Sync Service with the Stream resources
     *                       to read
     * @return SyncStreamReader capable of executing the read
     */
    public static SyncStreamReader reader(final String pathServiceSid) {
        return new SyncStreamReader(pathServiceSid);
    }

    /**
     * Converts a JSON String into a SyncStream object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return SyncStream object represented by the provided JSON
     */
    public static SyncStream fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, SyncStream.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a SyncStream object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return SyncStream object represented by the provided JSON
     */
    public static SyncStream fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, SyncStream.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String uniqueName;
    private final String accountSid;
    private final String serviceSid;
    private final URI url;
    private final Map<String, String> links;
    private final ZonedDateTime dateExpires;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String createdBy;

    @JsonCreator
    private SyncStream(@JsonProperty("sid")
                       final String sid,
                       @JsonProperty("unique_name")
                       final String uniqueName,
                       @JsonProperty("account_sid")
                       final String accountSid,
                       @JsonProperty("service_sid")
                       final String serviceSid,
                       @JsonProperty("url")
                       final URI url,
                       @JsonProperty("links")
                       final Map<String, String> links,
                       @JsonProperty("date_expires")
                       final String dateExpires,
                       @JsonProperty("date_created")
                       final String dateCreated,
                       @JsonProperty("date_updated")
                       final String dateUpdated,
                       @JsonProperty("created_by")
                       final String createdBy) {
        this.sid = sid;
        this.uniqueName = uniqueName;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.url = url;
        this.links = links;
        this.dateExpires = DateConverter.iso8601DateTimeFromString(dateExpires);
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.createdBy = createdBy;
    }

    /**
     * Returns The unique string that identifies the resource.
     *
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns An application-defined string that uniquely identifies the resource.
     *
     * @return An application-defined string that uniquely identifies the resource
     */
    public final String getUniqueName() {
        return this.uniqueName;
    }

    /**
     * Returns The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The SID of the Sync Service that the resource is associated with.
     *
     * @return The SID of the Sync Service that the resource is associated with
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The absolute URL of the Message Stream resource.
     *
     * @return The absolute URL of the Message Stream resource
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The URLs of the Stream's nested resources.
     *
     * @return The URLs of the Stream's nested resources
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the Message Stream expires.
     *
     * @return The ISO 8601 date and time in GMT when the Message Stream expires
     */
    public final ZonedDateTime getDateExpires() {
        return this.dateExpires;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the resource was created.
     *
     * @return The ISO 8601 date and time in GMT when the resource was created
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the resource was last updated.
     *
     * @return The ISO 8601 date and time in GMT when the resource was last updated
     */
    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The Identity of the Stream's creator.
     *
     * @return The Identity of the Stream's creator
     */
    public final String getCreatedBy() {
        return this.createdBy;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SyncStream other = (SyncStream) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(uniqueName, other.uniqueName) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(serviceSid, other.serviceSid) &&
               Objects.equals(url, other.url) &&
               Objects.equals(links, other.links) &&
               Objects.equals(dateExpires, other.dateExpires) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(createdBy, other.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            uniqueName,
                            accountSid,
                            serviceSid,
                            url,
                            links,
                            dateExpires,
                            dateCreated,
                            dateUpdated,
                            createdBy);
    }
}