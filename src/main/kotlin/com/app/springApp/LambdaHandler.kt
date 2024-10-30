package com.app.springApp

import com.amazonaws.serverless.proxy.model.AwsProxyRequest
import com.amazonaws.serverless.proxy.model.AwsProxyResponse
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import java.io.InputStream
import java.io.OutputStream

class LambdaHandler : RequestStreamHandler {

  companion object {
    private val handler: SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> =
      SpringBootLambdaContainerHandler.getAwsProxyHandler(SpringApp::class.java)
  }

  override fun handleRequest(input: InputStream?, output: OutputStream?, context: Context?) {
    try {
      // Handle requests via Spring Boot handler
      handler.proxyStream(input, output, context)
    } finally {
      output?.flush() // Ensure the response is sent properly
    }
  }
}

