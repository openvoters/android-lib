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
