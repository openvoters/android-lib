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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONException;
import org.json.JSONObject;
import org.openvoters.android.data.Item;
import org.openvoters.android.remote.RemoteAPI;
import org.openvoters.android.remote.callback.RemoteAPICallback;

import android.graphics.Bitmap;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;

public class RemoteAPIGetListTask extends
		AsyncTask<RemoteAPICallback, Void, JSONObject> {

	RemoteAPICallback callback;
	List<Bitmap> images = new ArrayList<Bitmap>();
	List<String> names = new ArrayList<String>();
	List<Item> items = new ArrayList<Item>();

	boolean taskError = false;
	Exception exc;

	@Override
	protected JSONObject doInBackground(RemoteAPICallback... params) {
		if (params.length > 0) {
			callback = params[0];
		}

		JSONObject result = null;
		AndroidHttpClient httpClient = AndroidHttpClient.newInstance("");

		try {
			HttpGet request = new HttpGet(String.format("%s/%s",
					RemoteAPI.getBaseURL(), "getlist"));
			HttpResponse response = httpClient.execute(request);

			InputStream input = response.getEntity().getContent();
			java.util.Scanner s = new java.util.Scanner(input)
					.useDelimiter("\\A");
			String responseString = s.hasNext() ? s.next() : "";

			JSONObject obj = new JSONObject(responseString);
			httpClient.close();
			result = obj;
		} catch (Exception e) {
			httpClient.close();
			taskError = true;
			exc = e;
			return null;
		}

		httpClient.close();

		elabora(result);
		return result;
	}

	private void elabora(JSONObject result) {
		JSONObject piece = null;
		int i = 0;

		try {
			while (true) {
				boolean error = false;
				try {
					piece = result.getJSONObject(String.format("c%d", i++));
				} catch (JSONException e) {
					error = true;
				}

				if (!error) {
					items.add(new Item(piece));
				} else {
					break;
				}
			}
		} catch (Exception e) {
			taskError = true;
			exc = e;
			return;
		}
	}

	protected void onPostExecute(JSONObject result) {
		if (callback != null)
			if (!taskError) {
				callback.onSuccess(items, images, names);
			} else {
				callback.onError(exc);
			}
	}

}
