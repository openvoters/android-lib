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

import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class RemoteUtils {
	public static Bitmap loadBitmap(String url) {
		Bitmap result = null;
		try {
			URL newurl = new URL(url);
			result = BitmapFactory.decodeStream(newurl.openConnection()
					.getInputStream());

		} catch (Exception e) {
			Log.e("OpenVoters Utils",
					"Error while loading remote image: "
							+ e.getLocalizedMessage());
		}

		return result;
	}
}
