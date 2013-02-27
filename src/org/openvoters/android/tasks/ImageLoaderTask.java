package org.openvoters.android.tasks;

import java.util.List;

import org.openvoters.android.data.Item;
import org.openvoters.android.remote.RemoteUtils;
import org.openvoters.android.remote.callback.RemoteAPICallback;

import android.app.ProgressDialog;
import android.os.AsyncTask;

public class ImageLoaderTask extends AsyncTask<List<Item>, Integer, Boolean> {

	public ProgressDialog progress;
	public RemoteAPICallback callback;
	boolean error = false;

	@Override
	protected Boolean doInBackground(List<Item>... params) {
		List<Item> items = params[0];

		if (this.progress != null)
			progress.setMax(items.size());

		try {
			for (Item item : items) {
				item.setImage(RemoteUtils.loadBitmap(item.getImageUrl()));
				publishProgress(items.indexOf(item) + 1);
			}
		} catch (Exception e) {
			error = true;
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);

		if (this.progress != null)
			progress.setProgress(values[0]);
	}

	@Override
	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);

		if (this.progress != null)
			progress.dismiss();
		callback.onSuccess();
	}

}
