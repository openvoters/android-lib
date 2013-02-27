package org.openvoters.android.remote.callback;

public interface RemoteAPICallback {

	/**
	 * Defines the behavior after a successful remote API call
	 * 
	 * @param params
	 *            the list of parameter to be handled
	 */
	public void onSuccess(Object... params);

	/**
	 * Defines the behavior after an error while calling a remote API
	 * 
	 * @param e
	 *            the exception thrown during the API call
	 */
	public void onError(Exception e);

}
