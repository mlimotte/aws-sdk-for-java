/*
 * Copyright 2010-2012 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.dynamodb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amazonaws.*;
import com.amazonaws.auth.*;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.handlers.RequestHandler;
import com.amazonaws.http.JsonResponseHandler;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.json.JSONObject;

import com.amazonaws.services.dynamodb.model.*;
import com.amazonaws.services.dynamodb.model.transform.*;


/**
 * Client for accessing AmazonDynamoDB.  All service calls made
 * using this client are blocking, and will not return until the service call
 * completes.
 * <p>
 * <p>
 * Amazon DynamoDB is a fast, highly scalable, highly available,
 * cost-effective non-relational database service. Amazon DynamoDB
 * removes traditional scalability limitations on data storage while
 * maintaining low latency and predictable performance.
 * </p>
 */
public class AmazonDynamoDBClient extends AmazonWebServiceClient implements AmazonDynamoDB {

    /** Provider for AWS credentials. */
    private AWSCredentialsProvider awsCredentialsProvider;    

    /** Long-term credentials used to obtain the session credentials provider */
    private AWSCredentials longTermCredentials;

    private static final Log log = LogFactory.getLog(AmazonDynamoDB.class);

    /**
     * List of exception unmarshallers for all AmazonDynamoDB exceptions.
     */
    protected List<Unmarshaller<AmazonServiceException, JSONObject>> exceptionUnmarshallers;

    
    /** AWS signer for authenticating requests. */
    private AWS3Signer signer;


