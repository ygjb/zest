/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.zest.core.v1;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Interface ZestRunner.
 */
public interface ZestRunner {

	/**
	 * Run.
	 *
	 * @param script the script
	 * @throws ZestAssertFailException the zest assert fail exception
	 * @throws ZestActionFailException the zest action fail exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ZestInvalidCommonTestException the zest invalid common test exception
	 * @throws ZestAssignFailException the zest assign fail exception
	 */
	void run (ZestScript script) 
			throws ZestAssertFailException, ZestActionFailException, IOException,
			ZestInvalidCommonTestException, ZestAssignFailException;

	/**
	 * Run script.
	 *
	 * @param reader the reader
	 * @throws ZestAssertFailException the zest assert fail exception
	 * @throws ZestActionFailException the zest action fail exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ZestInvalidCommonTestException the zest invalid common test exception
	 * @throws ZestAssignFailException the zest assign fail exception
	 */
	void runScript (Reader reader) 
			throws ZestAssertFailException, ZestActionFailException, IOException,
			ZestInvalidCommonTestException, ZestAssignFailException;
	
	/**
	 * Run script.
	 *
	 * @param script the script
	 * @throws ZestAssertFailException the zest assert fail exception
	 * @throws ZestActionFailException the zest action fail exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ZestInvalidCommonTestException the zest invalid common test exception
	 * @throws ZestAssignFailException the zest assign fail exception
	 */
	void runScript (String script) 
			throws ZestAssertFailException, ZestActionFailException, IOException,
			ZestInvalidCommonTestException, ZestAssignFailException;
	
	/**
	 * Run.
	 *
	 * @param script the script
	 * @param target the target
	 * @throws ZestAssertFailException the zest assert fail exception
	 * @throws ZestActionFailException the zest action fail exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ZestInvalidCommonTestException the zest invalid common test exception
	 * @throws ZestAssignFailException the zest assign fail exception
	 */
	void run (ZestScript script, ZestRequest target) 
			throws ZestAssertFailException, ZestActionFailException, IOException,
			ZestInvalidCommonTestException, ZestAssignFailException;

	/**
	 * Run statement.
	 *
	 * @param script the script
	 * @param stmt the stmt
	 * @param lastResponse the last response
	 * @return the zest response
	 * @throws ZestAssertFailException the zest assert fail exception
	 * @throws ZestActionFailException the zest action fail exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ZestInvalidCommonTestException the zest invalid common test exception
	 * @throws ZestAssignFailException the zest assign fail exception
	 */
	ZestResponse runStatement(ZestScript script, ZestStatement stmt, ZestResponse lastResponse) 
			throws ZestAssertFailException, ZestActionFailException, IOException,
			ZestInvalidCommonTestException, ZestAssignFailException;

	/**
	 * Send.
	 *
	 * @param request the request
	 * @return the zest response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	ZestResponse send (ZestRequest request) throws IOException;
	
	/**
	 * Handle response.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ZestAssertFailException the zest assert fail exception
	 * @throws ZestActionFailException the zest action fail exception
	 */
	void handleResponse (ZestRequest request, ZestResponse response) 
			throws ZestAssertFailException, ZestActionFailException;
	
	/**
	 * Handle action.
	 *
	 * @param script the script
	 * @param action the action
	 * @param lastResponse the last response
	 * @return the string
	 * @throws ZestActionFailException the zest action fail exception
	 */
	String handleAction(ZestScript script, ZestAction action, ZestResponse lastResponse) throws ZestActionFailException;

	/**
	 * Handle an assignment.
	 *
	 * @param script the script
	 * @param assign the assignment
	 * @param lastResponse the last response
	 * @return the string
	 * @throws ZestAssignFailException the zest assignment fail exception
	 */
	String handleAssignment(ZestScript script, ZestAssignment assign, ZestResponse lastResponse) throws ZestAssignFailException;
	
	ZestResponse handleLoop(ZestScript script, ZestLoop<?> loop, ZestResponse lastResponse) throws ZestAssertFailException, ZestActionFailException, ZestInvalidCommonTestException, IOException, ZestAssignFailException;
	
	/**
	 * Response passed.
	 *
	 * @param request the request
	 * @param response the response
	 * @param assertion the assertion
	 */
	void responsePassed (ZestRequest request, ZestResponse response, ZestAssertion assertion);

	/**
	 * Response failed.
	 *
	 * @param request the request
	 * @param response the response
	 * @param assertion the assertion
	 * @throws ZestAssertFailException the zest assert fail exception
	 */
	void responseFailed (ZestRequest request, ZestResponse response, ZestAssertion assertion) throws ZestAssertFailException;
	
	/**
	 * Response passed.
	 *
	 * @param request the request
	 * @param response the response
	 */
	void responsePassed (ZestRequest request, ZestResponse response);

	/**
	 * Response failed.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ZestAssertFailException the zest assert fail exception
	 */
	void responseFailed (ZestRequest request, ZestResponse response) throws ZestAssertFailException;
	
	/**
	 * Sets the stop on assert fail.
	 *
	 * @param stop the new stop on assert fail
	 */
	void setStopOnAssertFail(boolean stop);
	
	/**
	 * Sets the stop on test fail.
	 *
	 * @param stop the new stop on test fail
	 */
	void setStopOnTestFail(boolean stop);

	/**
	 * Gets the stop on assert fail.
	 *
	 * @return the stop on assert fail
	 */
	boolean getStopOnAssertFail();
	
	/**
	 * Gets the stop on test fail.
	 *
	 * @return the stop on test fail
	 */
	boolean getStopOnTestFail();
	
	/**
	 * Sets the proxy.
	 *
	 * @param host the host
	 * @param port the port
	 */
	void setProxy(String host, int port);

	/**
	 * Sets the output writer.
	 *
	 * @param writer the new output writer
	 */
	void setOutputWriter(Writer writer);

	/**
	 * Gets the variable.
	 *
	 * @param name the name
	 * @return the variable
	 */
	String getVariable(String name);
	
	/**
	 * Sets the variable.
	 *
	 * @param name the name
	 * @param value the value
	 */
	void setVariable (String name, String value);

	/**
	 * Sets the variables.
	 *
	 * @param variables the variables
	 */
	void setVariables (Map<String, String> variables);
}
