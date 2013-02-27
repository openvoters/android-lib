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