    /**
     * Constructs a new client to invoke service methods on
     * AmazonDynamoDB using the specified AWS account credentials.
     * 
     * <p>
     * If AWS session credentials are passed in, then those credentials will be used to
     * authenticate requests.  Otherwise, if AWS long-term credentials are passed in, then
     * session management will be handled automatically by the SDK.  Callers are encouraged
     * to use long-term credentials and let the SDK handle starting and renewing sessions.
     * <p>
     * Automatically managed sessions will be shared among all clients that use
     * the same credentials and service endpoint. To opt out of this behavior,
     * explicitly provide an instance of {@link AWSCredentialsProvider} that
     * returns {@link AWSSessionCredentials}.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     */
    public AmazonDynamoDBClient(AWSCredentials awsCredentials) {
        this(awsCredentials, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonDynamoDB using the specified AWS account credentials
     * and client configuration options.
     * 
     * <p>
     * If AWS session credentials are passed in, then those credentials will be used to
     * authenticate requests.  Otherwise, if AWS long-term credentials are passed in, then
     * session management will be handled automatically by the SDK.  Callers are encouraged
     * to use long-term credentials and let the SDK handle starting and renewing sessions.
     * <p>
     * Automatically managed sessions will be shared among all clients that use
     * the same credentials and service endpoint. To opt out of this behavior,
     * explicitly provide an instance of {@link AWSCredentialsProvider} that
     * returns {@link AWSSessionCredentials}.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonDynamoDB
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonDynamoDBClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        
        if (awsCredentials instanceof AWSSessionCredentials ||
            awsCredentials instanceof NoSessionSupportCredentials) {
            this.awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
        } else {
            this.longTermCredentials = awsCredentials;
        }
        
        init();
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonDynamoDB using the specified AWS account credentials provider.
     * 
     * <p>
     * If AWS session credentials are passed in, then those credentials will be used to
     * authenticate requests.  Otherwise, if AWS long-term credentials are passed in, then
     * session management will be handled automatically by the SDK.  Callers are encouraged
     * to use long-term credentials and let the SDK handle starting and renewing sessions.
     * <p>
     * Automatically managed sessions will be shared among all clients that use
     * the same credentials and service endpoint. To opt out of this behavior,
     * explicitly provide an instance of {@link AWSCredentialsProvider} that
     * returns {@link AWSSessionCredentials}.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     */
    public AmazonDynamoDBClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonDynamoDB using the specified AWS account credentials
     * provider and client configuration options.
     * 
     * <p>
     * If AWS session credentials are passed in, then those credentials will be used to
     * authenticate requests.  Otherwise, if AWS long-term credentials are passed in, then
     * session management will be handled automatically by the SDK.  Callers are encouraged
     * to use long-term credentials and let the SDK handle starting and renewing sessions.
     * <p>
     * Automatically managed sessions will be shared among all clients that use
     * the same credentials and service endpoint. To opt out of this behavior,
     * explicitly provide an instance of {@link AWSCredentialsProvider} that
     * returns {@link AWSSessionCredentials}.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonDynamoDB
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonDynamoDBClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        
        if (awsCredentialsProvider.getCredentials() instanceof AWSSessionCredentials ||
            awsCredentialsProvider.getCredentials() instanceof NoSessionSupportCredentials) {
            this.awsCredentialsProvider = awsCredentialsProvider;
        } else {
            this.longTermCredentials = awsCredentialsProvider.getCredentials();
        }
        
        init();
    }


    private void init() {
        exceptionUnmarshallers = new ArrayList<Unmarshaller<AmazonServiceException, JSONObject>>();
        exceptionUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InternalServerErrorExceptionUnmarshaller());
        exceptionUnmarshallers.add(new ProvisionedThroughputExceededExceptionUnmarshaller());
        exceptionUnmarshallers.add(new ResourceInUseExceptionUnmarshaller());
        exceptionUnmarshallers.add(new ConditionalCheckFailedExceptionUnmarshaller());
        exceptionUnmarshallers.add(new ResourceNotFoundExceptionUnmarshaller());
        
        exceptionUnmarshallers.add(new JsonErrorUnmarshaller());
        setEndpoint("dynamodb.us-east-1.amazonaws.com/");

        signer = new AWS3Signer();

        HandlerChainFactory chainFactory = new HandlerChainFactory();
		requestHandlers.addAll(chainFactory.newRequestHandlerChain(
                "/com/amazonaws/services/dynamodb/request.handlers"));

        
        clientConfiguration = new ClientConfiguration(clientConfiguration);
        if (clientConfiguration.getMaxErrorRetry() == ClientConfiguration.DEFAULT_MAX_RETRIES) {
		    log.debug("Overriding default max error retry value to: " + 10);
		    clientConfiguration.setMaxErrorRetry(10);
		}
        setConfiguration(clientConfiguration);
    }

    
    /**
     * <p>
     * The Scan operation returns one or more items and its attributes by
     * performing a full scan of a table. Limit the returned results by
     * specifying a filter.
     * </p>
     *
     * @param scanRequest Container for the necessary parameters to execute
     *           the Scan service method on AmazonDynamoDB.
     * 
     * @return The response from the Scan service method, as returned by
     *         AmazonDynamoDB.
     * 
     * @throws ProvisionedThroughputExceededException
     * @throws InternalServerErrorException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonDynamoDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ScanResult scan(ScanRequest scanRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<ScanRequest> request = new ScanRequestMarshaller().marshall(scanRequest);
        return invoke(request, new ScanResultJsonUnmarshaller());
    }
    
    /**
     * <p>
     * The CreateTable operation adds a new table to your account. The table
     * name must be unique among those associated with the AWS Account
     * issuing the request, and the AWS Region that receives the request
     * (e.g. us-east-1). The CreateTable operation triggers an asynchronous
     * workflow to begin creating the table. Amazon DynamoDB immediately
     * returns the state of the table (CREATING) until the table is in the
     * ACTIVE state. Once the table is in the ACTIVE state, you can perform
     * data plane operations.
     * </p>
     *
     * @param createTableRequest Container for the necessary parameters to
     *           execute the CreateTable service method on AmazonDynamoDB.
     * 
     * @return The response from the CreateTable service method, as returned
     *         by AmazonDynamoDB.
     * 
     * @throws ResourceInUseException
     * @throws LimitExceededException
     * @throws InternalServerErrorException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonDynamoDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateTableResult createTable(CreateTableRequest createTableRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<CreateTableRequest> request = new CreateTableRequestMarshaller().marshall(createTableRequest);
        return invoke(request, new CreateTableResultJsonUnmarshaller());
    }
    
    /**
     * <p>
     * Returns a paginated list of table names created by the AWS Account of
     * the caller in the AWS Region (e.g. us-east-1).
     * </p>
     *
     * @param listTablesRequest Container for the necessary parameters to
     *           execute the ListTables service method on AmazonDynamoDB.
     * 
     * @return The response from the ListTables service method, as returned
     *         by AmazonDynamoDB.
     * 
     * @throws InternalServerErrorException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonDynamoDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTablesResult listTables(ListTablesRequest listTablesRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<ListTablesRequest> request = new ListTablesRequestMarshaller().marshall(listTablesRequest);
        return invoke(request, new ListTablesResultJsonUnmarshaller());
    }
    
    /**
     * <p>
     * The Query operation gets the values of one or more items and its
     * attributes by primary key (composite primary key, only). Narrow the
     * scope of the query using comparison operators on the RangeKeyValue of
     * the composite key. Use the ScanIndexForward parameter to get results
     * in forward or reverse order by range key.
     * </p>
     *
     * @param queryRequest Container for the necessary parameters to execute
     *           the Query service method on AmazonDynamoDB.
     * 
     * @return The response from the Query service method, as returned by
     *         AmazonDynamoDB.
     * 
     * @throws ProvisionedThroughputExceededException
     * @throws InternalServerErrorException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonDynamoDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public QueryResult query(QueryRequest queryRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<QueryRequest> request = new QueryRequestMarshaller().marshall(queryRequest);
        return invoke(request, new QueryResultJsonUnmarshaller());
    }
    
    /**
     * <p>
     * Edits an existing item's attributes. You can perform a conditional
     * update (insert a new attribute name-value pair if it doesn't exist, or
     * replace an existing name-value pair if it has certain expected
     * attribute values).
     * </p>
     *
     * @param updateItemRequest Container for the necessary parameters to
     *           execute the UpdateItem service method on AmazonDynamoDB.
     * 
     * @return The response from the UpdateItem service method, as returned
     *         by AmazonDynamoDB.
     * 
     * @throws ProvisionedThroughputExceededException
     * @throws ConditionalCheckFailedException
     * @throws InternalServerErrorException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonDynamoDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public UpdateItemResult updateItem(UpdateItemRequest updateItemRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<UpdateItemRequest> request = new UpdateItemRequestMarshaller().marshall(updateItemRequest);
        return invoke(request, new UpdateItemResultJsonUnmarshaller());
    }
    
    /**
     * <p>
     * Updates the provisioned throughput for the given table. Setting the
     * throughput for a table helps you manage performance and is part of the
     * Provisioned Capacity feature of Amazon DynamoDB.
     * </p>
     *
     * @param updateTableRequest Container for the necessary parameters to
     *           execute the UpdateTable service method on AmazonDynamoDB.
     * 
     * @return The response from the UpdateTable service method, as returned
     *         by AmazonDynamoDB.
     * 
     * @throws ResourceInUseException
     * @throws LimitExceededException
     * @throws InternalServerErrorException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonDynamoDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public UpdateTableResult updateTable(UpdateTableRequest updateTableRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<UpdateTableRequest> request = new UpdateTableRequestMarshaller().marshall(updateTableRequest);
        return invoke(request, new UpdateTableResultJsonUnmarshaller());
    }
    
    /**
     * <p>
     * Creates a new item, or replaces an old item with a new item
     * (including all the attributes). If an item already exists in the
     * specified table with the same primary key, the new item completely
     * replaces the existing item. You can perform a conditional put (insert
     * a new item if one with the specified primary key doesn't exist), or
     * replace an existing item if it has certain attribute values.
     * </p>
     *
     * @param putItemRequest Container for the necessary parameters to
     *           execute the PutItem service method on AmazonDynamoDB.
     * 
     * @return The response from the PutItem service method, as returned by
     *         AmazonDynamoDB.
     * 
     * @throws ProvisionedThroughputExceededException
     * @throws ConditionalCheckFailedException
     * @throws InternalServerErrorException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonDynamoDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public PutItemResult putItem(PutItemRequest putItemRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<PutItemRequest> request = new PutItemRequestMarshaller().marshall(putItemRequest);
        return invoke(request, new PutItemResultJsonUnmarshaller());
    }
    
    /**
     * <p>
     * The DeleteTable operation deletes a table and all of its items. If
     * the table is in the ACTIVE state, you can delete it. If a table is in
     * CREATING or UPDATING states, then DeleteTable returns a
     * ResourceInUseException. If the specified table does not exist, Amazon
     * DynamoDB returns a ResourceNotFoundException.
     * </p>
     *
     * @param deleteTableRequest Container for the necessary parameters to
     *           execute the DeleteTable service method on AmazonDynamoDB.
     * 
     * @return The response from the DeleteTable service method, as returned
     *         by AmazonDynamoDB.
     * 
     * @throws ResourceInUseException
     * @throws LimitExceededException
     * @throws InternalServerErrorException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonDynamoDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DeleteTableResult deleteTable(DeleteTableRequest deleteTableRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<DeleteTableRequest> request = new DeleteTableRequestMarshaller().marshall(deleteTableRequest);
        return invoke(request, new DeleteTableResultJsonUnmarshaller());
    }
    
    /**
     * <p>
     * Deletes a single item in a table by primary key. You can perform a
     * conditional delete operation that deletes the item if it exists, or if
     * it has an expected attribute value.
     * </p>
     *
     * @param deleteItemRequest Container for the necessary parameters to
     *           execute the DeleteItem service method on AmazonDynamoDB.
     * 
     * @return The response from the DeleteItem service method, as returned
     *         by AmazonDynamoDB.
     * 
     * @throws ProvisionedThroughputExceededException
     * @throws ConditionalCheckFailedException
     * @throws InternalServerErrorException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonDynamoDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DeleteItemResult deleteItem(DeleteItemRequest deleteItemRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<DeleteItemRequest> request = new DeleteItemRequestMarshaller().marshall(deleteItemRequest);
        return invoke(request, new DeleteItemResultJsonUnmarshaller());
    }
    
    /**
     * <p>
     * Returns information about the table, including the current status of
     * the table, the primary key schema and when the table was created. If
     * the table does not exist, the server returns a
     * ResourceNotFoundException.
     * </p>
     *
     * @param describeTableRequest Container for the necessary parameters to
     *           execute the DescribeTable service method on AmazonDynamoDB.
     * 
     * @return The response from the DescribeTable service method, as
     *         returned by AmazonDynamoDB.
     * 
     * @throws InternalServerErrorException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonDynamoDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeTableResult describeTable(DescribeTableRequest describeTableRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<DescribeTableRequest> request = new DescribeTableRequestMarshaller().marshall(describeTableRequest);
        return invoke(request, new DescribeTableResultJsonUnmarshaller());
    }
    
    /**
     * <p>
     * The GetItem operation returns a set of Attributes for an item that
     * matches the primary key. The GetItem operation provides an eventually
     * consistent read by default. If eventually consistent reads are not
     * acceptable for your application, use ConsistentRead. Although this
     * operation might take longer than a standard read, it always returns
     * the last updated value.
     * </p>
     *
     * @param getItemRequest Container for the necessary parameters to
     *           execute the GetItem service method on AmazonDynamoDB.
     * 
     * @return The response from the GetItem service method, as returned by
     *         AmazonDynamoDB.
     * 
     * @throws ProvisionedThroughputExceededException
     * @throws InternalServerErrorException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonDynamoDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetItemResult getItem(GetItemRequest getItemRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<GetItemRequest> request = new GetItemRequestMarshaller().marshall(getItemRequest);
        return invoke(request, new GetItemResultJsonUnmarshaller());
    }
    
    /**
     * <p>
     * The BatchGetItem operation returns the attributes for multiple items
     * from multiple tables using their primary keys. The maximum number of
     * item attributes that can be retrieved for a single operation is 100.
     * Also, the number of items retrieved is constrained by a 1 MB the size
     * limit. If the response size limit is exceeded or a partial result is
     * returned due to an internal processing failure, Amazon DynamoDB
     * returns an UnprocessedKeys value so you can retry the operation
     * starting with the next item to get. Amazon DynamoDB automatically
     * adjusts the number of items returned per page to enforce this limit.
     * For example, even if you ask to retrieve 100 items, but each
     * individual item is 50 KB in size, the system returns 20 items and an
     * appropriate UnprocessedKeys value so you can get the next page of
     * results. If necessary, your application needs its own logic to
     * assemble the pages of results into one set.
     * </p>
     *
     * @param batchGetItemRequest Container for the necessary parameters to
     *           execute the BatchGetItem service method on AmazonDynamoDB.
     * 
     * @return The response from the BatchGetItem service method, as returned
     *         by AmazonDynamoDB.
     * 
     * @throws ProvisionedThroughputExceededException
     * @throws InternalServerErrorException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonDynamoDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public BatchGetItemResult batchGetItem(BatchGetItemRequest batchGetItemRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<BatchGetItemRequest> request = new BatchGetItemRequestMarshaller().marshall(batchGetItemRequest);
        return invoke(request, new BatchGetItemResultJsonUnmarshaller());
    }
    
    /**
     * <p>
     * Returns a paginated list of table names created by the AWS Account of
     * the caller in the AWS Region (e.g. us-east-1).
     * </p>
     * 
     * @return The response from the ListTables service method, as returned
     *         by AmazonDynamoDB.
     * 
     * @throws InternalServerErrorException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonDynamoDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTablesResult listTables() throws AmazonServiceException, AmazonClientException {
        return listTables(new ListTablesRequest());
    }
    
    /**
     * Setting the endpoint will also change the session credentials provider,
     * if it's being automatically managed.
     */
    @Override
    public void setEndpoint(String endpoint) throws IllegalArgumentException {
        super.setEndpoint(endpoint);
        
        if ( this.longTermCredentials != null ) {
            this.awsCredentialsProvider = SessionCredentialsProviderFactory.getSessionCredentialsProvider(
                    this.longTermCredentials, endpoint, clientConfiguration);
        }
    }
    

