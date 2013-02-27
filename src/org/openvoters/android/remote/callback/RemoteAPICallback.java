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
