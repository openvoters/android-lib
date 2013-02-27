package org.openvoters.android.remote.callback;

import java.util.List;

import org.openvoters.android.data.Item;

/**
 * Callback class to handle results of the "get list" API calls
 * 
 */
public abstract class RemoteAPIGetListCallback implements RemoteAPICallback {

	@Override
	public void onSuccess(Object... params) {
		// TODO Auto-generated method stub
	}

	@Override
	public abstract void onError(Exception e);

	/**
	 * Defines the behavior after a successful reading of the remote list of
	 * available items
	 * 
	 * @param items
	 *            the list of the available items
	 */
	public abstract void onSuccess(List<Item> items);

}