    /**
     * Returns additional metadata for a previously executed successful, request, typically used for
     * debugging issues where a service isn't acting as expected.  This data isn't considered part
     * of the result data returned by an operation, so it's available through this separate,
     * diagnostic interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you need to access
     * this extra diagnostic information for an executed request, you should use this method
     * to retrieve it as soon as possible after executing the request.
     *
     * @param request
     *            The originally executed request
     *
     * @return The response metadata for the specified request, or null if none
     *         is available.
     */
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    private <X, Y extends AmazonWebServiceRequest> X invoke(Request<Y> request, Unmarshaller<X, JsonUnmarshallerContext> unmarshaller) {
        request.setEndpoint(endpoint);

        AWSCredentials credentials = awsCredentialsProvider.getCredentials();
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (originalRequest != null && originalRequest.getRequestCredentials() != null) {
        	credentials = originalRequest.getRequestCredentials();
        }

        ExecutionContext executionContext = createExecutionContext();
        executionContext.setSigner(signer);
        executionContext.setCredentials(credentials);
        executionContext.setCustomBackoffStrategy(com.amazonaws.internal.DynamoDBBackoffStrategy.DEFAULT);
        JsonResponseHandler<X> responseHandler = new JsonResponseHandler<X>(unmarshaller);
        JsonErrorResponseHandler errorResponseHandler = new JsonErrorResponseHandler(exceptionUnmarshallers);

        return (X)client.execute(request, responseHandler, errorResponseHandler, executionContext);
    }
}
        