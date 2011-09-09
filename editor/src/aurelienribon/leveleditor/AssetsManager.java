package aurelienribon.leveleditor;

import aurelienribon.leveleditor.models.AssetInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EventListener;
import java.util.List;
import javax.swing.event.EventListenerList;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class AssetsManager {
	// -------------------------------------------------------------------------
	// Singleton
	// -------------------------------------------------------------------------

	private static final AssetsManager instance = new AssetsManager();
	public static AssetsManager instance() {return instance;}

	// -------------------------------------------------------------------------
	// Content
	// -------------------------------------------------------------------------

	private final List<AssetInfo> assets = new ArrayList<AssetInfo>();

	public List<AssetInfo> getAssetsList() {
		return Collections.unmodifiableList(assets);
	}

	public AssetInfo getAsset(int idx) {
		assert 0 <= idx && idx < assets.size();
		return assets.get(idx);
	}

	public void addAsset(AssetInfo asset) {
		assert asset != null;
		assert !assets.contains(asset);
		assets.add(asset);
		List<AssetInfo> list = new ArrayList<AssetInfo>();
		list.add(asset);
		list = Collections.unmodifiableList(list);
		fireAssetsAdded(list);
	}

	public void addAssets(List<AssetInfo> assets) {
		for (AssetInfo asset : assets) {
			assert !this.assets.contains(asset);
			this.assets.add(asset);
		}
		List<AssetInfo> list = new ArrayList<AssetInfo>(assets);
		list = Collections.unmodifiableList(list);
		fireAssetsAdded(list);
	}

	public void removeAsset(int idx) {
		List<AssetInfo> list = new ArrayList<AssetInfo>();
		assert 0 <= idx && idx < assets.size();
		list.add(assets.remove(idx));
		list = Collections.unmodifiableList(list);
		fireAssetsRemoved(list);
	}

	public void removeAssets(int[] idxs) {
		if (idxs.length == 0)
			return;
		List<AssetInfo> list = new ArrayList<AssetInfo>(assets);
		Arrays.sort(idxs);
		for (int i=idxs.length-1; i>=0; i--) {
			int idx = idxs[i];
			assert 0 <= idx && idx < assets.size();
			list.add(assets.remove(idx));
		}
		list = Collections.unmodifiableList(list);
		fireAssetsRemoved(list);
	}

	public void moveUp(AssetInfo asset) {
		assert assets.contains(asset);
		int idx = assets.indexOf(asset);
		if (idx > 0)
			Collections.swap(assets, idx, idx-1);
	}

	public void moveDown(AssetInfo asset) {
		assert assets.contains(asset);
		int idx = assets.indexOf(asset);
		if (idx < assets.size()-1)
			Collections.swap(assets, idx, idx+1);
	}

	public void notifyAssetsUpdated() {
		fireAssetsUpdated();
	}

	// -------------------------------------------------------------------------
	// Events
	// -------------------------------------------------------------------------

	private final EventListenerList listeners = new EventListenerList();

	public interface Listener extends EventListener {
		public void assetsAdded(List<AssetInfo> assets);
		public void assetsRemoved(List<AssetInfo> assets);
		public void assetsUpdated();
	}

	public void addListener(Listener listener) {
		listeners.add(Listener.class, listener);
	}

	public void removeListener(Listener listener) {
		listeners.remove(Listener.class, listener);
	}

	private void fireAssetsAdded(List<AssetInfo> assets) {
		for (Listener listener : listeners.getListeners(Listener.class))
			listener.assetsAdded(assets);
	}

	private void fireAssetsRemoved(List<AssetInfo> assets) {
		for (Listener listener : listeners.getListeners(Listener.class))
			listener.assetsRemoved(assets);
	}

	private void fireAssetsUpdated() {
		for (Listener listener : listeners.getListeners(Listener.class))
			listener.assetsUpdated();
	}
}
