package org.openvoters.android.remote.callback;

/**
 * Callback class to handle results of the voting-dedicated API calls
 * 
 */
public abstract class RemoteAPIVoteCallback implements RemoteAPICallback {

	@Override
	public void onSuccess(Object... params) {
		this.onSuccess();
	}

	@Override
	public abstract void onError(Exception e);

	/**
	 * Defines the behavior after a vote has been successfully registered
	 */
	public abstract void onSuccess();

}
