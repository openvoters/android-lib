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
