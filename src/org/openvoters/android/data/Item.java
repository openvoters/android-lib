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

package org.openvoters.android.data;

import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;

public class Item {
	private String name;
	private String imageUrl;
	private String ID;
	private String twitterID;
	private transient Bitmap image;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTwitterID() {
		return twitterID;
	}

	public void setTwitterID(String twitterID) {
		this.twitterID = twitterID;
	}

	public Bitmap getImage() {
		return image;
	}

	public void setImage(Bitmap image) {
		this.image = image;
	}

	public Item(JSONObject piece) throws JSONException {
		name = piece.getString("name");
		imageUrl = piece.getString("imageUrl");
		ID = piece.getString("ID");
		twitterID = piece.getString("twitterId");
	}

	public String toString() {
		return String.format("%s (%s)", name, ID);
	}

}
