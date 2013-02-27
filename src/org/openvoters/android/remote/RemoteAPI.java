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
