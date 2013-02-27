package org.openvoters.android.remote;

import org.openvoters.android.data.Item;
import org.openvoters.android.remote.callback.RemoteAPIGetListCallback;
import org.openvoters.android.remote.callback.RemoteAPIVoteCallback;
import org.openvoters.android.tasks.RemoteAPIGetListTask;
import org.openvoters.android.tasks.RemoteAPIVoteTask;

public class RemoteAPI {

	private static String baseURL;

	public static void getlist(RemoteAPIGetListCallback callback) {
		RemoteAPIGetListTask task = new RemoteAPIGetListTask();
		task.execute(callback);
	}

	public static void vote(Item item, String uniqueVoterID,
			RemoteAPIVoteCallback callback) {
		RemoteAPIVoteTask task = new RemoteAPIVoteTask();
		task.execute(callback, item, uniqueVoterID);
	}

	public static void setBaseURL(String baseURL) {
		RemoteAPI.baseURL = baseURL;
	}

	public static String getBaseURL() {
		return baseURL;
	}
}
