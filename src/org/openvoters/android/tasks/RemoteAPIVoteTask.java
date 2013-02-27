/*
 *   This file is part of OpenVoters, the open library for mobile voting.
 *
 *   OpenVoters is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   OpenVoters is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with OpenVoters.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.openvoters.android.tasks;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;
import org.openvoters.android.data.Item;
import org.openvoters.android.remote.RemoteAPI;
import org.openvoters.android.remote.callback.RemoteAPICallback;

import android.os.AsyncTask;
import android.util.Log;

public class RemoteAPIVoteTask extends AsyncTask<Object, Void, Boolean> {

	RemoteAPICallback callback;
	Exception exc;
	String uniqueVoterID;

	@Override
	protected Boolean doInBackground(Object... params) {
		callback = (RemoteAPICallback) params[0];
		Item party = (Item) params[1];
		uniqueVoterID = (String) params[2];

		Log.d("Remote API", "Called");

		try {
			String remoteAPIURL = String.format("%s/%s",
					RemoteAPI.getBaseURL(), "vote");
			makeRequest(remoteAPIURL, party, uniqueVoterID);
			return Boolean.TRUE;

		} catch (Exception e) {
			Log.e("Remote API", String.format("Errore (%s): %s", e,
					e.getLocalizedMessage()));

			e.printStackTrace();
			exc = e;
			return Boolean.FALSE;
		}
	}

	@Override
	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);

		if (callback != null) {
			if (result) {
				callback.onSuccess();
			} else {
				callback.onError(exc);
			}
		}
	}

	public static HttpResponse makeRequest(String path, Item item,
			String uniqueID) throws Exception {
		JSONObject holder = new JSONObject();
		holder.put("candidate", item.getID());
		holder.put("ID", uniqueID);

		int TIMEOUT_MILLISEC = 10000; // = 10 seconds
		HttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT_MILLISEC);
		HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
		HttpClient client = new DefaultHttpClient(httpParams);

		HttpPost request = new HttpPost(path);
		request.setEntity(new ByteArrayEntity(holder.toString()
				.getBytes("UTF8")));
		HttpResponse response = client.execute(request);
		return response;
	}
}
