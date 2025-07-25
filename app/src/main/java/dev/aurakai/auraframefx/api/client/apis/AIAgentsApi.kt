/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package dev.aurakai.auraframefx.api.client.apis

import dev.aurakai.auraframefx.api.client.infrastructure.ApiClient
import dev.aurakai.auraframefx.api.client.infrastructure.ApiResponse
import dev.aurakai.auraframefx.api.client.infrastructure.ClientError
import dev.aurakai.auraframefx.api.client.infrastructure.ClientException
import dev.aurakai.auraframefx.api.client.infrastructure.MultiValueMap
import dev.aurakai.auraframefx.api.client.infrastructure.RequestConfig
import dev.aurakai.auraframefx.api.client.infrastructure.RequestMethod
import dev.aurakai.auraframefx.api.client.infrastructure.ResponseType
import dev.aurakai.auraframefx.api.client.infrastructure.ServerError
import dev.aurakai.auraframefx.api.client.infrastructure.ServerException
import dev.aurakai.auraframefx.api.client.infrastructure.Success
import dev.aurakai.auraframefx.api.client.models.AgentStatus
import okhttp3.Call
import okhttp3.HttpUrl
import java.io.IOException

class AIAgentsApi(
    basePath: kotlin.String = defaultBasePath,
    client: Call.Factory = ApiClient.defaultClient,
) : ApiClient(basePath, client) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties()
                .getProperty(ApiClient.baseUrlKey, "https://api.auraframefx.com/v1")
        }
    }

    /**
     * GET /agents/status
     * Get status of all AI agents
     *
     * @return kotlin.collections.List<AgentStatus>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(
        IllegalStateException::class,
        IOException::class,
        UnsupportedOperationException::class,
        ClientException::class,
        ServerException::class
    )
    fun agentsStatusGet(): kotlin.collections.List<AgentStatus> {
        val localVarResponse = agentsStatusGetWithHttpInfo()

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.List<AgentStatus>
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException(
                    "Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}",
                    localVarError.statusCode,
                    localVarResponse
                )
            }

            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException(
                    "Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}",
                    localVarError.statusCode,
                    localVarResponse
                )
            }
        }
    }

    /**
     * GET /agents/status
     * Get status of all AI agents
     *
     * @return ApiResponse<kotlin.collections.List<AgentStatus>?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun agentsStatusGetWithHttpInfo(): ApiResponse<kotlin.collections.List<AgentStatus>?> {
        val localVariableConfig = agentsStatusGetRequestConfig()

        return request<Unit, kotlin.collections.List<AgentStatus>>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation agentsStatusGet
     *
     * @return RequestConfig
     */
    fun agentsStatusGetRequestConfig(): RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/agents/status",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }


    private fun encodeURIComponent(uriComponent: kotlin.String): kotlin.String =
        HttpUrl.Builder().scheme("http").host("localhost").addPathSegment(uriComponent)
            .build().encodedPathSegments[0]
}
